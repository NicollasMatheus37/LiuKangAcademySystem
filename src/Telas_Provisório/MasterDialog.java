package Telas_Provisório;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;

public class MasterDialog extends JFrame {
	
	// Botoes
	private JButton btnAdd;
	private JButton btnSearch;	
	private JButton btnDelete;
	private JButton btnSave;
	// icones
	private Icon icAdd;
	private Icon icSearch;
	private Icon icDelete;
	private Icon icSave;
	
	public static void main(String Args[]) {
		new MasterDialog();
	}
	
	public MasterDialog() {
		setSize(500, 350);
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createComponnents();
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public void createComponnents() {
		

		//Botao btnSearch
		btnSearch = new JButton("Buscar", new ImageIcon(System.getProperty("user.dir")+"\\images\\22x22\\localizar.png"));
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearch.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSearch.setMargin(new Insets(0, 0, 0, 0));
		btnSearch.setBounds(30,10,90,35);
		getContentPane().add(btnSearch);
		
		//Botao Add
		btnAdd = new JButton("Adicionar", new ImageIcon(System.getProperty("user.dir")+"\\images\\22x22\\adicionar.png"));
		btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdd.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAdd.setMargin(new Insets(0, 0, 0, 0));
		btnAdd.setBounds(124,10,90,35);
		getContentPane().add(btnAdd);
		
		
		
		//Botao Add
		btnDelete = new JButton("Remover", new ImageIcon(System.getProperty("user.dir")+"\\images\\22x22\\remover.png"));
		btnDelete.setHorizontalAlignment(SwingConstants.LEFT);
		btnDelete.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnDelete.setMargin(new Insets(0, 0, 0, 0));
		btnDelete.setBounds(218,10,90,35);
		getContentPane().add(btnDelete);
		
		//Botao Add
		btnSave = new JButton("Salvar", new ImageIcon(System.getProperty("user.dir")+"\\images\\22x22\\salvar.png"));
		btnSave.setHorizontalAlignment(SwingConstants.LEFT);
		btnSave.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSave.setMargin(new Insets(0, 0, 0, 0));
		btnSave.setBounds(312,10,90,35);
		getContentPane().add(btnSave);
	
	}
	
}
