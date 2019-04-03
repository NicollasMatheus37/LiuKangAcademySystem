package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class ControleAlunos extends JInternalFrame {

	private DefaultTableModel model1, model2, model3;
	private JTable table1, table2, table3;
	private JTextField JTextCod, JTextNome;
	private JLabel JLAguarda, JLRegular, JLPendente;
	private JButton btnAcessarA, btnDadosM;
	BaseMonthChooser data;
	private JPanel panelFoto, panelConsultas;
	
	public ControleAlunos() {
		
		setSize(690, 538);
		setTitle("Controle de Alunos");
		setLayout(null);
		setResizable(false);
		setIconifiable(true);
		createComponnents();
		setVisible(true);

	}

	public void createComponnents() {
		
		//panel para adicionar a foto
		panelFoto = new JPanel();
		panelFoto.setBounds(12, 10, 195, 180);
		panelFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		getContentPane().add(panelFoto);
		
		/*panel de consultas (aguardando consulta = cor default, 
		situação regular = cor verde, débitos pendentes = cor vermelha.)*/
		panelConsultas = new JPanel();
		panelConsultas.setBounds(232, 150, 437, 38);
		/*panelConsultas.setBackground(Color.RED);*/
	/*	panelConsultas.setBackground(Color.GREEN);*/
		panelConsultas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		panelConsultas.setLayout(null);
		getContentPane().add(panelConsultas);
						
				
		data = new BaseMonthChooser();
		data.setBounds(17, 200, 185, 26);
		getContentPane().add(data);
		
		JLAguarda = new JLabel("Aguardando Consulta...");
		JLAguarda.setFont(new Font("Arial Black", Font.BOLD, 12));
		JLAguarda.setBounds(365, 150, 437, 38);
		getContentPane().add(JLAguarda);
		this.add(panelConsultas);
		
	/*	JLRegular = new JLabel("Situação Regular");
		JLRegular.setFont(new Font("Arial Black", Font.BOLD, 12));
		JLRegular.setBounds(385, 150, 437, 38);
		getContentPane().add(JLRegular);
		this.add(panelConsultas);*/
	/*	
		JLPendente = new JLabel("Débitos Pendentes");
		JLPendente.setFont(new Font("Arial Black", Font.BOLD, 12));
		JLPendente.setBounds(383, 150, 437, 38);
		getContentPane().add(JLPendente);
		this.add(panelConsultas);*/
				
		JTextCod = new JTextField();
		JTextCod.setBounds(232, 10, 90, 26);
		getContentPane().add(JTextCod);
		
		JTextNome = new JTextField();
		JTextNome.setBounds(330, 10, 340, 26);
		JTextNome.setEnabled(false);
		JTextNome.setEditable(false);
		
		getContentPane().add(JTextNome);
		
		btnAcessarA = new JButton("Acessar dados do Aluno");
		btnAcessarA.setBounds(230, 196, 220, 30);
		getContentPane().add(btnAcessarA);
		
		btnDadosM = new JButton("Acessar dados da Matrícula");
		btnDadosM.setBounds(450, 196, 220, 30);
		getContentPane().add(btnDadosM);
		
		//tabela 1
		String colunas1[] = { "Modalidade", "Graduação", "Plano", "Data Início", "Data Fim" };
	/*	String dados[][] = */
		model1 = new DefaultTableModel(colunas1, 0);

		table1 = new JTable(model1);
		table1.setBorder(BorderFactory.createLineBorder(Color.black));
		table1.setEnabled(true);

		JScrollPane scrollPane = new JScrollPane(table1);
		scrollPane.setBounds(230, 40, 440, 100);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.getContentPane().add(scrollPane);
		table1.getTableHeader().setEnabled(false);
		
		//tabela 2
		String colunas2[] = { "Vencimento", "Valor", "Pagamento", "Cancelamento" };
	/*	String dados[][] = */
		model2 = new DefaultTableModel(colunas2, 0);

		table2 = new JTable(model2);
		table2.setBorder(BorderFactory.createLineBorder(Color.black));
		table2.setEnabled(true);

		JScrollPane scrollPane2 = new JScrollPane(table2);
		scrollPane2.setBounds(230, 230, 440, 270);
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.getContentPane().add(scrollPane2);
		table2.getTableHeader().setEnabled(false);
		
		//tabela 3
		String colunas3[] = { "Assiduidade" };
	/*	String dados[][] = */
		model3 = new DefaultTableModel(colunas3, 0);

		table3 = new JTable(model3);
		table3.setBorder(BorderFactory.createLineBorder(Color.black));
		table3.setEnabled(true);

		JScrollPane scrollPane3 = new JScrollPane(table3);
		scrollPane3.setBounds(10, 230, 200, 270);
		scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.getContentPane().add(scrollPane3);
		table3.getTableHeader().setEnabled(false);
	}
}

