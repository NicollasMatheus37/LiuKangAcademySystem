package model;	

import java.text.SimpleDateFormat;
import java.util.Date;	

 public class FaturaMatriculaModel {	

 	private int codigoMatricula;	
	private Date dataVencimento;	
	private float valor;	
	private Date dataPagamento;	
	private Date dataCancelamento;	
	private String situacao;



 	public int getCodigoMatricula() {	
		return codigoMatricula;	
	}	

 	public FaturaMatriculaModel setCodigoMatricula(int codigo_matricula) {	
		this.codigoMatricula = codigo_matricula ;
		return this;
	}		

 	public String getDataVencimento() {	
		return new SimpleDateFormat("dd/MM/yyyy").format(dataVencimento);	
	}	
 	
 	public Date getDataVencimentoDate() {	
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
 	
 	public String getDataPagamento() {	
		return new SimpleDateFormat("dd/MM/yyyy").format(dataPagamento);	
	}

 	public Date getDataPagamentoDate() {	
		return dataPagamento;	
	}	

 	public FaturaMatriculaModel setDataPagamento(Date data_pagamento) {	
		this.dataPagamento = data_pagamento;	
		return this;
	}	
 	
 	public String getDataCancelamento() {	
		return  new SimpleDateFormat("dd/MM/yyyy").format(dataCancelamento);	
	}

 	public Date getDataCancelamentoDate() {	
		return dataCancelamento;	
	}	

 	public FaturaMatriculaModel setDataCancelamento(Date data_cancelamento) {	
		this.dataCancelamento = data_cancelamento;	
		return this;
 	}
 	
 	public String getSituacao() {
 		return situacao;
 	}
 	
 	public FaturaMatriculaModel setSituacao(String situacao) {
 		this.situacao = situacao;
 		return this;
 	}
 	

 }