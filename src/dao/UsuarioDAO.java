package dao;

public class UsuarioDAO extends BaseDAO {
	
	public void getAllUsuarios() {
		this.select("*")
			.from("usuario")
			.apply();
	}
	
	public void getOneUsuario(Integer id) {
		this.select("*")
			.from("usuario")
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void createUsuario(String fields, String values) {
		this.insertInto("usuario", fields)
			.values(values)
			.apply();
	}
	
	public void updateUsuario(String fields, String value, Integer id) {
		this.update("usuario")
			.setValue(fields, value)
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void deleteUsuario(Integer id) {
		this.delete()
			.from("usuario")
			.where("id", "=", id.toString());
	}

}
