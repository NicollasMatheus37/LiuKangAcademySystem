
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {

	private JTextField txfNome;
	private JPasswordField txfSenha;
	private JLabel lblNome, lblSenha, lblMsgNoUser, lblSenhaInvalida, lblNoPass, lblMsgNoName;
	private JButton btnProximo, btnLogin, btnVoltar, circle;
	File user;

	public Login() {

		setSize(400, 400);
		setTitle("Login");
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		ComponentLogin();
		setVisible(true);
	}

	public void ComponentLogin() {

		lblNome = new JLabel("Usuário:");
		lblNome.setBounds(90, 80, 100, 100);
		getContentPane().add(lblNome);

		txfNome = new JTextField("");
		txfNome.setBounds(150, 120, 100, 26);
		getContentPane().add(txfNome);

		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(100, 120, 100, 100);
		getContentPane().add(lblSenha);

		txfSenha = new JPasswordField("");
		txfSenha.setBounds(150, 160, 100, 26);
		getContentPane().add(txfSenha);

		btnLogin = new JButton(new AbstractAction("Login") {

			@Override
			public void actionPerformed(ActionEvent e) {

			
				
			}
			
		});
		btnLogin.setBounds(155, 230, 90, 26);
		getContentPane().add(btnLogin);
	}
/*	public static void main(String args[]) {

		new Login();
	}*/
}
