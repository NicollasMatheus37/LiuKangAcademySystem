package view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import dao.ModalidadeDAO;
import dao.GraduacaoDAO;
import model.GraduacaoModel;
import model.ModalidadeModel;

@SuppressWarnings("serial")
public class ModalidadesGraduacoes extends MasterDialogCad {

	private JButton btnOk;
	private ModalidadeModel modalidade, modalidadeChange;
	private GraduacaoModel graduacao;
	private ArrayList<GraduacaoModel> graduacoes, graduacoesChange;
	private ModalidadeDAO modalidadeDAO;
	private GraduacaoDAO graduacaoDAO;
	private BuscarModalidade busca;
	private String oldModalidade;

	//labels
	private JLabel lblModalidade, lblGraduacao, lblTip;

	//Text Fields
	private JTextField txtModalidade, txtGraduacao;

	//tabela e modelo
	private JTable table;
	private DefaultTableModel model;


	public ModalidadesGraduacoes() {

		modalidadeDAO = new ModalidadeDAO();
		graduacaoDAO= new GraduacaoDAO();

		setLayout(null);
		setSize(510, 350);
		setTitle("Modalidades e Graduações");
		setResizable(false);
		setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setVisible(true);

	}
	
	protected boolean actionDelete() {
		try {
			graduacaoDAO.deleteGraduacoes(oldModalidade);
			modalidadeDAO.deleteModalidade(oldModalidade);
			return true;
		} catch (Exception e) {
			return false;
		}
			
	}

	protected void actionSearch() {
		busca = new BuscarModalidade();
		try {
			busca.addWindowListener(eventWindowSearchClosed);
		} catch (Exception e2) {
			busca = null;
		}
	}

	protected boolean afterSearch() {
		try {
			if(busca.modalidadeReturn!=null) {
				graduacao = new GraduacaoModel();
				modalidade = busca.modalidadeReturn;
				oldModalidade = modalidade.getModalidade();
				return true;
			}	
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	protected boolean actionSave() {
		try {
			if (graduacoesChange.size()>0) {
				if(isInserting) {
					modalidadeDAO.createModalidade(modalidadeChange);
				}else {	
					if(modalidade.getModalidade().trim().equals(oldModalidade.trim())) {
						modalidadeDAO.updateModalidade(oldModalidade ,modalidadeChange.getModalidade());
					}
				}
				graduacaoDAO.insertGraduacoes(graduacoesChange, modalidadeChange.getModalidade());
				return true;
			}else {
				JOptionPane.showMessageDialog(null,"Insira ao menos uma graduação");
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}

	protected boolean actionCancel() {
		try {
			modalidade = null;
			modalidadeChange = null;
			graduacao = null;
			graduacoes = null;			
			graduacoesChange =null;
			model.setRowCount(0);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	protected boolean actionAdd() {

		try {

			modalidade = new ModalidadeModel();			
			graduacao = new GraduacaoModel();
			graduacoesChange = new ArrayList<>();
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	protected void fillFields() {

		txtModalidade.setText(modalidade.getModalidade());
		findGrad();

		modalidadeChange = modalidade;

	}

	private void findGrad() {
		try {
			if(!modalidade.getModalidade().trim().isEmpty()) {
				graduacoes = graduacaoDAO.getAllGraduacoes(modalidade.getModalidade());				
				graduacoesChange = graduacoes;				
			}
		} catch (SQLException e) {
		}
		fillTable();		
	}
	
	private void fillTable() {
		model.setRowCount(0);
		for(GraduacaoModel graduacaoModel : graduacoesChange) {
			model.addRow(new String[] {graduacaoModel.getGraduacao()});
		}
	}


	protected void subComponents() {


		//add - TextFields
		txtModalidade = new JTextField();
		txtModalidade.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				if(!e.isTemporary()) {
					if(modalidade!=null) {
						if(modalidade.getModalidade().trim().equals(txtModalidade.getText().trim())) {
							return;
						}
					}
					modalidade.setModalidade(txtModalidade.getText());
					model.setRowCount(0);
					graduacao = new GraduacaoModel();
				}
			}

		});
		txtModalidade.setBounds(80, 55, 410, 25);
		getContentPane().add(txtModalidade);

		txtGraduacao = new JTextField();
		txtGraduacao.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				if(!e.isTemporary()) {
					graduacao.setGraduacao(txtGraduacao.getText());					
				}
			}

		});
		txtGraduacao.setBounds(80, 87, 345, 25);
		getContentPane().add(txtGraduacao);

		//add - Botões
		btnOk = new JButton(new AbstractAction("OK") {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if((txtGraduacao.getText().trim().isEmpty())||(txtModalidade.getText().trim().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Preencha todos campos");	
				} else if(!utils.tableContains(table, 0, graduacao.getGraduacao())) {
					model.addRow(new String[] {txtGraduacao.getText()});
					graduacao.setModalidade(txtModalidade.getText());
					graduacoesChange.add(graduacao);
					graduacao = new GraduacaoModel();
				}
				txtGraduacao.setText(null);
			}
		});
		btnOk.setBounds(428, 86, 60, 25);
		getContentPane().add(btnOk);

		//Colunas pra Jtable
		String colunas[] = { "Graduação" };

		//add - Jtable
		model = new DefaultTableModel(null, colunas);
		table = new JTable(model);
		table.setBorder(BorderFactory.createLineBorder(Color.black));
		table.setEnabled(true);
		table.getTableHeader().setEnabled(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoCreateColumnsFromModel(false);
		table.setSelectionBackground(Color.cyan);



		// Criando o scrollPane
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 115, 479, 170);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.getContentPane().add(scrollPane);


		table.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		        	graduacoesChange.remove(table.getSelectedRow());
		        	fillTable();	            
		        }
		    }

		});

		//add - labels
		lblModalidade = new JLabel("Modalidade: ");
		lblModalidade.setBounds(10, 10, 350, 110);
		getContentPane().add(lblModalidade);

		lblGraduacao = new JLabel("Graduação: ");
		lblGraduacao.setBounds(14, 10, 350, 170);
		getContentPane().add(lblGraduacao);

		lblTip = new JLabel("Duplo clique na linha de graduação para remové-la.");
		lblTip.setBounds(10, 10, 350, 570);
		getContentPane().add(lblTip);


		setTitle("Modalidade e Graduações");
		setVisible(true);

		btnCancel.setVisible(false);

		childContainer = getContentPane();

	}
	public boolean isCellEditable(int row, int col) {
		return false;
	}

}

