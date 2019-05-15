package view;
import java.awt.Dimension;

import javax.swing.JInternalFrame;

public class Ajuda extends JInternalFrame {
	

	public Ajuda() {

		setSize(690, 538);
		setTitle("Ajuda");
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

	}

	public void setPosicao() {
		
		Dimension d = this.getDesktopPane().getSize();
	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
	}
	
}
