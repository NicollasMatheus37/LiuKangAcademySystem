package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MatriculaModalidadeDAO extends BaseDAO {
	
	public ResultSet getAllMatriculasModalidades() throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("matriculas_modalidades")
			.apply();
		return result;
	}
	
	public ResultSet getOneMatriculaModalidade(Integer id) throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("matriculas_modalidades")
			.where("id", "=", id.toString())
			.apply();
		return result;
	}
	
	public void createMatriculaModalidade(String fields, String values) throws SQLException{
		this.insertInto("matriculas_modalidades", fields)
		.values(values)
		.commit();
	}
	
	public void updateMatriculaModalidade(String fields, String value, Integer id) throws SQLException{
		this.update("matriculas_modalidades")
		.setValue(fields, value)
		.where("id", "=", id.toString())
		.commit();
	}
	
	public void deleteMatriculaModalidade(Integer id) throws SQLException{
		this.delete()
		.from("matriculas_modalidades")
		.where("id", "=", id.toString())
		.commit();
	}

}
