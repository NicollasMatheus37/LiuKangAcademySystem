package view;

import java.awt.Component;
import java.awt.Container;
import java.text.Collator;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class Utils {

	//Descontinuado - Foi melhorado para usar os objetos Class
	// Insira as classes dos componentes para serem desabilitados
	/*
	private String targets[] = {
			"javax.swing.JTextField",
			"javax.swing.JComboBox",
			"javax.swing.JFormattedTextField",
			"javax.swing.JTextArea"
	};
	*/
	
	// Insira as classes dos componentes para serem desabilitados
	// Note que para Classes como a JComboBox, deve ser implementado uma forma
	// especifica para limpar o componente na função cleanFields(), ja os componentes
	// que extendem JTextComponent como JtextArea e JTextField não é necessario implementar.
	private Class<?> targetClasses[] = {
		JTextField.class,
		JFormattedTextField.class,
		JComboBox.class,
		JTextArea.class
	};


	public void cleanFields(Container contents) {
		for(Component field : contents.getComponents()) {		

			if (field!=null) {
				if (isInstanceOfSomeTarget(field)) {
					if (field.getClass().equals(JComboBox.class)) {
						((JComboBox<?>) field).setSelectedIndex(0);;	
					}else {
						((JTextComponent) field).setText("");
					}
				}
			}

		}	
	}

	private boolean isInstanceOfSomeTarget(Component component) {
		
		for(Class<?> target : targetClasses) {
			if(target.isInstance(component)) {			
				return true;
			}
		}
		return false;
	}



	//Pega um container passado pela função getContentPane, traz todos componentes abaixo dele,
	//e desabilita os que estao contidos em alvo e não sa nulos
	public void setFieldsEnabled(Container contents, Boolean enabled) {

		for(Component field : contents.getComponents()) {		

			if (field!=null && isInstanceOfSomeTarget(field)/*Target(field.getClass().getName())*/) {	
				field.setEnabled(enabled);
			}

		}			

	}

	// Descontinuado - Use isInstanceOfSomeTarget(Component component) 
	// Verifica se classe esta cadastrada como um alvo para ser desabilitada
	/*private Boolean isTarget(String componentClass) {

		for(String target : targets ) {
			if(target.equals(componentClass)) {
				return true;
			}
		}

		return false;

	}*/

	public boolean compareStrings(String strA, String StrB) {

		Collator col = Collator.getInstance(new Locale("pt", "BR"));

		return col.compare(strA, StrB) == 0;

	}

}
