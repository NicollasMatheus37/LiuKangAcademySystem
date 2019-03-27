import java.awt.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class Menu extends JFrame {

	// Painéis e items do menu
	private JDesktopPane desktopPane;
	private JMenuBar menuBar;
	private JMenu faturas, faturamento, matricular, sistema, cadastro, processos, relatorios, utilitarios, ajuda;
	private JMenuItem alunos, gerarF, realizaP, consultarF, planos, usuarios, sair, cadaluno,
			modalidades, matriculas, utility, help, faturasemaberto, faturaspagas;
	// Classes/frames
	private Usuarios frameUm;
	private Sair frameDois;
	private Alunos frameTres;
	private Modalidades frameQuatro;
	private Planos frameCinco;
	private Matricular frameSeis;
	private Faturamento frameSete;
	private RelatorioMatriculas frameOito;
	private Faturas frameNove;
	private Utilitarios frameDez;
	private Ajuda frameOnze;
	private Matricular frameDoze;
	private GerarFatura frameTreze;
	private ConsultarFatura frameQuatorze;
	private RealizaPagamento frameQuinze;
	private AdicionarModalidades frameDezesseis;
	private FaturasEmAberto frameDezessete;
	private FaturasPagas frameDezoito;
	
	
	Menu menu = this;
	
	private int janelaAberta = 0;

	public Menu() {

		
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

		usuarios = new JMenuItem("Usuários");
		usuarios.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 1;

				frameUm = new Usuarios();
				frameUm.setVisible(true);
				desktopPane.add(frameUm);
			}
		});

		sair = new JMenuItem("Sair");
		sair.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 2;

				frameDois = new Sair();
				frameDois.setVisible(true);
				desktopPane.add(frameDois);
			}
		});

		cadaluno = new JMenuItem("Alunos");
		cadaluno.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 3;

				try {
					frameTres = new Alunos();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frameTres.setVisible(true);
				desktopPane.add(frameTres);
			}
		});

		modalidades = new JMenuItem("Modalidades");
		modalidades.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 4;

				frameQuatro = new Modalidades();
				frameQuatro.setVisible(true);
				desktopPane.add(frameQuatro);
			}
		});

		planos = new JMenuItem("Planos");
		planos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 5;

				frameCinco = new Planos();
				frameCinco.setVisible(true);
				desktopPane.add(frameCinco);
			}
		});

		alunos = new JMenuItem("Alunos");
		alunos.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 6;

				frameSeis = new Matricular();
				frameSeis.setVisible(true);
				desktopPane.add(frameSeis);
			}
		});

		faturamento = new JMenu("Faturamento");
		faturamento.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 7;

				frameSete = new Faturamento();
				frameSete.setVisible(true);
				desktopPane.add(frameSete);
			}
		});

		matriculas = new JMenuItem("Matriculas");
		matriculas.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 8;

				try {
					frameOito = new RelatorioMatriculas();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frameOito.setVisible(true);
				desktopPane.add(frameOito);

			}
		});

		faturas = new JMenu("Faturas");
		faturas.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 9;

				frameNove = new Faturas();
				frameNove.setVisible(true);
				desktopPane.add(frameNove);

			}
		});
		utility = new JMenuItem("Utilitários");
		utility.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 10;

				frameDez = new Utilitarios();
				frameDez.setVisible(true);
				desktopPane.add(frameDez);

			}
		});

		help = new JMenuItem("Ajuda");
		help.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 11;

				frameOnze = new Ajuda();
				frameOnze.setVisible(true);
				desktopPane.add(frameOnze);

			}
		});

		matricular = new JMenu("Matricular");
		matricular.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 12;

				frameDoze = new Matricular();
				frameDoze.setVisible(true);
				desktopPane.add(frameDoze);
			}
		});

		gerarF = new JMenuItem("Gerar Fatura");
		gerarF.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 13;

				frameTreze = new GerarFatura();
				frameTreze.setVisible(true);
				desktopPane.add(frameTreze);
			}
		});

		consultarF = new JMenuItem("Consultar Fatura");
		consultarF.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 14;

				frameQuatorze = new ConsultarFatura();
				frameQuatorze.setVisible(true);
				desktopPane.add(frameQuatorze);
			}
		});

		realizaP = new JMenuItem("Realiza Pagamento");
		realizaP.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 15;

				frameQuinze = new RealizaPagamento();
				frameQuinze.setVisible(true);
				desktopPane.add(frameQuinze);
			}
		});
		
			
		faturasemaberto = new JMenuItem("Faturas Em Aberto");
		faturasemaberto.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 17;

				frameDezessete = new FaturasEmAberto();
				frameDezessete.setVisible(true);
				desktopPane.add(frameDezessete);
			}
		});
		
		faturaspagas = new JMenuItem("Faturas Pagas");
		faturaspagas.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt) {

				fecharJanelaAberta();
				janelaAberta = 18;

				frameDezoito = new FaturasPagas();
				frameDezoito.setVisible(true);
				desktopPane.add(frameDezoito);
			}
		});
		

		menuBar = new JMenuBar();
		sistema = new JMenu("Sistema");

		setContentPane(desktopPane);

		sistema.add(usuarios);
		sistema.add(sair);
		menuBar.add(sistema);

		cadastro = new JMenu("Cadastros");

		cadastro.add(cadaluno);
		cadastro.add(modalidades);
		cadastro.add(planos);

		menuBar.add(cadastro);

		processos = new JMenu("Processos");

		matricular.add(alunos);

		faturamento.add(gerarF);
		faturamento.add(consultarF);
		faturamento.add(realizaP);

		processos.add(matricular);
		processos.add(faturamento);
		menuBar.add(processos);

		relatorios = new JMenu("Relatórios");

		relatorios.add(matriculas);
		relatorios.add(faturas);

		faturas.add(faturasemaberto);
		faturas.add(faturaspagas);
		
		menuBar.add(relatorios);

		utilitarios = new JMenu("Utilitários");
		utilitarios.add(utility);

		menuBar.add(utilitarios);

		ajuda = new JMenu("Ajuda");
		ajuda.add(help);

		menuBar.add(ajuda);

		setJMenuBar(menuBar);
		setTitle("Liu Kang Academy System");
		setSize(705, 600);
		setLocationRelativeTo(null);
		setBackground(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setContentPane(CreateContentPane());
		setVisible(true);
	}

	public Container CreateContentPane() {

		JPanel contentPane = new JPanel(new BorderLayout());
		desktopPane = new JDesktopPane() {
			Image im = (new ImageIcon("C:/download.jpg")).getImage();

			public void paintComponent(Graphics g) {
				g.drawImage(im, 0, 0, this);
			}
		};

		contentPane.setOpaque(true);
		contentPane.add(desktopPane);
		return contentPane;
	}

	public void mostrarJanela(boolean o) {

		setVisible(o);
	}

	private void fecharJanelaAberta() {
		switch (janelaAberta) {
		case 1:
			frameUm.dispose();
			break;
		case 2:
			frameDois.dispose();
			break;

		case 3:
			frameTres.dispose();
			break;

		case 4:
			frameQuatro.dispose();
			break;

		case 5:
			frameCinco.dispose();
			break;

		case 6:
			frameSeis.dispose();
			break;

		case 7:
			frameSete.dispose();
			break;

		case 8:
			frameOito.dispose();
			break;

		case 9:
			frameNove.dispose();
			break;
		case 10:
			frameDez.dispose();
			break;
		case 11:
			frameOnze.dispose();
			break;
		case 12:
			frameDoze.dispose();
			break;
		case 13:
			frameTreze.dispose();
			break;
		case 14:
			frameQuatorze.dispose();
			break;
		case 15:
			frameQuinze.dispose();
			break;
		case 16:
			frameQuinze.dispose();
			break;
		case 17:
			frameQuinze.dispose();
			break;
		case 18:
			frameQuinze.dispose();
			break;
			
			
		default:
			break;
		}
	}

	public static void main(String args[]) {

		new Menu();
	}
}