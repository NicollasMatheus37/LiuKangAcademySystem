package view;
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
import model.UsuarioModel;

@SuppressWarnings("serial")
public class Planos extends MasterDialogCad {

	private JLabel Modalidade, Plano, Valor;
	private JTextField JTPlano,JTValor;
	private JComboBox<String> ComboModalidade;
	private ModalidadeModel modalidade;
	private ModalidadeDAO modalidadeDao;
	private PlanoModel plano, planoChange;
	private PlanoDAO planoDao;
	
	public Planos() {
		
		planoDao = new PlanoDAO();

		setSize(690, 180);
		setTitle("Planos");
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}
		
	protected boolean actionDelete() {
		if((plano!=null) && (!isInserting)) {
			try {
				planoDao.deletePlano(planoChange.getPlano());
				return true;
			} catch (SQLException e) {
				return false;
			}						
		}else {
			return false;
		}
	}
	
	private void addModalidades() throws SQLException {
		if(!modalidadeDao.getAllModalidades().isEmpty()) {
		ArrayList<ModalidadeModel> arrayModel = modalidadeDao.getAllModalidades();
		for(int i = 0; i < modalidadeDao.getAllModalidades().size() ; i++){
			ComboModalidade.addItem(arrayModel.toString());
			ComboModalidade.addItem("lixo" + i);
			}}
		else
			ComboModalidade.addItem("Adicionar Modalidades");
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
			plano = null;
			planoChange = null;			
		}catch (Exception e) {
		}				
		return true;		
	}
	
	protected boolean actionSave() {
		if(planoChange!=null) {
			try {
				if(isInserting) {
					planoDao.createPlano(planoChange);
				}else {
					planoDao.updatePlano(planoChange);
				}
				return true;
			}catch (Exception e) {
				return false;
			}
		}else {
			return false;
		}
	}
	
	protected void fillFields() {

		JTPlano.setText((plano.getPlano()));
		JTValor.setText(Integer.toString((int) (plano.getValorMensal())));
		ComboModalidade.setSelectedItem(modalidade.getModalidade());
		
		planoChange = plano;
	}
	
	protected void subComponents() {
		
		
		ComboModalidade = new JComboBox<String>();
		ComboModalidade.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				if (ComboModalidade.getSelectedIndex()>0) {
					planoChange.setPlano(ComboModalidade.getSelectedItem().toString());
				}
			}
		});
		try {
			addModalidades();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
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

}
