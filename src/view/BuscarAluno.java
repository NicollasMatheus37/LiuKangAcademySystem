package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import dao.AlunoDAO;
import model.AlunoModel;

public class BuscarAluno extends JFrame {

	private JTextField jTxtBusca;
	private JButton btnOk;
	private JTable table;
	private DefaultTableModel model;
	private ArrayList<AlunoModel> alunos;
	private AlunoDAO alunoDao; 
	private Utils utils;
	JComboBox<String> campos;

	public AlunoModel alunoReturn;

	public BuscarAluno() {

		alunoDao = new AlunoDAO();
		utils = new Utils();
		setSize(400, 400);
		setTitle("Buscar Aluno");
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createComponnents();
		setVisible(true);
	}

	public void createComponnents() {

		campos = new JComboBox<String>();
		campos.addItem("C�digo");
		campos.addItem("Nome");
		campos.setBounds(10, 8, 110, 26);
		getContentPane().add(campos);

		jTxtBusca = new JTextField();
		jTxtBusca.setBounds(115, 8, 215, 26);
		getContentPane().add(jTxtBusca);

		btnOk = new JButton(new AbstractAction("Buscar") {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					if(campos.getSelectedIndex()==1) {
						alunos = alunoDao.getAllAlunos();
						for(int i = 0; i < alunos.size(); i++) {

							if(campos.getSelectedIndex() > 0) {
								if(utils.compareStrings(alunos.get(i).getAluno(), jTxtBusca.getText())) {
									InsertAluno(alunos.get(i).getcodigoAluno(), alunos.get(i).getAluno());
								}
							}

						}
					}else {						
						alunoReturn = alunoDao.getOneAluno(Integer.parseInt(jTxtBusca.getText()));
						InsertAluno(alunoReturn.getcodigoAluno(), alunoReturn.getAluno());
					}		


				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnOk.setBounds(338, 6, 50, 30);	
		getContentPane().add(btnOk);

		String colunas1[] = { "Nome", "C�digo" };
		/*	String dados[][] = */
		model = new DefaultTableModel(colunas1, 0);

		table = new JTable(model);
		table.setBorder(BorderFactory.createLineBorder(Color.black));

		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				if(e.getClickCount() == 2 ) {
					alunoReturn = alunos.get(table.getSelectedRow());

					dispose();
				}

			}

		});

		table.setEnabled(true);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 40, 375, 400);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.getContentPane().add(scrollPane);
		table.getTableHeader().setEnabled(false);		


	}	

	private void InsertAluno(int Codigo, String nome) {
		model.addRow(new String[]{Integer.toString(Codigo),nome});
	}

}
