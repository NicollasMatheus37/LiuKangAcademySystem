package view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import model.MatriculaModalidadeModel;
import model.MatriculaModel;

public class MatricularAlunos extends MasterDialogCad {

	private JButton btnModalidade, btnBuscaAluno;
	private JLabel lblMatricula, lblAluno, lblDataMat, lblDataFat;
	private JTextField JTCodigoAluno, JTAluno, JTMat, JTDataMat, JTDataFat;
	private DefaultTableModel model;
	private JTable tableMod;
	private MatriculaModel matricula, matriculaChange;
	private MatriculaModalidadeModel matModalidade;
	private ArrayList<MatriculaModalidadeModel> matModalidades, matModalidadesChange;
	
		

	public MatricularAlunos() {

		setSize(690, 538);
		setTitle("Matricular Aluno");
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

	}

	protected void subComponents() {

		
		
		JTMat = new JTextField();
		JTMat.setBounds(135, 50, 250, 26);
		getContentPane().add(JTMat);
		
		JTCodigoAluno = new JTextField();
		JTCodigoAluno.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				if(!e.isTemporary()) {
					matriculaChange.setCodigoAluno(Integer.parseInt(JTCodigoAluno.getText()));
				}
			}
			
		});
		
		JTCodigoAluno.setBounds(135, 80, 70, 26);
		getContentPane().add(JTCodigoAluno);
		
		btnBuscaAluno = new JButton();
		btnBuscaAluno.setBounds(205, 80, 45, 26);
		getContentPane().add(btnBuscaAluno);

		JTAluno = new JTextField();
		JTAluno.setBounds(255, 80, 435, 26);
		getContentPane().add(JTAluno);		
		
		JTDataMat = new JTextField();
		JTDataMat.setBounds(135, 110, 120, 26);
		getContentPane().add(JTDataMat);
		
		JTDataFat = new JTextField();
		JTDataFat.setBounds(615, 110, 55, 26);
		getContentPane().add(JTDataFat);		
		
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
		
		lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(10, 10, 100, 100);
		getContentPane().add(lblMatricula);

		lblAluno = new JLabel("Aluno:");
		lblAluno.setBounds(10, 40, 150, 100);
		getContentPane().add(lblAluno);

		lblDataMat = new JLabel("Data Matricula:");
		lblDataMat.setBounds(10, 70, 200, 100);
		getContentPane().add(lblDataMat);
		
		lblDataFat = new JLabel("Dia de vencimento da fatura:");
		lblDataFat.setBounds(450, 70, 200, 100);
		getContentPane().add(lblDataFat);
		
		childContainer = getContentPane();

	}
}
