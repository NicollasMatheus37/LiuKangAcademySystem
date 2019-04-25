package model;	

 import java.util.Date;	

 public class MatriculaModel {	

 	private int codigo_matricula;		
	private int codigo_aluno;		
	private Date data_matricula;	
	private int dia_vencimento;	
	private Date data_encerramento;	


 	public int getcodigoMatricula() {	
		return codigo_matricula;	
	}	

 	public MatriculaModel setCodigoMatricula(int codigo_matricula) {	
		codigo_matricula = this.codigo_matricula;	
		return this;
	}	

 	public int getCodigoAluno() {	
		return codigo_aluno;	
	}	

 	public MatriculaModel setCodigoAluno(int codigo_aluno) {	
		codigo_aluno = this.codigo_aluno;			
		return this;
	}	

 	public Date getDataMatricula() {	
		return data_matricula;	
	}	

 	public MatriculaModel setDataMatricula(Date data_matricula) {	
		this.data_matricula = data_matricula;	
		return this;
	}	

 	public int getDiaVencimento() {	
		return dia_vencimento;	
	}	

 	public MatriculaModel setDiaVencimento(int dia_vencimento) {	
		this.dia_vencimento = dia_vencimento;	
		return this;
	}	

 	public Date getDataEncerramento() {	
		return data_encerramento;	
	}	

 	public MatriculaModel setDataEncerramento(Date data_encerramento) {	
		this.data_encerramento = data_encerramento;	
		return this;
	}	



 }