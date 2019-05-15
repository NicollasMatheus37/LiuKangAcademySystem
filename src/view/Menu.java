package view;

import java.awt.*;

import java.awt.event.*;
import java.text.ParseException;

import javax.swing.*;

import model.UsuarioModel;

@SuppressWarnings("serial")
public class Menu extends JFrame {

	// Pain�is e items do menu
	public JDesktopPane desktopPane;
	private JMenuBar menuBar;
	private JMenu faturas, faturamento, matricular, sistema, cadastro, processos, utilitarios, ajuda;
	private JMenuItem alunos, gerarF, realizaP, consultarF, planos, usuarios, sair, cadaluno, modalidades, utility,
			help, faturasemaberto, faturaspagas, backupRestore;
	// Classes/frames
	private Usuarios fUsuario;
	private Sair fSair;
	private CadastroAlunos fCadastroAlunos;
	private ModalidadesGraduacoes fModalidades;
	private Planos fPlanos;
	private MatricularAlunos fMatricularAlunos;
	private Faturamento fFaturamento;
	private Faturas fFaturas;
	private Utilitarios fUtilitarios;
	private Ajuda fAjuda;
	private GerarFaturas fGerarFaturas;
	private ConsultarFaturas fConsultarFaturas;
	private PagamentosFaturas fPagamentosFaturas;
	private AdicionarModalidades fAdicionarModalidades;
	private FaturasAberto fFaturasAberto;
	private FaturasPagas fFaturasPagas;
	private ControleAlunos fControleAlunos;
	private BuscarAluno fBuscarAluno;
	private BackupRestore fBackupRestore;
	private String perfil, usuario;

	private int janelaAberta = 0;

