package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MatriculaDAO extends BaseDAO {
	
	public ResultSet getAllMatriculas() throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("matriculas")
			.apply();
		return result;
	}
	
	public ResultSet getOneMatricula(Integer id) throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("matriculas")
			.where("id", "=", id.toString())
			.apply();
		return result;
	}
	
	public void createMatricula(String fields, String values) throws SQLException{
		this.insertInto("matriculas", fields)
		.values(values)
		.commit();
	}
	
	public void updateMatricula(String fields, String value, Integer id) throws SQLException{
		this.update("matriculas")
		.setValue(fields, value)
		.where("id", "=", id.toString())
		.commit();
	}
	
	public void deleteMatricula(Integer id) throws SQLException{
		this.delete()
		.from("matriculas")
		.where("id", "=", id.toString())
		.commit();
	}
	
}
