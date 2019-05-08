package view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import dao.AlunoDAO;
import dao.MatriculaDAO;
import dao.MatriculaModalidadeDAO;
import model.AlunoModel;
import model.MatriculaModalidadeModel;
import model.MatriculaModel;

@SuppressWarnings("serial")
public class MatricularAlunos extends MasterDialogCad {

	private JButton btnModalidade;
	private JLabel lblMatricula, lblAluno, lblDataMat, lblDataFat;
	private JTextField JTCodigoAluno, JTAluno, JTMat, JTDataFat;
	private JFormattedTextField JTDataMat;
	private DefaultTableModel model;
	private JTable tableMod;
	private MatriculaModel matricula, matriculaChange;
	private ArrayList<MatriculaModalidadeModel> matModalidades, matModalidadesChange;

	private BuscarMatricula buscaMat;
	private BuscarAluno buscaAluno;
	private AdicionarModalidades addModalidade;
	private MatriculaDAO matriculaDAO;
	private MatriculaModalidadeDAO matModalidadeDAO;

	private AlunoDAO alunoDAO;		

	public MatricularAlunos() {

		matriculaDAO = new MatriculaDAO();
		matModalidadeDAO = new MatriculaModalidadeDAO();
		alunoDAO = new AlunoDAO();

		setSize(690, 538);
		setTitle("Matricular Aluno");
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

	}

