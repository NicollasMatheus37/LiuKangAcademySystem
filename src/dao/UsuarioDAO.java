package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.spi.DirStateFactory.Result;

import database.ConnectionFactory;
import model.AlunoModel;
import model.FaturaMatriculaModel;
import model.UsuarioModel;

public class UsuarioDAO extends BaseDAO {
	
	private String is_create_role		=	"create	role		?1" +
			"	with		login" +
			"			encrypted password		'?2'" +
			"			in role				admin";
	
	private String is_alter_role		=	"alter	role		?1" +
			"	with		login" +
			"			encrypted password		'?2'";
	
	private String is_drop_role		=	"drop	role		?1";
	
	private PreparedStatement pre_create_role;
	private PreparedStatement pre_drop_role;
	private PreparedStatement pre_alter_role;
	

	
	public ArrayList<UsuarioModel> getAllUsuarios() throws SQLException {
		ResultSet result = null;
		result = this.select("*")
				.from("usuarios")
				.apply();
		ArrayList<UsuarioModel> usuarioList = new ArrayList<UsuarioModel>();
		while(result.next()) {
			usuarioList.add(new UsuarioModel()
					.setUsuario(result.getString("usuario"))
					.setPerfil(result.getString("perfil"))
					);

		}
		return usuarioList;
	}
	
	public UsuarioModel getOneUsuario(String Usuario) throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("usuarios")
			.where("usuario", "=", Usuario)
			.apply();
		
		UsuarioModel usuario = new UsuarioModel();
		return usuario .setPerfil(result.getString("perfil"))
				.setUsuario(result.getString("usuario"));
	}
	
	public void createUsuario(UsuarioModel usuario) throws SQLException{
		String fields = "usuario, perfil";
		this.insertInto("usuarios", fields)
		.values("'"+
				usuario.getUsuario()+"','"+
				usuario.getPerfil()+"'"
				)
		.commit();

	}
	
	public void updateUsuario(UsuarioModel usuario) throws SQLException{
		this.update("usuarios")
		.setValue(
				"perfil = '"+usuario.getPerfil()+"' "+
						", usuario = '"+usuario.getUsuario()+"' "
						)
		.where("usuario", "=", usuario.getUsuario())
		.commit();
	}
	
	public void deleteUsuario(Integer id) throws SQLException{
		this.delete()
		.from("usuarios")
		.where("id", "=", id.toString())
		.commit();
	}
	
 	public void create_role(UsuarioModel usuario) throws SQLException {
 		
		UsuarioModel user = usuario;
		is_create_role  = is_create_role.replace("?1", user.getUsuario()).replace("?2", user.getSenha());
		pre_create_role = conn.prepareStatement(is_create_role);
		pre_create_role.execute();
 		System.out.println("passou create_role");

 		
	}
 	
 	public void alter_role(UsuarioModel usuario) throws SQLException {
 		UsuarioModel user = usuario;
		is_alter_role = is_alter_role.replace("?1", user.getUsuario()).replace("?2", user.getPerfil());
		pre_alter_role = conn.prepareStatement(is_alter_role);
		pre_alter_role.execute();
	}
 	
 	public void drop_role(UsuarioModel usuario) throws SQLException {
 		UsuarioModel user = usuario;
		is_drop_role = is_drop_role.replace("?1", user.getUsuario());
		pre_drop_role = conn.prepareStatement(is_drop_role);
		pre_drop_role.execute();
	}
 	



}
