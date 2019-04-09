package model;

import java.util.Map;

public class GraduacaoModel {	

 	private String modalidade;	
	private Map<Integer, String> graduacao; 	


 	public Map getModalidade() {	
		return graduacao;	
	}	

 	public GraduacaoModel setModalidade(Map graduacao) {	
		this.graduacao = graduacao;	
		return this;
	}	

 	public String getGraduacao() {	
		return modalidade;	
	}	

 	public GraduacaoModel setGraduacao(String modalidade) {	
		this.modalidade = modalidade;	
		return this;
	}	


 }