package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlanoDAO extends BaseDAO {
	
	public ResultSet getAllPlanos() throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("planos")
			.apply();
		return result;
	}
	
	public ResultSet getOnePlano(Integer id) throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("planos")
			.where("id", "=", id.toString())
			.apply();
		return result;
	}
	
	public void createPlano(String fields, String values) throws SQLException{
		this.insertInto("planos", fields)
		.values(values)
		.commit();
	}
	
	public void updatePlano(String fields, String value, Integer id) throws SQLException{
		this.update("planos")
			.setValue(fields, value)
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void deletePlano(Integer id) throws SQLException{
		this.delete()
		.from("planos")
		.where("id", "=", id.toString())
		.commit();
	}
	
}
