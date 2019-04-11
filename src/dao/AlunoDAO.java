package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import model.AlunoModel;

public class AlunoDAO extends BaseDAO {

	public ResultSet getAllAlunos() throws SQLException {
		ResultSet result = null;
		result = this.select("*")
			.from("alunos")
			.apply();
		return result;
	}
	
	public ResultSet getOneAluno(Integer id) throws SQLException {
		ResultSet result = null;
		result = this.select("*")
			.from("alunos")
			.where("id", "=", id.toString())
			.apply();
		return result;
	}
	
	public void createAluno(String fields, String values) throws SQLException {
		this.insertInto("alunos", fields)
			.values(values)
			.commit();
	}
	
	public void updateAluno(String fields, String value, Integer id) throws SQLException {
		this.update("alunos")
			.setValue(fields, value)
			.where("id", "=", id.toString())
			.commit();
	}
	
	public void deleteAluno(Integer id) throws SQLException {
		this.delete()
			.from("alunos")
			.where("id", "=", id.toString())
			.commit();
	}
	
}
