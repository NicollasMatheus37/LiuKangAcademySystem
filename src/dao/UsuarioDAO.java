package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
					.setUsuario(result.getString("usuario"))
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
				.setUsuario(result.getString("usuario"));
	}
	
	public void createUsuario(UsuarioModel usuario) throws SQLException{
		String fields = "perfil, usuario, senha";
		this.insertInto("usuario", fields)
		.values(
				usuario.getPerfil()+","+
				usuario.getUsuario()
				)
		.commit();
	}
	
	public void updateUsuario(UsuarioModel usuario) throws SQLException{
		this.update("usuario")
		.setValue(
				"perfil = "+usuario.getPerfil()+
				"usuario = "+usuario.getUsuario()
				)
		.commit();
	}
	
	public void deleteUsuario(Integer id) throws SQLException{
		this.delete()
		.from("usuario")
		.where("id", "=", id.toString())
		.commit();
	}
	
 	public void create_role(UsuarioModel usuario) throws SQLException {
		ResultSet result = null;
		is_create_role = is_create_role.replace(usuario.getUsuario(), usuario.getSenha());
		result = this.customSql(is_create_role).excecuteQuery();		
	}
 	
 	public void update_role(UsuarioModel usuario) throws SQLException {
		ResultSet result = null;
		is_alter_role = is_alter_role.replace(usuario.getUsuario(), usuario.getPerfil());
		result = this.customSql(is_alter_role).excecuteQuery();		
	}
 	
 	public void drop_role(UsuarioModel usuario) throws SQLException {
		ResultSet result = null;
		is_drop_role = is_drop_role.replace("?1", usuario.getUsuario());
		result = this.customSql(is_drop_role).excecuteQuery();		
	}


}
