package view;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class MatricularAlunos extends JInternalFrame {

	private JButton btnSearch, btnAdd, btnDelete, btnSave, btnModalidade;
	private JLabel Matricula, Aluno, DataMat, DataFat;
	private JTextField JTCodigoAluno, JTAluno, JTMat, JTDataMat, JTDataFat;
	private DefaultTableModel model;
	private JTable tableMod;
	private JDesktopPane desktopPane;
	private AdicionarModalidades frameDezesseis;
		

	public MatricularAlunos() {

		setSize(690, 538);
		setTitle("Matricular Aluno");
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createComponnents();
		setVisible(true);

	}

	public void createComponnents() {

		Matricula = new JLabel("Matricula:");
		Matricula.setBounds(10, 10, 100, 100);
		getContentPane().add(Matricula);

		Aluno = new JLabel("Aluno:");
		Aluno.setBounds(10, 40, 150, 100);
		getContentPane().add(Aluno);

		DataMat = new JLabel("Data Matricula:");
		DataMat.setBounds(10, 70, 200, 100);
		getContentPane().add(DataMat);
		
		DataFat = new JLabel("Dia de vencimento da fatura:");
		DataFat.setBounds(450, 70, 200, 100);
		getContentPane().add(DataFat);
		
		JTMat = new JTextField();
		JTMat.setBounds(135, 50, 250, 26);
		getContentPane().add(JTMat);
		
		JTCodigoAluno = new JTextField();
		JTCodigoAluno.setBounds(135, 80, 120, 26);
		getContentPane().add(JTCodigoAluno);

		JTAluno = new JTextField();
		JTAluno.setBounds(255, 80, 415, 26);
		getContentPane().add(JTAluno);
		
		JTDataMat = new JTextField();
		JTDataMat.setBounds(135, 110, 120, 26);
		getContentPane().add(JTDataMat);
		
		JTDataFat = new JTextField();
		JTDataFat.setBounds(615, 110, 55, 26);
		getContentPane().add(JTDataFat);
				
		btnSearch = new JButton("Buscar",
				new ImageIcon(System.getProperty("user.dir") + "\\images\\22x22\\localizar.png"));
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearch.setHorizontalTextPosition(SwingConstants.RIGHT);
		/* btnSearch.setMargin(0, 0, 0, 0); */
		btnSearch.setBounds(10, 10, 120, 35);
		getContentPane().add(btnSearch);

		// Botao Add
		btnAdd = new JButton("Adicionar",
				new ImageIcon(System.getProperty("user.dir") + "\\images\\22x22\\adicionar.png"));
		
		btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdd.setHorizontalTextPosition(SwingConstants.RIGHT);
		/* btnAdd.setMargin(new Insets(0, 0, 0, 0)); */
		btnAdd.setBounds(130, 10, 120, 35);
		getContentPane().add(btnAdd);

		// Botao Delete
		btnDelete = new JButton("Remover",
				new ImageIcon(System.getProperty("user.dir") + "\\images\\22x22\\remover.png"));
		btnDelete.setHorizontalAlignment(SwingConstants.LEFT);
		btnDelete.setHorizontalTextPosition(SwingConstants.RIGHT);
		/* btnDelete.setMargin(new Insets(0, 0, 0, 0)); */
		btnDelete.setBounds(250, 10, 120, 35);
		getContentPane().add(btnDelete);

		// Botao Save
		btnSave = new JButton("Salvar", new ImageIcon(System.getProperty("user.dir") + "\\images\\22x22\\salvar.png"));
		btnSave.setHorizontalAlignment(SwingConstants.LEFT);
		btnSave.setHorizontalTextPosition(SwingConstants.RIGHT);
		/* btnSave.setMargin(new Insets(0, 0, 0, 0)); */
		btnSave.setBounds(370, 10, 120, 35);
		getContentPane().add(btnSave);
		
		btnModalidade = new JButton("Adicionar Modalidade");
		btnModalidade.setBounds(10, 155, 160, 26);
		btnModalidade.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				new AdicionarModalidades();
				
			}
		});
		
		getContentPane().add(btnModalidade);
		
		String colunas[] = { "Modalidade", "Graduação", "Plano", "Data início", "Data fim ",  };
		model = new DefaultTableModel(colunas, 0);

		tableMod = new JTable(model);
		tableMod.setBorder(BorderFactory.createLineBorder(Color.black));
		tableMod.setEnabled(true);

		JScrollPane scrollPane = new JScrollPane(tableMod);
		scrollPane.setBounds(10, 200, 660, 300);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.getContentPane().add(scrollPane);
		tableMod.getTableHeader().setEnabled(false);

	}
}
