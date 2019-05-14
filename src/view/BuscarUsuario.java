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
		updateComp(new String[] {"Usuario"});
		userReturn = null;
		//String colunas[]={"Usuario","Perfil"};
		//model = new DefaultTableModel(colunas,0);
		System.out.println("Construtor");
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
