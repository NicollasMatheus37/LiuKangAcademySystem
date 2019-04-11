package view;

import java.awt.Component;
import java.awt.Container;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.Collator;
import java.util.Locale;

import javax.print.attribute.standard.PDLOverrideSupported;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.*;

public class Utils {

	private BufferedWriter bw = null;
	private File textFile = null;
	private boolean readToSave = false;
	


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
	
	public boolean compareStrings(String strA, String StrB) {
		
		Collator col = Collator.getInstance(new Locale("pt", "BR"));
		
		return col.compare(strA, StrB) == 0;
		
	}
	
}
