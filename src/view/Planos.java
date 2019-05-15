package view;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dao.ModalidadeDAO;
import dao.PlanoDAO;
import model.ModalidadeModel;
import model.PlanoModel;

@SuppressWarnings("serial")
public class Planos extends MasterDialogCad {

	private JLabel Modalidade, Plano, Valor;
	private JTextField JTPlano,JTValor;
	private JComboBox<String> ComboModalidade;
	private PlanoModel plano, planoChange;
	private PlanoDAO planoDao;

	private BuscarPlano busca;

	public Planos() {

		planoDao = new PlanoDAO();

		setSize(690, 180);
		setTitle("Planos");
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
		fillModalidades();		
		setVisible(true);

	}
	
	public void setPosicao() {
		
		Dimension d = this.getDesktopPane().getSize();
	    this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
	}
	
	protected void actionSearch() {
		busca = new BuscarPlano();
		busca.addWindowListener(eventWindowSearchClosed);
	}

	protected boolean afterSearch() {
		if(busca.planoReturn!=null) {
			plano = busca.planoReturn;
			return true;
		}else {
			return false;
		}
	}

	protected boolean actionDelete() {
		if((plano!=null) && (!isInserting)) {
			try {
				planoDao.deletePlano(plano);
				return true;
			} catch (SQLException e) {
				return false;
			}						
		}else {
			return false;
		}
	}

	protected boolean actionAdd() {
		if(!isInserting) {
			try {
				plano = new PlanoModel();
				return true;
			} catch (Exception e) {
				return false;
			}			
		}else {
			return false;
		}
	}

	protected boolean actionCancel() {
		try {		
			if(isInserting) {
				plano = null;
			}
			planoChange = null;	
			return true;	
		}catch (Exception e) {
		}				
		return false;			
	}

	protected boolean actionSave() {
		if(planoChange!=null) {
			try {
				if(isInserting) {
					planoDao.createPlano(planoChange);
				}else {
					planoDao.updatePlano(planoChange, plano);
				}
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}else {
			return false;
		}
	}

	protected void fillFields() {

		JTPlano.setText(plano.getPlano());
		JTValor.setText(Float.toString(plano.getValorMensal()));
		ComboModalidade.setSelectedItem(plano.getModalidade());

		planoChange = new PlanoModel(plano);
	}

	protected void subComponents() {


		ComboModalidade = new JComboBox<String>();
		ComboModalidade.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				if (ComboModalidade.getSelectedIndex()>0) {
					planoChange.setModalidade(ComboModalidade.getSelectedItem().toString());
				}
			}
		});
		ComboModalidade.setBounds(85, 50, 400, 26);
		getContentPane().add(ComboModalidade);

		JTPlano = new JTextField();
		JTPlano.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				if((!e.isTemporary()) && (planoChange != null)) {
					planoChange.setPlano(JTPlano.getText());
				}
			}
		});
		JTPlano.setBounds(85, 80, 585, 26);
		getContentPane().add(JTPlano);

		JTValor = new JTextField();
		JTValor.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				if((!e.isTemporary()) && (planoChange != null)) {
					planoChange.setValorMensal(Float.parseFloat(JTValor.getText()));
				}
			}
		});

		JTValor.setBounds(85, 110, 205, 26);
		getContentPane().add(JTValor);

		//labels
		Modalidade = new JLabel("Modalidade:");
		Modalidade.setBounds(10, 10, 100, 100);
		getContentPane().add(Modalidade);

		Plano = new JLabel("Plano:");
		Plano.setBounds(10, 40, 100, 100);
		getContentPane().add(Plano);

		Valor = new JLabel("Valor:");
		Valor.setBounds(10, 70, 100, 100);
		getContentPane().add(Valor);

		childContainer = getContentPane();

	}

	private void fillModalidades() {


		ComboModalidade.addItem("--Selecione--");
		ArrayList<ModalidadeModel> list;
		try {
			list = new ModalidadeDAO().getAllModalidades();
			for(ModalidadeModel modalidade : list) {
				ComboModalidade.addItem(modalidade.getModalidade());
			}
		} catch (SQLException e) {
		}

	}

}
