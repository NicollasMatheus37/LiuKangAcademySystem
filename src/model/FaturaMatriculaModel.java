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

 	public void setCodigo_matricula(int codigo_matricula) {	
		this.codigo_matricula = codigo_matricula ;			
	}		

 	public Date getData_vencimento() {	
		return data_vencimento;	
	}	

 	public void setData_vencimento(Date data_vencimento) {	
		this.data_vencimento = data_vencimento;	
	}	

 	public float getValor() {	
		return valor;	
	}	

 	public void setValor(float valor) {	
		this.valor = valor;	
	}	

 	public Date getData_pagamento() {	
		return data_pagamento;	
	}	

 	public void setData_pagamento(Date data_pagamento) {	
		this.data_pagamento = data_pagamento;	
	}	

 	public Date getData_cancelamento() {	
		return data_cancelamento;	
	}	

 	public void setData_cancelamento(Date data_cancelamento) {	
		this.data_cancelamento = data_cancelamento;	
	}	

 }