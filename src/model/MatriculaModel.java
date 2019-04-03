package model;	

 import java.util.Date;	

 public class MatriculaModel {	

 	private int codigo_matricula;		
	private int codigo_aluno;		
	private Date data_matricula;	
	private int dia_vencimento;	
	private Date data_encerramento;	


 	public int getcodigo_matricula() {	
		return codigo_matricula;	
	}	

 	public MatriculaModel setCodigo_matricula(int codigo_matricula) {	
		codigo_matricula = this.codigo_matricula;	
		return this;
	}	

 	public int getCodigo_aluno() {	
		return codigo_aluno;	
	}	

 	public MatriculaModel setCodigo_aluno(int codigo_aluno) {	
		codigo_aluno = this.codigo_aluno;			
		return this;
	}	

 	public Date getData_matricula() {	
		return data_matricula;	
	}	

 	public MatriculaModel setData_matricula(Date data_matricula) {	
		this.data_matricula = data_matricula;	
		return this;
	}	

 	public int getDia_vencimento() {	
		return dia_vencimento;	
	}	

 	public MatriculaModel setDia_vencimento(int dia_vencimento) {	
		this.dia_vencimento = dia_vencimento;	
		return this;
	}	

 	public Date getData_encerramento() {	
		return data_encerramento;	
	}	

 	public MatriculaModel setData_encerramento(Date data_encerramento) {	
		this.data_encerramento = data_encerramento;	
		return this;
	}	



 }