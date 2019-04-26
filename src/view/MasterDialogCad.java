package view;

import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
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
	protected JButton btnCancel;
	protected Container childContainer;
	protected Utils utils;
	
	protected boolean isInserting;
	protected AbstractAction actDel = new AbstractAction() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (actionDelete()) {
				isInserting = false;
				setFieldsEnabled(false);
			}
		}
	};
	
	protected AbstractAction actAdd = new AbstractAction() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(actionAdd()) {
				isInserting = true;
				setFieldsEnabled(true);
			}
		}
	};

	public static void main(String Args[]) {
		new MasterDialogCad();
	}

	public MasterDialogCad() {

		utils = new Utils();
		Componnents();
		subComponnents();
		setFieldsEnabled(false);

	}

	protected void subComponnents() {

	}

	protected void setFieldsEnabled(boolean enabled) {

	}

	protected boolean actionDelete() {
		return false;
	}
	
	protected boolean actionAdd() {
		return true;
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
		btnAdd.addActionListener(new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setFieldsEnabled(true);				
			}
		});
		btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdd.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAdd.setBounds(130, 10, 120, 35);
		getContentPane().add(btnAdd);

		// Botao Delete
		btnDelete = new JButton("Remover", new ImageIcon(System.getProperty("user.dir") + "\\images\\22x22\\remover.png"));
		btnDelete.addActionListener(actDel);
		btnDelete.setHorizontalAlignment(SwingConstants.LEFT);
		btnDelete.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnDelete.setBounds(250, 10, 120, 35);
		getContentPane().add(btnDelete);

		// Botao Save
		btnSave = new JButton("Salvar", new ImageIcon(System.getProperty("user.dir") + "\\images\\22x22\\salvar.png"));
		btnSave.setHorizontalAlignment(SwingConstants.LEFT);
		btnSave.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSave.setBounds(370, 10, 120, 35);
		getContentPane().add(btnSave);

		// Botao Cancel
		btnCancel = new JButton("Cancelar", new ImageIcon(System.getProperty("user.dir") + "\\images\\22x22\\cancelar.png"));
		btnCancel.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancel.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCancel.setBounds(490, 10, 120, 35);
		getContentPane().add(btnCancel);


	}

}