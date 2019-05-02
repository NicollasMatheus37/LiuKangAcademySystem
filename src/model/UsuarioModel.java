package model;	

 public class UsuarioModel {	

 	private String usuario;		
	private String perfil;
	private String senha;

	public UsuarioModel(){
		clean();
	}
	
	public void clean() {
		setUsuario("");
		setSenha("");
		setPerfil("");
	}
	
 	public String getUsuario() {	
		return usuario;	
	}	

 	public UsuarioModel setUsuario(String usuario) {	
		this.usuario = usuario ;	
		return this;
	}	

 	public String getPerfil() {	
		return perfil;	
	}	
	public UsuarioModel setPerfil(String perfil) {	
		this.perfil = perfil;	
		return this;
	}

	public UsuarioModel setSenha(String senha) {
		this.senha = senha;
		return this;
	}	

 }	
