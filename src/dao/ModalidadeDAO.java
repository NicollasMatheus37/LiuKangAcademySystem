package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModalidadeDAO extends BaseDAO {

	public ResultSet getAllModalidades() throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("modalidades")
			.apply();
		return result;
	}
	
	public ResultSet getOneModalidade(Integer id) throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("modalidades")
			.where("id", "=", id.toString())
			.apply();
		return result;
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
