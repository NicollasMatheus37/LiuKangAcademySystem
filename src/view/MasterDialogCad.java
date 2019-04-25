package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;

public class MasterDialogCad extends JInternalFrame {

	// Botoes
	protected JButton btnAdd;
	protected JButton btnSearch;	
	protected JButton btnDelete;
	protected JButton btnSave;

	public static void main(String Args[]) {
		new MasterDialogCad();
	}

	public MasterDialogCad() {
		
		/*
		 * setSize(500, 350); setLayout(null);
		 * setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
		 * setResizable(false);
		 */
		
		Componnents();
	
	}

	public void Componnents() {


		//Botao Search
		btnSearch = new JButton("Buscar", new ImageIcon(System.getProperty("user.dir") + "\\images\\22x22\\localizar.png"));
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearch.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSearch.setBounds(10, 10, 120, 35);
		getContentPane().add(btnSearch);	


		// Botao Add
		btnAdd = new JButton("Adicionar", new ImageIcon(System.getProperty("user.dir") + "\\images\\22x22\\adicionar.png"));
		btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdd.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAdd.setBounds(130, 10, 120, 35);
		getContentPane().add(btnAdd);
		
		// Botao Delete
		btnDelete = new JButton("Remover", new ImageIcon(System.getProperty("user.dir") + "\\images\\22x22\\remover.png"));
		btnDelete.setHorizontalAlignment(SwingConstants.LEFT);
		btnDelete.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnDelete.setBounds(250, 10, 120, 35);
		getContentPane().add(btnDelete);
		
		// Botao Add
		btnSave = new JButton("Salvar", new ImageIcon(System.getProperty("user.dir") + "\\images\\22x22\\salvar.png"));
		btnSave.setHorizontalAlignment(SwingConstants.LEFT);
		btnSave.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSave.setBounds(370, 10, 120, 35);
		getContentPane().add(btnSave);
		

	}

}