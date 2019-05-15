package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import dao.UsuarioDAO;

@SuppressWarnings("serial")
public class MasterBuscar extends JFrame {

	protected JTextField jTxtBusca;
	private JButton btnOk;
	protected JTable table;	
	protected AlunoDAO alunoDao;
	protected Utils utils;
	protected DefaultTableModel model;
	
	
	JComboBox<String> campos;

	

	public MasterBuscar() {

		alunoDao = new AlunoDAO();
		utils = new Utils();
		setSize(453, 400);
		setTitle("Buscar Aluno");
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createComponnents();
		
		setVisible(true);
		
	}
	
	protected void clean() {	
		model.setRowCount(0);		
	}

	public void createComponnents() {

		campos = new JComboBox<String>();		
		campos.setBounds(10, 8, 110, 26);
		getContentPane().add(campos);

		jTxtBusca = new JTextField();
		jTxtBusca.setBounds(120, 8, 220, 26);
		getContentPane().add(jTxtBusca);

		btnOk = new JButton(new AbstractAction("Buscar") {

			@Override
			public void actionPerformed(ActionEvent e) {
				buscar();

			}
		});
		btnOk.setBounds(338, 6, 100, 30);	
		getContentPane().add(btnOk);		

		String colunas1[] = { "Código", "Nome" };
		model = new DefaultTableModel(colunas1, 0);
		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(75);
		table.getColumnModel().getColumn(1).setPreferredWidth(352);
		table.setBorder(BorderFactory.createLineBorder(Color.black));

		table.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent mouseEvent) {
		        JTable table =(JTable) mouseEvent.getSource();
		        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
		            setReturn();
		            dispose();
		        }
		    }

		});

		table.setEnabled(true);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 40, 427, 325);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		this.getContentPane().add(scrollPane);
		table.getTableHeader().setEnabled(false);

	}	

	protected void InsertRow(String str1, String str2) {
		if(str2.trim().isEmpty()) {
			model.addRow(new String[]{str1});
		}else {
			model.addRow(new String[]{str1,str2});
		}
	}
	
	protected void buscar() {
		
	}
	
	protected void setReturn() {
		
	}
	
	protected void updateComp(String[] campos) {
		for(int i = 0; i < campos.length; i++) {
			this.campos.addItem(campos[i]);
		}
		table.setModel(model);
	}

}
