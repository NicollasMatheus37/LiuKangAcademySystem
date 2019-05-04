package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
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
				setFieldsEnabled(false);
				clean();
			}
		}
	};
	
	protected AbstractAction actAdd = new AbstractAction() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(actionAdd()) {
				isInserting = true;
				clean();
				fillFields();
				setFieldsEnabled(true);				
			}
		}
	};
	
	protected AbstractAction actSearch = new AbstractAction() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			actionSearch();
		}
	};
	
	protected WindowListener eventWindowSearchClosed = new WindowListener() {
		
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub			
			if(afterSearch()) {
				clean();
				fillFields();
				isInserting = false;
				setFieldsEnabled(true);
			}
		}
		
		public void windowOpened(WindowEvent e) {}
		public void windowIconified(WindowEvent e) {}
		public void windowDeiconified(WindowEvent e) {}
		public void windowDeactivated(WindowEvent e) {}
		public void windowActivated(WindowEvent e) {}
		public void windowClosing(WindowEvent e) {}
	};
	
	protected AbstractAction actSave = new AbstractAction() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(actionSave()) {
				if(isInserting) {
					btnCancel.doClick();
					clean();
				}
			}
			
		}
	};
	
	protected AbstractAction actCancel = new AbstractAction() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(actionCancel()) {
				isInserting = false;
				setFieldsEnabled(false);
				clean();
			}
		}
	};

	public static void main(String Args[]) {
		new MasterDialogCad();
	}

	public MasterDialogCad() {

		utils = new Utils();
		Componnents();
		subComponents();
		setFieldsEnabled(false);

	}
	
	protected void setFieldsEnabled(boolean enabled) {
		utils.setSubComponentsEnabled(childContainer, enabled);
	}

	protected void subComponents() {

	}

	protected boolean actionDelete() {
		return false;
	}
	
	protected boolean actionAdd() {
		return true;
	}
	
	protected void actionSearch() {
	}
	
	protected boolean actionSave() {
		return false;
	}
	
	protected boolean actionCancel() {
		return false;
	}
	
	protected boolean afterSearch() {
		return false;		
	}
	
	protected void fillFields() {
		
	}
	
	private void clean() {
		utils.cleanSubComponents(childContainer);
	}

	private void Componnents() {


		//Botao Search
		btnSearch = new JButton("Buscar", new ImageIcon(System.getProperty("user.dir") + "\\images\\22x22\\localizar.png"));
		btnSearch.addActionListener(actSearch);
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearch.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSearch.setBounds(10, 10, 120, 35);
		getContentPane().add(btnSearch);	


		// Botao Add
		btnAdd = new JButton("Adicionar", new ImageIcon(System.getProperty("user.dir") + "\\images\\22x22\\adicionar.png"));
		btnAdd.addActionListener(actAdd);
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
		btnSave.addActionListener(actSave);
		btnSave.setHorizontalAlignment(SwingConstants.LEFT);
		btnSave.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSave.setBounds(370, 10, 120, 35);
		getContentPane().add(btnSave);

		// Botao Cancel
		btnCancel = new JButton("Cancelar", new ImageIcon(System.getProperty("user.dir") + "\\images\\22x22\\cancelar.png"));
		btnCancel.addActionListener(actCancel);		
		btnCancel.setHorizontalAlignment(SwingConstants.LEFT);
		btnCancel.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCancel.setBounds(490, 10, 120, 35);
		getContentPane().add(btnCancel);


	}

}