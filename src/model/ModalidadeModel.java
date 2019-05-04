
package model;	

 public class ModalidadeModel {	

 	private String modalidade;	


 	public ModalidadeModel() {
 		clean();
 	}
 	
 	public void clean() {
 		modalidade = "";
 	}

 	public String getModalidade() {	
		return modalidade;	
	}	

 	public ModalidadeModel setModalidade(String modalidade) {	
		this.modalidade = modalidade;	
		return this;
	}	

}