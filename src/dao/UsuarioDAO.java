package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AssiduidadeModel;
import model.UsuarioModel;

public class UsuarioDAO extends BaseDAO {
	
	public ArrayList<UsuarioModel> getAllUsuarios() throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("usuario")
			.apply();
		
		result.first();
		
		ArrayList<UsuarioModel> usuarioList = new ArrayList<UsuarioModel>();
		while((result.getRow() != 0) && (!result.isAfterLast())) {
			usuarioList.add(new UsuarioModel()
					
					.setPerfil(result.getString("perfil"))
					.setUsuario(result.getInt("usuario"))
					);
					result.next();
					}
					return usuarioList;
	}
	
	public UsuarioModel getOneUsuario(Integer id) throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("usuario")
			.where("id", "=", id.toString())
			.apply();
		
		UsuarioModel usuario = new UsuarioModel();
		return usuario .setPerfil(result.getString("perfil"))
				.setUsuario(result.getInt("usuario"));
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
