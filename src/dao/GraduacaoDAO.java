package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GraduacaoDAO extends BaseDAO {
	
	public ResultSet getAllGraduacoes() throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("graduacoes")
			.apply();
		return result;
	}
	
	public ResultSet getOneGraduacao(Integer id) throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("graduacoes")
			.where("id", "=", id.toString())
			.apply();
		return result;
	}
	
	public void createGraduacao(String fields, String values) throws SQLException{
		this.insertInto("graduacoes", fields)
		.values(values)
		.commit();
	}
	
	public void updateGraduacao(String fields, String value, Integer id) throws SQLException{
		this.update("graduacoes")
		.setValue(fields, value)
		.where("id", "=", id.toString())
		.commit();
	}
	
	public void deleteGraduacao(Integer id) throws SQLException{
		this.delete()
		.from("graducoes")
		.where("id", "=", id.toString())
		.commit();
	}

}
