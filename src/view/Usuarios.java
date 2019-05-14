package view;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;

import javax.swing.JComboBox;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import dao.UsuarioDAO;
import model.UsuarioModel;

@SuppressWarnings("serial")
public class Usuarios extends MasterDialogCad {
	
	private JLabel Usuario, Senha, ConfSenha, Perfil;
	private JComboBox<String> ComboPerfil;
	private JTextField JTUsuario, JTSenha, JTConfSenha;
	private UsuarioDAO usuarioDao;
	private UsuarioModel usuario, usuarioChange;
	private BuscarUsuario busca;
	

	public Usuarios() throws ParseException{

		usuarioDao = new UsuarioDAO();
		
		setSize(510, 210);
		setTitle("Usuários");
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
		busca = new BuscarUsuario();
		try {						
			busca.addWindowListener(eventWindowSearchClosed);				
		} catch (Exception e2) {
			busca = null;
		}
	}
	
	protected boolean afterSearch() {
		if(busca.userReturn!=null) {
			usuario = busca.userReturn;
			return true;
		}
		return false;
	}
	

	protected boolean actionSave() {
		if(usuarioChange==null || JTSenha.getText().isEmpty() || JTConfSenha.getText().isEmpty() || JTUsuario.getText().isEmpty() || ComboPerfil.getSelectedItem().equals("--Selecione--")) {
			JOptionPane.showMessageDialog(null, "Há Campos Vazios");
			return false;
		}
		else if(JTConfSenha.getText().length()<5 || JTSenha.getText().length()<5 || JTUsuario.getText().length()<5 ) {
			JOptionPane.showMessageDialog(null, "Tamanho minimo para os campos de 5 caracteres");
			return false;
		}
		else {	try {
				if(isInserting) {
					usuarioDao.createUsuario(usuarioChange);
					usuarioDao.drop_role(usuarioChange);
					usuarioDao.create_role(usuarioChange);
				}else {
					usuarioDao.updateUsuario(usuarioChange);
					//usuarioDao.drop_role(usuarioChange);
					//usuarioDao.alter_role(usuarioChange);
					System.out.println("passou aqui2");
				}
				return true;
			}catch (Exception e) {
				return false;
			}
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
	
	

	protected void subComponents() {

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
			public void focusLost(FocusEvent e) {
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
			public void focusLost(FocusEvent e) {
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
		
		childContainer = getContentPane();
	}

}