package view;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.ModalidadeDAO;
import model.ModalidadeModel;

@SuppressWarnings("serial")
public class BuscarModalidade extends MasterBuscar {

	public ModalidadeModel modalidadeReturn;
	private ArrayList<ModalidadeModel> modalidades;
	private ModalidadeDAO modalidadeDAO;

	public BuscarModalidade() {
		modalidadeDAO = new ModalidadeDAO();
		updateComp(new String[]{"Nome"});
		modalidadeReturn = null;
	}

	protected void buscar() {		
		try {
			clean();
			modalidades = modalidadeDAO.getAllModalidades();
			for(int i = 0; i < modalidades.size(); i++) {

				if(utils.containsIgnoreCase(modalidades.get(i).getModalidade(), jTxtBusca.getText())) {						
					InsertRow("",modalidades.get(i).getModalidade());
				}else {
					modalidades.remove(i);
					i--;
				}

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	protected void setReturn() {
		modalidadeReturn = modalidades.get(table.getSelectedRow());
	}
}
