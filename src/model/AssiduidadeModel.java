package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AssiduidadeModel {

	private int codigo_matricula;
	private Date data_entrada;

	public AssiduidadeModel() {
		
		clean();
		
	}
	
	public void clean() {
		
		codigo_matricula = 0;
		data_entrada = new Date();
		
	}
	
	public int getCodigoMatricula() {
		return codigo_matricula;
	}

	public AssiduidadeModel setCodigoMatricula(int codigo_matricula) {
		this.codigo_matricula = codigo_matricula;		
		return this;
	}

	public Date getDataEntradaDate() {
		return data_entrada;
	}
	
	public String getDataEntrada() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(data_entrada);
	}
	
	public AssiduidadeModel setDataEntrada(Date data_entrada) {
		this.data_entrada = data_entrada;
		return this;
	}
	
	

}








