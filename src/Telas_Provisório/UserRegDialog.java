package Telas_Provisório;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class UserRegDialog extends MasterDialog{
	
	//labels
	private JLabel infoLabel[] = new JLabel[4];
	
	//Text Fields
	private JTextField txtField[] = new JTextField[3];
	
	//Combobox
	private JComboBox<String> combo;
	
	public static void main(String Args[]) {
		
		new UserRegDialog();
		
	}
	
	UserRegDialog(){
		
		//add - labels
		infoLabel[0] = new JLabel("Usuário: ");
		infoLabel[0].setBounds(5, 10, 350, 110);
		getContentPane().add(infoLabel[0]);
		
		infoLabel[1] = new JLabel("Senha: ");
		infoLabel[1].setBounds(5, 10, 350, 170);
		getContentPane().add(infoLabel[1]);
		
		infoLabel[2] = new JLabel("Confirmar Senha: ");
		infoLabel[2].setBounds(5, 10, 350, 233);
		getContentPane().add(infoLabel[2]);

		infoLabel[3] = new JLabel("Perfil: ");
		infoLabel[3].setBounds(5, 10, 350, 300);
		getContentPane().add(infoLabel[3]);
		
		//add - TextFields
		txtField[0] = new JTextField();
		txtField[0].setBounds(120, 55, 290, 20);
		getContentPane().add(txtField[0]);
		
		txtField[1] = new JTextField();
		txtField[1].setBounds(120, 87, 290, 20);
		getContentPane().add(txtField[1]);
		
		txtField[2] = new JTextField();
		txtField[2].setBounds(120, 119, 290, 20);
		getContentPane().add(txtField[2]);
		
		//add - Combobox
		combo = new JComboBox<>();
		combo.setBounds(120,151,290,20);
		getContentPane().add(combo);
		combo.addItem("Cadastral");
		combo.addItem("Matricular");
		combo.addItem("Financeiro");
		combo.addItem("Completo");
		
		
		setTitle("Registro de Usuário");
		setVisible(true);
		setSize(440,230);
	}
}

