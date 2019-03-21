import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.naming.directory.DirContext;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Usuarios extends JInternalFrame {

	
	

	public Usuarios() {
		
		setSize(690, 538);
		setTitle("Usuários");
		setLayout(null);
		setResizable(false);
		setClosable(true);
		// this.setBorder(javax.swing.BorderFactory.createLineBorder(Color.DARK_GRAY));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		

		setVisible(true);
	}

}