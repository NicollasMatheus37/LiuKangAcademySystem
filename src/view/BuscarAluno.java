package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class BuscarAluno extends JFrame {

	private JLabel lbBusca;
	private JTextField jTxtBusca;
	private JButton btnOk;
	private JTable table;
	private DefaultTableModel model;
		
	
	public BuscarAluno() {
	
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
		
		lbBusca = new JLabel("Buscar aluno:");
		lbBusca.setBounds(10, 0, 100, 40);
		getContentPane().add(lbBusca);
		
		jTxtBusca = new JTextField();
		jTxtBusca.setBounds(93, 8, 240, 26);
		getContentPane().add(jTxtBusca);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(338, 6, 50, 30);
		getContentPane().add(btnOk);
		
		String colunas1[] = { "Nome", "Código" };
		/*	String dados[][] = */
			model = new DefaultTableModel(colunas1, 0);

			table = new JTable(model);
			table.setBorder(BorderFactory.createLineBorder(Color.black));
			table.setEnabled(true);

			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(10, 40, 375, 100);
			scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			this.getContentPane().add(scrollPane);
			table.getTableHeader().setEnabled(false);
			
		
		
	}
	
	
}
