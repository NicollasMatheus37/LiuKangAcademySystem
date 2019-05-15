package view;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import dao.UsuarioDAO;
import model.AlunoModel;
import model.MatriculaModel;
import model.UsuarioModel;

public class BuscarUsuario extends MasterBuscar {
	
	UsuarioModel userReturn;
	private ArrayList<UsuarioModel> userList;
	
	public BuscarUsuario() {
		model = new DefaultTableModel(new String[]{"Usuario","Perfil"}, 0);
		updateComp(new String[] {"Usuario"});
		table.getColumnModel().getColumn(0).setPreferredWidth(210);
		table.getColumnModel().getColumn(1).setPreferredWidth(210);
		userReturn = null;
	}

	protected void buscar() {
		System.out.println("buscar");
		try {
			System.out.println("buscar");
			clean();

				userList = new UsuarioDAO().getAllUsuarios();
				for(int i = 0; i < userList.size(); i++) {

					if(utils.containsIgnoreCase(userList.get(i).getUsuario(), jTxtBusca.getText())) {						
						InsertRow((userList.get(i).getUsuario()), userList.get(i).getPerfil());
					}else {
						userList.remove(i);
						i--;
					}
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	protected void setReturn() {
		userReturn = userList.get(table.getSelectedRow());
	}

}
