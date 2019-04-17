package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FaturaMatriculaDAO extends BaseDAO {
	
	public ResultSet getAllFaturasMatriculas() throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("faturas_matriculas")
			.apply();
		return result;
	}
	
	public ResultSet getOneFaturaMatricula(Integer id) throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("faturas_matriculas")
			.where("id", "=", id.toString())
			.apply();
		return result;
	}
	
	public void createFaturaMatricula(String fields, String values) throws SQLException{
		this.insertInto("faturas_matriculas", fields)
		.values(values)
		.commit();
	}
	
	public void updateFaturaMatricula(String fields, String value, Integer id) throws SQLException{
		this.update("faturas_matriculas")
		.setValue(fields, value)
		.where("id", "=", id.toString())
		.commit();
	}
	
	public void deleteFaturaMatricula(Integer id) throws SQLException{
		this.delete()
		.from("faturas_matriculas")
		.where("id", "=", id.toString())
		.commit();
	}

}