	public Menu(String Perfil, String Usuario) {
		usuario = Usuario;
		perfil = Perfil;

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		desktopPane = new JDesktopPane();

		usuarios = new JMenuItem("Usu�rios");
		usuarios.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 1;
				
				try {
				fUsuario = new Usuarios();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				fUsuario.setVisible(true);
				desktopPane.add(fUsuario);
			}
		});

		sair = new JMenuItem("Sair");
		sair.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 2;

				fSair = new Sair();
				fSair.setVisible(true);
				desktopPane.add(fSair);
			}
		});

		cadaluno = new JMenuItem("Alunos");
		cadaluno.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 3;

				try {
					fCadastroAlunos = new CadastroAlunos();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				desktopPane.add(fCadastroAlunos);
				fCadastroAlunos.setVisible(true);
				fCadastroAlunos.setPosicao();
				
			}
		});
		

		modalidades = new JMenuItem("Modalidades");
		modalidades.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 4;

				fModalidades = new ModalidadesGraduacoes();
				desktopPane.add(fModalidades);
				fModalidades.setVisible(true);
				fModalidades.setPosicao();
				
			}
		});

		planos = new JMenuItem("Planos");
		planos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 5;

				fPlanos = new Planos();
				desktopPane.add(fPlanos);
				fPlanos.setVisible(true);
				fPlanos.setPosicao();
			}
		});

		alunos = new JMenuItem("Alunos");
		alunos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 6;

				fMatricularAlunos = new MatricularAlunos();
				desktopPane.add(fMatricularAlunos);
				fMatricularAlunos.setVisible(true);
				fMatricularAlunos.setPosicao();
				
			}
		});

		faturamento = new JMenu("Faturamento");
		faturamento.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 7;

				fFaturamento = new Faturamento();
				fFaturamento.setVisible(true);
				desktopPane.add(fFaturamento);
			}
		});

		faturas = new JMenu("Faturas");
		faturas.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 9;

				fFaturas = new Faturas();
				fFaturas.setVisible(true);
				desktopPane.add(fFaturas);

			}
		});
		utility = new JMenuItem("Utilit�rios");
		utility.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 10;

				fUtilitarios = new Utilitarios();
				desktopPane.add(fUtilitarios);
				fUtilitarios.setVisible(true);
				fUtilitarios.setPosicao();
				

			}
		});

		help = new JMenuItem("Ajuda");
		help.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 11;

				fAjuda = new Ajuda();
				desktopPane.add(fAjuda);
				fAjuda.setVisible(true);
				fAjuda.setPosicao();

			}
		});

		matricular = new JMenu("Matricular");
		matricular.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 12;

				fMatricularAlunos = new MatricularAlunos();
				fMatricularAlunos.setVisible(true);
				desktopPane.add(fMatricularAlunos);
			}
		});

		gerarF = new JMenuItem("Gerar Fatura");
		gerarF.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 13;

				fGerarFaturas = new GerarFaturas();
				desktopPane.add(fGerarFaturas);
				fGerarFaturas.setVisible(true);
				fGerarFaturas.setPosicao();
			}
		});

		consultarF = new JMenuItem("Consultar Fatura");
		consultarF.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 14;

				fConsultarFaturas = new ConsultarFaturas();
				desktopPane.add(fConsultarFaturas);
				fConsultarFaturas.setVisible(true);
				fConsultarFaturas.setPosicao();
			}
		});

		realizaP = new JMenuItem("Realiza Pagamento");
		realizaP.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 15;

				fPagamentosFaturas = new PagamentosFaturas();
				desktopPane.add(fPagamentosFaturas);
				fPagamentosFaturas.setVisible(true);
				fPagamentosFaturas.setPosicao();
			}
		});

		faturasemaberto = new JMenuItem("Faturas Em Aberto");
		faturasemaberto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 17;

				fFaturasAberto = new FaturasAberto();
				fFaturasAberto.setVisible(true);
				desktopPane.add(fFaturasAberto);
			}
		});

		faturaspagas = new JMenuItem("Faturas Pagas");
		faturaspagas.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 18;

				fFaturasPagas = new FaturasPagas();
				fFaturasPagas.setVisible(true);
				desktopPane.add(fFaturasPagas);
			}
		});
		
		backupRestore = new JMenuItem("Backup");
		backupRestore.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 19;

				fBackupRestore = new BackupRestore();
				desktopPane.add(fBackupRestore);
				fBackupRestore.setVisible(true);
				fBackupRestore.setPosicao();
				
			}
		});

		setContentPane(desktopPane);

		menuBar = new JMenuBar();
		sistema = new JMenu("Sistema");

		if(perfil.equals("Completo"))
		sistema.add(usuarios);
		sistema.add(sair);
		menuBar.add(sistema);

		cadastro = new JMenu("Cadastros");

		
		cadastro.add(cadaluno);
		cadastro.add(modalidades);
		cadastro.add(planos);
		

		if(perfil.equals("Cadastral") || perfil.equals("Completo"))
		menuBar.add(cadastro);

		processos = new JMenu("Processos");


		matricular.add(alunos);
		

		faturamento.add(gerarF);
		faturamento.add(consultarF);
		faturamento.add(realizaP);
		
		if(perfil.equals("Matricular") || perfil.equals("Completo"))
		processos.add(matricular);
		
		if(perfil.equals("Financeiro") || perfil.equals("Completo"))
		processos.add(faturamento);
		menuBar.add(processos);

		utilitarios = new JMenu("Utilit�rios");
		utilitarios.add(backupRestore);
		utilitarios.add(utility);

		menuBar.add(utilitarios);

		ajuda = new JMenu("Ajuda");
		ajuda.add(help);

		menuBar.add(ajuda);

		setJMenuBar(menuBar);
		setTitle("Liu Kang Academy System");
		/* setSize(705, 600); */
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setLocationRelativeTo(null);
		setBackground(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setContentPane(CreateContentPane());
		FramePrincipal();
		ImageIcon imagemTituloJanela = new ImageIcon("Images/48x48/icon.jpg");
		setIconImage(imagemTituloJanela.getImage());
		setVisible(true);
	}

	public Container CreateContentPane() {

		JPanel contentPane = new JPanel(new BorderLayout());
		desktopPane = new JDesktopPane() {
			Image im = (new ImageIcon("Images/background/liukang.jpg")).getImage();

			public void paintComponent(Graphics g) {
				g.drawImage(im, 0, 0, getWidth(), getHeight(), this);

			}
		};

		contentPane.setOpaque(true);
		contentPane.add(desktopPane);
		return contentPane;
	}

	public void FramePrincipal() {

		fControleAlunos = new ControleAlunos(this);
		fControleAlunos.setVisible(true);
		desktopPane.add(fControleAlunos);

	}

	public void mostrarJanela(boolean o) {

		setVisible(o);
	}

	private void fecharJanelaAberta() {
		switch (janelaAberta) {
		case 1:
			fUsuario.dispose();
			break;
		case 2:
			fSair.dispose();
			break;

		case 3:
			fCadastroAlunos.dispose();
			break;

		case 4:
			fModalidades.dispose();
			break;

		case 5:
			fPlanos.dispose();
			break;

		case 6:
			fMatricularAlunos.dispose();
			break;

		case 7:
			fFaturamento.dispose();
			break;

		case 9:
			fFaturas.dispose();
			break;
		case 10:
			fUtilitarios.dispose();
			break;
		case 11:
			fAjuda.dispose();
			break;
		case 12:
			fMatricularAlunos.dispose();
			break;
		case 13:
			fGerarFaturas.dispose();
			break;
		case 14:
			fConsultarFaturas.dispose();
			break;
		case 15:
			fPagamentosFaturas.dispose();
			break;
		case 16:
			fAdicionarModalidades.dispose();
			break;
		case 17:
			fFaturasAberto.dispose();
			break;
		case 18:
			fFaturasPagas.dispose();
			break;
		case 20:
			fBuscarAluno.dispose();
			break;

		default:
			break;
		}
	}

	public static void main(String args[]) {

		new Menu("Completo", "admin");
	}
}