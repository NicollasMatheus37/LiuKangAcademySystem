package model;	

 import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

 public class MatriculaModel {	

 	private int codigo_matricula;		
	private int codigo_aluno;		
	private Date data_matricula;	
	private int dia_vencimento;	
	private Date data_encerramento;	

	
	public MatriculaModel() {
		
		clean();
				
	}
	
	public void clean() {
		
		codigo_matricula = 0;
		codigo_aluno = 0;
		data_matricula = new Date();
		data_encerramento = new Date();
		dia_vencimento = Calendar.DAY_OF_MONTH;
		
	}

 	public int getCodigoMatricula() {	
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

 	public Date getDataMatriculaDate() {	
		return data_matricula;	
	}	
 	
 	public String getDataMatricula() {
 		return new SimpleDateFormat("##/##/####").format(data_matricula);
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

 	public Date getDataEncerramentoDate() {	
		return data_encerramento;	
	}	
 	
 	public String getDataEncerramento() {
 		return new SimpleDateFormat("##/##/####").format(data_encerramento);
 	}

 	public MatriculaModel setDataEncerramento(Date data_encerramento) {	
		this.data_encerramento = data_encerramento;	
		return this;
	}	



 }