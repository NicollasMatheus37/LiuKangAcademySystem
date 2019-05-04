package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ModalidadeModel;

public class ModalidadeDAO extends BaseDAO {

	public ArrayList<ModalidadeModel> getAllModalidades() throws SQLException{
		ResultSet result = null;
		result = this.select("*")
				.from("modalidades")
				.apply();

		ArrayList<ModalidadeModel> modalidadeList = new ArrayList<ModalidadeModel>();
		while(result.next()) {
			modalidadeList.add(new ModalidadeModel()
					.setModalidade(result.getString("modalidade"))
					);
		}

		return modalidadeList;
	}

	/*	
	public ModalidadeModel getOneModalidade(String modalidade) throws SQLException{

		ResultSet result = null;
		result = this.select("*")
			.from("modalidades")
			.where("id", "=", id.toString())
			.apply();

		ModalidadeModel modalidade = new ModalidadeModel();
		return modalidade .setModalidade(result.getString("modalidade"));
	}	
	 */	

	public void createModalidade(ModalidadeModel modalidade) throws SQLException{
		String fields = "modalidade";
		this.insertInto("modalidades", fields)
		.values(quoteStr(modalidade.getModalidade()))
		.commit();
	}

	public void updateModalidade(String oldModalidade,String newModalidade) throws SQLException{
		this.update("modalidades")
		.setValue("modalidade = "+quoteStr(newModalidade))
		.where("modalidade", "=", quoteStr(oldModalidade))
		.commit();
	}

	public void deleteModalidade(String modalidade) throws SQLException{
		this.delete()
		.from("modalidades")
		.where("modalidade", "=", quoteStr(modalidade))
		.commit();
	}

}
