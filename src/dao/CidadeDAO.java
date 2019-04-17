package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CidadeDAO extends BaseDAO {

	public ResultSet getAllCidades() throws SQLException {
		ResultSet result = null;
		result = this.select("*")
			.from("cidades")
			.apply();
		return result;
	}
	
	public ResultSet getOneCidade(Integer id) throws SQLException {
		ResultSet result = null;
		result = this.select("*")
			.from("cidades")
			.where("id", "=", id.toString())
			.apply();
		return result;
	}
	
	public void createCidade(String fields, String values) throws SQLException {
		this.insertInto("cidades", fields)
		.values(values)
		.commit();
	}
	
	public void updateCidade(String fields, String value, Integer id) throws SQLException {
		this.update("cidades")
		.setValue(fields, value)
		.where("id", "=", id.toString())
		.commit();
	}
	
	public void deleteCidade(Integer id) throws SQLException{
		this.delete()
		.from("cidades")
		.where("id", "=", id.toString())
		.commit();
	}
	
}
