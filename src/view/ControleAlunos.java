package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import dao.AssiduidadeDAO;
import dao.FaturaMatriculaDAO;
import dao.MatriculaDAO;
import dao.MatriculaModalidadeDAO;
import model.AlunoModel;
import model.AssiduidadeModel;
import model.FaturaMatriculaModel;
import model.MatriculaModalidadeModel;
import model.MatriculaModel;

@SuppressWarnings("serial")
public class ControleAlunos extends JInternalFrame {

	private DefaultTableModel modelModalidade, modelFatura, modelAssiduidade;
	private JTable table1, table2, table3;
	private JTextField JTextCod, JTextNome;
	private JLabel JLAguarda, JLRegular, JLPendente;
	private JButton btnAcessarA, btnDadosM;
	BaseMonthChooser data;
	private JPanel panelFoto, panelConsultas;
	private Menu menu;
	
	private AssiduidadeDAO assiduidadeDAO;
	private MatriculaModalidadeDAO matriculaModalidadeDAO;
	private MatriculaDAO matriculaDAO;
	private FaturaMatriculaDAO faturaMatriculaDAO;
	
	private BuscarAluno buscaAluno;
	private AlunoModel aluno;
	private MatriculaModel matricula;
	private ArrayList<MatriculaModalidadeModel> modalidades;
	private ArrayList<FaturaMatriculaModel> faturas;
	private ArrayList<AssiduidadeModel> assiduidades;
	
	public ControleAlunos(Menu menu) {
		
		assiduidadeDAO = new AssiduidadeDAO();
		matriculaDAO = new MatriculaDAO();
		matriculaModalidadeDAO = new MatriculaModalidadeDAO();
		faturaMatriculaDAO = new FaturaMatriculaDAO();
		
		this.menu = menu;
		setSize(690, 538);
		setTitle("Controle de Alunos");
		setLayout(null);
		setResizable(false);
		setIconifiable(true);
		createComponnents();
		setVisible(true);

	}

	public void setPosicao() {
		
		Dimension d = this.getDesktopPane().getSize();
	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
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
						
				
		data = new BaseMonthChooser() {
			public void ExecuteSomething() {
				fillAssiduidade();
			}
		};		
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
		JTextCod.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_F9) {
					buscaAluno = new BuscarAluno();
					buscaAluno.addWindowListener(new WindowAdapter() {

						public void windowClosed(WindowEvent e) {
							if(buscaAluno.alunoReturn!=null) {
								aluno = buscaAluno.alunoReturn;
								try {
									matricula = matriculaDAO.getOneMatricula(aluno.getcodigoAluno(), false);
									modalidades = matriculaModalidadeDAO.getAllMatriculasModalidades(matricula.getCodigoMatricula());
									fillModalidade();
									assiduidadeDAO.createAssiduidade(new AssiduidadeModel().setCodigoMatricula(matricula.getCodigoMatricula()));
																		
									fillAssiduidade();
								
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								JTextNome.setText(aluno.getAluno());
							}
						}
					});
				}
			}
		});
		JTextCod.setBounds(232, 10, 90, 26);
		getContentPane().add(JTextCod);
		
		JTextNome = new JTextField();
		JTextNome.setBounds(330, 10, 340, 26);
		JTextNome.setEnabled(false);
		JTextNome.setEditable(false);
		
		getContentPane().add(JTextNome);
		 
		
		btnAcessarA = new JButton("Acessar dados do Aluno");
		btnAcessarA.addActionListener(new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(aluno != null) {
					CadastroAlunos cadAluno = new CadastroAlunos(aluno);
					menu.desktopPane.add(cadAluno);
					prepareFrame((JInternalFrame) cadAluno);
				}
			}
		});		
		btnAcessarA.setBounds(230, 196, 220, 30);
		getContentPane().add(btnAcessarA);
		
		btnDadosM = new JButton("Acessar dados da Matrícula");
		btnDadosM.addActionListener(new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				MatricularAlunos matAlunos = new MatricularAlunos(matricula);
				menu.desktopPane.add(matAlunos);
				prepareFrame((JInternalFrame) matAlunos);				
			}
			
		});
		btnDadosM.setBounds(450, 196, 220, 30);
		getContentPane().add(btnDadosM);
		
		//tabela 1
		String colunas1[] = { "Modalidade", "Graduação", "Plano", "Data Início", "Data Fim" };
	/*	String dados[][] = */
		modelModalidade = new DefaultTableModel(colunas1, 0);

		table1 = new JTable(modelModalidade);
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
		modelFatura = new DefaultTableModel(colunas2, 0);

		table2 = new JTable(modelFatura);
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
		modelAssiduidade = new DefaultTableModel(colunas3, 0);

		table3 = new JTable(modelAssiduidade);
		table3.setBorder(BorderFactory.createLineBorder(Color.black));
		table3.setEnabled(true);

		JScrollPane scrollPane3 = new JScrollPane(table3);
		scrollPane3.setBounds(10, 230, 200, 270);
		scrollPane3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.getContentPane().add(scrollPane3);
		table3.getTableHeader().setEnabled(false);
	}
	
	public void fillModalidade() {
		modelModalidade.setRowCount(0);
		for(MatriculaModalidadeModel matModalidade : modalidades) {
			
			modelModalidade.addRow(new String[] {matModalidade.getModalidade(), matModalidade.getGraduacao(), matModalidade.getPlano(), matModalidade.getData_inicio(), matModalidade.getData_fim()});
			
		}
	}
	
	public void fillFatura() {
		modelFatura.setRowCount(0);
		for(FaturaMatriculaModel fatura : faturas) {
			
			modelFatura.addRow(new String[] {});
			
		}
	}
	
	public void fillAssiduidade() {
		
		Calendar calIni = Calendar.getInstance();
		calIni.setTime(data.getDate());
		Calendar calFin = Calendar.getInstance();
		calFin.setTime(data.getDate());
		calIni.set(Calendar.DAY_OF_MONTH, calIni.getActualMinimum(Calendar.DAY_OF_MONTH));
		calFin.set(Calendar.DAY_OF_MONTH, calFin.getActualMaximum(Calendar.DAY_OF_MONTH));
		try {
			assiduidades = assiduidadeDAO.getAllAssiduidades(matricula.getCodigoMatricula(),
													new SimpleDateFormat("yyyy/MM/dd").format(calIni.getTime()), 
													new SimpleDateFormat("yyyy/MM/dd").format(calFin.getTime()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		modelAssiduidade.setRowCount(0);
		for(AssiduidadeModel assiduidade : assiduidades) {
			
			modelAssiduidade.addRow(new String[] {assiduidade.getDataEntrada()});
			
		}
	}
	
	private void prepareFrame(JInternalFrame frame) {
		
		frame.setVisible(true);
		frame.addInternalFrameListener(new InternalFrameAdapter() {
			
			@Override
			public void internalFrameClosed(InternalFrameEvent e) {
				
				try {
					setSelected(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		try {
			frame.setSelected(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}

