package view;

import java.awt.Component;
import java.awt.Container;

public class Utils {
	
	
	//Pega um container passado pela função getContentPane, traz todos componentes abaixo dele,
	//e desabilita os que estao contidos em alvo e não sa nulos
	public void setFieldsEnabled(Container contents, Boolean enabled) {
				
		for(Component field : contents.getComponents()) {		
			
			if (field!=null && isTarget(field.getClass().getName())) {	
				field.setEnabled(enabled);
			}
			
		}			
		
	}
	
	
	// Verifica se classe esta cadastrada como um alvo para ser desabilitada
	private Boolean isTarget(String componentClass) {
		
		// Insira as classes dos componentes para serem desabilitados
		String targets[] = {
							"javax.swing.JTextField",
							"javax.swing.JComboBox"							
							};
		
		for(String target : targets ) {
			if(target.equals(componentClass)) {
				return true;
			}
		}
		
		return false;
		
	}

}
