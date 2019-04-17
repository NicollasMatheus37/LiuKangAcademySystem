package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO extends BaseDAO {
	
	public ResultSet getAllUsuarios() throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("usuario")
			.apply();
		return result;
	}
	
	public ResultSet getOneUsuario(Integer id) throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("usuario")
			.where("id", "=", id.toString())
			.apply();
		return result;
	}
	
	public void createUsuario(String fields, String values) throws SQLException{
		this.insertInto("usuario", fields)
		.values(values)
		.commit();
	}
	
	public void updateUsuario(String fields, String value, Integer id) throws SQLException{
		this.update("usuario")
		.setValue(fields, value)
		.where("id", "=", id.toString())
		.commit();
	}
	
	public void deleteUsuario(Integer id) throws SQLException{
		this.delete()
		.from("usuario")
		.where("id", "=", id.toString())
		.commit();
	}

}