	protected boolean actionCancel() {
		try {
			if(isInserting) {
				matricula = null;
				matModalidades = null;
			}
			matriculaChange = null;
			matModalidadesChange = null;
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	protected boolean actionAdd() {
		try {
			matricula = new MatriculaModel();
			matModalidadesChange = new ArrayList<>();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	protected void actionSearch() {
		try {
			buscaMat = new BuscarMatricula();
			buscaMat.addWindowListener(eventWindowSearchClosed);			
		} catch (Exception e) {

		}
	}

	protected boolean afterSearch() {
		if(buscaMat.matriculaReturn!=null) {
			matricula = buscaMat.matriculaReturn;
			return true;
		}
		return false;
	}

	protected boolean actionDelete() {
		if(matriculaChange!=null) {
			if(matriculaChange.getCodigoAluno()>0) {
				try {
					matModalidadeDAO.deleteMatriculaModalidade(matriculaChange.getCodigoMatricula());
					matriculaDAO.deleteMatricula(matriculaChange.getCodigoMatricula());
					return true;
				} catch (SQLException e) {
					return false;				
				}				
			}
		}
		return false;
	}

	protected boolean actionSave() {
		if(matriculaChange!=null) {
			if(matModalidadesChange.size()>0) {
				try {
					int matriculaId = matriculaChange.getCodigoMatricula();
					if(isInserting) {
						matriculaId = matriculaDAO.createMatricula(matriculaChange);
					}else {
						matriculaDAO.updateMatricula(matriculaChange);
					}
					matModalidadeDAO.createMatriculaModalidade(matModalidadesChange, matriculaId);
					return true;
				} catch (SQLException e) {
					return false;
				}				

			}else {
				JOptionPane.showMessageDialog(null,"Insira ao menos uma modalidade");
			}
		}
		return false;
	}

	private WindowAdapter windowAddClose  = new WindowAdapter() {

		public void windowClosed(WindowEvent e) {

			if(addModalidade.matModalidadeReturn!=null) {
				if(!utils.tableContains(tableMod, 0, addModalidade.matModalidadeReturn.getModalidade())){
					matModalidadesChange.add(addModalidade.matModalidadeReturn);
					insertTable(addModalidade.matModalidadeReturn);
				}else {
					JOptionPane.showMessageDialog(null, "Este aluno ja esta matriculado nesta modalidade");
				}
			}

		}

	};

	protected void fillFields(){

		JTMat.setText(Integer.toString(matricula.getCodigoMatricula()));
		try {
			AlunoModel aluno = alunoDAO.getOneAluno(matricula.getCodigoAluno());
			if(aluno!=null) {
				JTCodigoAluno.setText(Integer.toString(aluno.getcodigoAluno()));
				JTAluno.setText(aluno.getAluno());
			}
		} catch (SQLException e) {

		}
		JTDataMat.setText(matricula.getDataMatricula());
		JTDataFat.setText(Integer.toString(matricula.getDiaVencimento()));	

		matriculaChange = new MatriculaModel(matricula);

		findTable();

	}

	private void findTable() {
		if(matriculaChange.getCodigoMatricula()>0) {
			try {
				matModalidades = matModalidadeDAO.getAllMatriculasModalidades(matriculaChange.getCodigoMatricula());
				matModalidadesChange = matModalidades;
				fillTable();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	private void fillTable() {
		model.setRowCount(0);
		for(MatriculaModalidadeModel matMod : matModalidadesChange) {

			insertTable(matMod);

		}

	}

	private void insertTable(MatriculaModalidadeModel matMod) {

		model.addRow(new String[] {matMod.getModalidade(), matMod.getGraduacao(), matMod.getPlano(), matMod.getData_inicio(), matMod.getData_fim()});		

	}

	protected void subComponents() {



		JTMat = new JTextField();
		JTMat.setName("ignore");
		JTMat.setEnabled(false);
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


		JTCodigoAluno.setBounds(135, 80, 115, 26);
		JTCodigoAluno.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_F9) {
					buscaAluno = new BuscarAluno();
					buscaAluno.addWindowListener(new WindowAdapter() {

						public void windowClosed(WindowEvent e) {
							if(buscaAluno.alunoReturn!=null) {
								matriculaChange.setCodigoAluno(buscaAluno.alunoReturn.getcodigoAluno());
								JTAluno.setText(buscaAluno.alunoReturn.getAluno());
								JTCodigoAluno.setText(Integer.toString(buscaAluno.alunoReturn.getcodigoAluno()));
							}
						}

					});
				}
			}
		});
		JTCodigoAluno.setEnabled(true);
		getContentPane().add(JTCodigoAluno);


		JTAluno = new JTextField();
		JTAluno.setName("ignore");
		JTAluno.setEnabled(false);
		JTAluno.setBounds(255, 80, 435, 26);
		getContentPane().add(JTAluno);		

		try {
			JTDataMat = new JFormattedTextField(new MaskFormatter("##/##/####"));
			JTDataMat.addFocusListener(new FocusAdapter() {
				public void focusLost(FocusEvent e) {
					if(!e.isTemporary()) {
						try {
							if(!JTDataMat.getText().replaceAll("/", "").trim().isEmpty()) {
								matriculaChange.setDataMatricula(new SimpleDateFormat("dd/MM/yyyy").parse(JTDataMat.getText()));
							}
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});
			JTDataMat.setBounds(135, 110, 120, 26);
			getContentPane().add(JTDataMat);

			JTDataFat = new JTextField();
			JTDataFat.addFocusListener(new FocusAdapter() {
				public void focusLost(FocusEvent e) {
					if(!e.isTemporary()) {
						matriculaChange.setDiaVencimento(Integer.parseInt(JTDataFat.getText()));
					}
				}
			});
			JTDataFat.setBounds(615, 110, 55, 26);
			getContentPane().add(JTDataFat);		

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		btnModalidade = new JButton("Adicionar Modalidade");
		btnModalidade.setBounds(10, 155, 160, 26);
		btnModalidade.addActionListener(new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {

				addModalidade = new AdicionarModalidades();
				addModalidade.addWindowListener(windowAddClose);

			}
		});

		getContentPane().add(btnModalidade);

		String colunas[] = { "Modalidade", "Graduação", "Plano", "Data início", "Data fim ",  };
		model = new DefaultTableModel(colunas, 0){
			public boolean isCellEditable(int row,int column) {
				return false;				
			}
		};

		tableMod = new JTable(model);
		tableMod.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent mouseEvent) {
				JTable table =(JTable) mouseEvent.getSource();
				if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
					matModalidadesChange.remove(table.getSelectedRow());

					btnModalidade.requestFocus();

					fillTable();	            
				}
			}

		});
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
