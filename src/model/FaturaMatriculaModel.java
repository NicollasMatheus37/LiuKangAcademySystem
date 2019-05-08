package model;	

 import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;	

 public class FaturaMatriculaModel {	

 	private int codigoMatricula;	
	private Date dataVencimento;	
	private float valor;	
	private Date dataPagamento;	
	private Date dataCancelamento;	



 	public int getCodigoMatricula() {	
		return codigoMatricula;	
	}	

 	public FaturaMatriculaModel setCodigoMatricula(int codigo_matricula) {	
		this.codigoMatricula = codigo_matricula ;
		return this;
	}		

 	public Date getDataVencimento() {	
		return dataVencimento;	
	}	

 	public FaturaMatriculaModel setDataVencimento(Date data_vencimento) {	
		this.dataVencimento = data_vencimento;	
		return this;
	}	

 	public float getValor() {	
		return valor;	
	}	

 	public FaturaMatriculaModel setValor(float valor) {	
		this.valor = valor;	
		return this;
	}	

 	public Date getDataPagamento() {	
		return dataPagamento;	
	}	

 	public FaturaMatriculaModel setDataPagamento(Date data_pagamento) {	
		this.dataPagamento = data_pagamento;	
		return this;
	}	

 	public Date getDataCancelamento() {	
		return dataCancelamento;	
	}	

 	public FaturaMatriculaModel setDataCancelamento(Date data_cancelamento) {	
		this.dataCancelamento = data_cancelamento;	
		return this;
 	}
 	

 }