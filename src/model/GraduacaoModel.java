package model;

public class GraduacaoModel {	

 	private String modalidade;	
	private String graduacao; 	


	public GraduacaoModel() {
		clean();
	}
	
	public GraduacaoModel(GraduacaoModel graduacaoModel) {
		
		modalidade = graduacaoModel.getModalidade();
		graduacao = graduacaoModel.getGraduacao();
		
	}
	
	public void clean() {
		modalidade = "";
		graduacao = "";
	}
	
 	public String getModalidade() {	
		return modalidade;	
	}	

 	public GraduacaoModel setModalidade(String modalidade) {	
		this.modalidade = modalidade;	
		return this;
	}	

 	public String getGraduacao() {	
		return graduacao;	
	}	

 	public GraduacaoModel setGraduacao(String graduacao) {	
		this.graduacao = graduacao;	
		return this;
	}	


 }