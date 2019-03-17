package model;

import java.util.Date;

public class MatriculaModalidadeModel {
	
	private int codigo_matricula;	
	private String modalidade;
	private String graduacao;
	private String plano;
	private Date data_inicio;
	private Date data_fim;
	
	
	public int getcodigo_matricula() {
		return codigo_matricula;
	}
	
	public void setCodigo_matricula(int codigo_matricula) {
		codigo_matricula = this.codigo_matricula;		
	}
	
	public String getModalidade() {
		return modalidade;
	}
	
	public void setModalidade(String modalidade) {
		modalidade = this.modalidade;		
	}
	
	public String getGraduacao() {
		return modalidade;
	}
	
	public void setGraduacao(String graduacao) {
		graduacao = this.graduacao;		
	}
	
	public String getPlano() {
		return plano;
	}
	
	public void setPlano(String plano) {
		plano = this.plano;		
	}
		
	public Date getData_matricula() {
		return data_inicio;
	}
	
	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}
	
	public Date getData_fim() {
		return data_fim;
	}
	
	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}
	

	
}
















