package view;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import dao.PlanoDAO;
import model.PlanoModel;

@SuppressWarnings("serial")
public class BuscarPlano extends MasterBuscar{

	public PlanoModel planoReturn;
	private ArrayList<PlanoModel> planos;
	private PlanoDAO planoDAO;

	public BuscarPlano() {
		planoDAO = new PlanoDAO();
		model = new DefaultTableModel(new String[]{"Modalidade","Plano"}, 0);
		updateComp(new String[]{"Modalidade"});
		table.getColumnModel().getColumn(0).setPreferredWidth(210);
		table.getColumnModel().getColumn(1).setPreferredWidth(210);
		planoReturn = null;
	}

	protected void buscar() {		
		try {
			clean();
			planos = planoDAO.getAllPlanos("");
			for(int i = 0; i < planos.size(); i++) {

				if(utils.containsIgnoreCase(planos.get(i).getModalidade(), jTxtBusca.getText())) {						
					InsertRow(planos.get(i).getModalidade(),planos.get(i).getPlano());
				}else {
					planos.remove(i);
					i--;
				}

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	protected void setReturn() {
		planoReturn = planos.get(table.getSelectedRow());
	}
	
}
