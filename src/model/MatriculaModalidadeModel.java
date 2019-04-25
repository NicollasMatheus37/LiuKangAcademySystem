package model;	

 import java.util.Date;	

 public class MatriculaModalidadeModel {	

 	private int codigo_matricula;		
	private String modalidade;	
	private String graduacao;	
	private String plano;	
	private Date data_inicio;	
	private Date data_fim;	


 	public int getCodigoMatricula() {	
		return codigo_matricula;	
	}	

 	public MatriculaModalidadeModel setCodigoMatricula(int codigo_matricula) {	
		codigo_matricula = this.codigo_matricula;		
		return this;
	}	

 	public String getModalidade() {	
		return modalidade;	
	}	

 	public MatriculaModalidadeModel setModalidade(String modalidade) {	
		modalidade = this.modalidade;			
		return this;
	}	

 	public String getGraduacao() {	
		return modalidade;	
	}	

 	public MatriculaModalidadeModel setGraduacao(String graduacao) {	
		graduacao = this.graduacao;			
		return this;
	}	

 	public String getPlano() {	
		return plano;	
	}	

 	public MatriculaModalidadeModel setPlano(String plano) {	
		plano = this.plano;		
		return this;
	}	

 	public Date getDataMatricula() {	
		return data_inicio;	
	}	

 	public MatriculaModalidadeModel setDataInicio(Date data_inicio) {	
		this.data_inicio = data_inicio;	
		return this;
	}	

 	public Date getData_fim() {	
		return data_fim;	
	}	

 	public MatriculaModalidadeModel setDataFim(Date data_fim) {	
		this.data_fim = data_fim;	
		return this;
	}	



 }