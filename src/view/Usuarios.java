package view;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Usuarios extends JInternalFrame {

	private JButton btnSearch, btnAdd, btnDelete, btnSave;
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
		btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				

			}
		});
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

	}

}