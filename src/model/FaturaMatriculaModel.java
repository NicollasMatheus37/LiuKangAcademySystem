package model;	

 import java.util.Date;	

 public class FaturaMatriculaModel {	

 	private int codigo_matricula;	
	private Date data_vencimento;	
	private float valor;	
	private Date data_pagamento;	
	private Date data_cancelamento;	



 	public int getCodigo_matricula() {	
		return codigo_matricula;	
	}	

 	public FaturaMatriculaModel setCodigo_matricula(int codigo_matricula) {	
		this.codigo_matricula = codigo_matricula ;
		return this;
	}		

 	public Date getData_vencimento() {	
		return data_vencimento;	
	}	

 	public FaturaMatriculaModel setData_vencimento(Date data_vencimento) {	
		this.data_vencimento = data_vencimento;	
		return this;
	}	

 	public float getValor() {	
		return valor;	
	}	

 	public FaturaMatriculaModel setValor(float valor) {	
		this.valor = valor;	
		return this;
	}	

 	public Date getData_pagamento() {	
		return data_pagamento;	
	}	

 	public FaturaMatriculaModel setData_pagamento(Date data_pagamento) {	
		this.data_pagamento = data_pagamento;	
		return this;
	}	

 	public Date getData_cancelamento() {	
		return data_cancelamento;	
	}	

 	public FaturaMatriculaModel setData_cancelamento(Date data_cancelamento) {	
		this.data_cancelamento = data_cancelamento;	
		return this;
	}	

 }