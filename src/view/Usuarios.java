package view;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JComboBox;

import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.AlunoDAO;
import dao.UsuarioDAO;
import model.AlunoModel;
import model.UsuarioModel;

public class Usuarios extends MasterDialogCad {
	
	private JLabel Usuario, Senha, ConfSenha, Perfil;
	private JComboBox<String> ComboPerfil;
	private JTextField JTUsuario, JTSenha, JTConfSenha;
	private UsuarioDAO usuarioDao;
	private UsuarioModel usuario, usuarioChange;


	public Usuarios() throws ParseException{

		usuarioDao = new UsuarioDAO();
		
		setSize(510, 210);
		setTitle("Usu�rios");
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

	}
	
	/*protected boolean actionDelete() {
		if((usuario!=null) && (!isInserting)) {
			try {
				usuarioDao.deleteUsuario(usuarioChange);
				return true;
			} catch (SQLException e) {
				return false;
			}						
		}else {
			return false;
		}
	}*/

	protected boolean actionAdd() {
		if(!isInserting) {
			try {
				usuario = new UsuarioModel();
				return true;
			} catch (Exception e) {
				return false;
			}			
		}else {
			return false;
		}
	}

	protected void actionSearch() {
		
	}

	protected boolean actionSave() {
		if(usuarioChange!=null) {
			try {
				if(isInserting) {
					usuarioDao.createUsuario(usuarioChange);
				}else {
					usuarioDao.updateUsuario(usuarioChange);
				}
				return true;
			}catch (Exception e) {
				return false;
			}
		}else {
			return false;
		}
	}

	protected boolean actionCancel() {
		try {			
			usuario = null;
			usuarioChange = null;			
		}catch (Exception e) {
		}				
		return true;		
	}
	
	protected void fillFields() {

		JTUsuario.setText((usuario.getUsuario()));
		JTSenha.setText((usuario.getUsuario()));
		ComboPerfil.setSelectedItem(usuario.getPerfil());
		
		usuarioChange = usuario;
	}
	
	

	public void subComponents() {


		JTUsuario = new JTextField();
		JTUsuario.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				if((!e.isTemporary()) && (usuarioChange != null)) {
					usuarioChange.setUsuario(JTUsuario.getText());
				}
			}
		});
		JTUsuario.setBounds(110, 50, 200, 26);
		getContentPane().add(JTUsuario);

		JTSenha = new JTextField();
		JTSenha.addFocusListener(new FocusAdapter() {
			public void focuslost(FocusEvent e) {
				if((!e.isTemporary()) && (usuarioChange != null)) {
					usuarioChange.setSenha(JTSenha.getText());
				}
			}
		});
		JTSenha.setBounds(110, 80, 200, 26);
		getContentPane().add(JTSenha);

		JTConfSenha = new JTextField();
		JTConfSenha.setBounds(110, 110, 200, 26);
		getContentPane().add(JTConfSenha);

		ComboPerfil = new JComboBox<String>();
		ComboPerfil.addFocusListener(new FocusAdapter() {
			public void focuslost(FocusEvent e) {
				if (ComboPerfil.getSelectedIndex()>0) {
					usuarioChange.setPerfil(ComboPerfil.getSelectedItem().toString());
				}
			}
		});
		ComboPerfil.addItem("--Selecione--");
		ComboPerfil.addItem("Cadastral");
		ComboPerfil.addItem("Matricular");
		ComboPerfil.addItem("Financeiro");
		ComboPerfil.addItem("Completo");
		
		ComboPerfil.setBounds(110, 140, 200, 26);
		getContentPane().add(ComboPerfil);
		
		Usuario = new JLabel("Usu�rio:");
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
		
		childContainer = getContentPane();

	}

}