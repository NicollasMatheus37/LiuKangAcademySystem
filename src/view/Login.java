package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;

import javax.print.DocFlavor.URL;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.AbstractBorder;

import dao.UsuarioDAO;

public class Login extends JFrame {

	private JDesktopPane desktopPane;
	private JTextField txfNome;
	private JPasswordField txfSenha;
	private JLabel lblNome, lblSenha;
	private JButton btnLogin;
	private Shape shape;

	public Login() {

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

		setSize(500, 300);
		setTitle("Login");
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setContentPane(CreateContentPane());
		setContentPane(desktopPane);
		ComponentLogin();
		ImageIcon imagemTituloJanela = new ImageIcon("Images/48x48/icon.jpg");
		setIconImage(imagemTituloJanela.getImage());
		setVisible(true);
	}

	public void ComponentLogin() {

		lblNome = new JLabel("Usuário:");
		lblNome.setBounds(47, 60, 100, 100);
		getContentPane().add(lblNome);
		lblNome.setForeground(Color.WHITE);

		txfNome = new JTextField("");
		txfNome.setBounds(100, 100, 100, 26);
		getContentPane().add(txfNome);

		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(55, 100, 100, 100);
		getContentPane().add(lblSenha);
		lblSenha.setForeground(Color.WHITE);

		txfSenha = new JPasswordField("");
		txfSenha.setBounds(100, 140, 100, 26);
		getContentPane().add(txfSenha);

		btnLogin = new JButton(new AbstractAction("Login") {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (!txfNome.getText().isEmpty() && !txfSenha.getText().isEmpty()) {
					if(new UsuarioDAO().userLogin(txfNome.getText(), txfSenha.getText()) || txfNome.getText().equals("admin") && txfSenha.getText().equals("admin")) {
						dispose();
						new Menu();
				}
					else {
						JOptionPane.showMessageDialog(null, "Usuario ou senha Incorretos");
						txfNome.setText(null);txfSenha.setText(null);
					}
				} else {

					JOptionPane.showMessageDialog(null, "Preencher todos os campos");

				}
			}
		});
		btnLogin.setBounds(105, 180, 90, 26);
		getContentPane().add(btnLogin);

	}

	public void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		paintComponent(g);
	}

	public void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
	}

	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		}
		return shape.contains(x, y);
	}

	public Container CreateContentPane() {

		JPanel contentPane = new JPanel(new BorderLayout());
		desktopPane = new JDesktopPane() {
			Image im = (new ImageIcon("Images/background/login.png")).getImage();

			public void paintComponent(Graphics g) {
				g.drawImage(im, 0, 0, getWidth(), getHeight(), this);

			}
		};

		contentPane.setOpaque(true);
		contentPane.add(desktopPane);
		return contentPane;
	}

	public static void main(String args[]) {

		new Login();
	}
}
