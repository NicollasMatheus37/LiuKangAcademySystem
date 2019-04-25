package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AssiduidadeModel;
import model.ModalidadeModel;

public class ModalidadeDAO extends BaseDAO {

	public ArrayList<ModalidadeModel> getAllModalidades() throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("modalidades")
			.apply();
		
		result.first();
		
		ArrayList<ModalidadeModel> modalidadeList = new ArrayList<ModalidadeModel>();
		while((result.getRow() != 0) && (!result.isAfterLast())) {
			modalidadeList.add(new ModalidadeModel()
					
					.setModalidade(result.getString("modalidade"))
					);
					result.next();
					}
					return modalidadeList;
	}
	
	public ModalidadeModel getOneModalidade(Integer id) throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("modalidades")
			.where("id", "=", id.toString())
			.apply();
		
		ModalidadeModel modalidade = new ModalidadeModel();
		return modalidade .setModalidade(result.getString("modalidade"));
	}
	
	public void createModalidade(String fields, String values) throws SQLException{
		this.insertInto("modalidades", fields)
		.values(values)
		.commit();
	}
	
	public void updateModalidade(String fields, String value, Integer id) throws SQLException{
		this.update("modalidades")
		.setValue(fields, value)
		.where("id", "=", id.toString())
		.commit();
	}
	
	public void deleteModalidade(Integer id) throws SQLException{
		this.delete()
		.from("modalidades")
		.where("id", "=", id.toString())
		.commit();
	}
	
}
