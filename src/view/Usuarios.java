package view;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Usuarios extends MasterDialogCad {
	
	private JLabel Usuario, Senha, ConfSenha, Perfil;
	private JComboBox<String> ComboPerfil;
	private JTextField JTUsuario, JTSenha, JTConfSenha;
	
	JDesktopPane desktopPane;

	public Usuarios() {

		setSize(510, 210);
		setTitle("Usuários");
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createComponnents();
		setVisible(true);

	}

	public void createComponnents() {

		desktopPane = new JDesktopPane();
		// Botao btnSearch

		Usuario = new JLabel("Usuário:");
		Usuario.setBounds(10, 10, 100, 100);
		getContentPane().add(Usuario);

		Senha = new JLabel("Senha:");
		Senha.setBounds(10, 40, 50, 100);
		getContentPane().add(Senha);

		ConfSenha = new JLabel("Confirmar Senha:");
		ConfSenha.setBounds(10, 70, 200, 100);
		getContentPane().add(ConfSenha);

		Perfil = new JLabel("Perfil:");
		Perfil.setBounds(10, 100, 110, 100);
		getContentPane().add(Perfil);

		JTUsuario = new JTextField();
		JTUsuario.setBounds(110, 50, 200, 26);
		getContentPane().add(JTUsuario);

		JTSenha = new JTextField();
		JTSenha.setBounds(110, 80, 200, 26);
		getContentPane().add(JTSenha);

		JTConfSenha = new JTextField();
		JTConfSenha.setBounds(110, 110, 200, 26);
		getContentPane().add(JTConfSenha);

		ComboPerfil = new JComboBox<String>();
		ComboPerfil.addItem("--Selecione--");
		ComboPerfil.addItem("Cadastral");
		ComboPerfil.addItem("Matricular");
		ComboPerfil.addItem("Financeiro");
		ComboPerfil.addItem("Completo");
		
		ComboPerfil.setBounds(110, 140, 200, 26);
		getContentPane().add(ComboPerfil);

	}

}