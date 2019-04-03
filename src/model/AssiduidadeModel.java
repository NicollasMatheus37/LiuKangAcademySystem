package model;

import java.util.Date;

public class AssiduidadeModel {

	private int codigo_matricula;	
	private Date data_entrada; 


	public int getCodigo_matricula() {
		return codigo_matricula;
	}

	public AssiduidadeModel setCodigo_matricula(int codigo_matricula) {
		this.codigo_matricula = codigo_matricula;		
		return this;
	}

	public Date getPerfil() {
		return data_entrada;
	}
	public AssiduidadeModel setData_entrada(Date data_entrada) {
		this.data_entrada = data_entrada;
		return this;
	}

}








