package view;

import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.text.MaskFormatter;

import dao.GraduacaoDAO;
import dao.ModalidadeDAO;
import dao.PlanoDAO;
import model.GraduacaoModel;
import model.MatriculaModalidadeModel;
import model.ModalidadeModel;
import model.PlanoModel;

@SuppressWarnings("serial")
public class AdicionarModalidades extends JDialog {

	private JButton btnSalvar;
	private JLabel JLModalidade, JLGrad, JLPlano, JLDataIni, JLDataFim;
	private JFormattedTextField JTextIni, JTextFim;
	private JComboBox<String> JComboMod, JComboGrad, JComboPlano;
	private boolean isFilling;

	private MatriculaModalidadeModel matModalidadeChange;
	public MatriculaModalidadeModel matModalidadeReturn;

	public AdicionarModalidades() {

		setSize(300, 290);
		setTitle("Adicionar Modalidades");
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createComponents() ;
		fillModalidades();
		matModalidadeChange = new MatriculaModalidadeModel();
		setVisible(true);

	}

	public void createComponents() {

		JComboMod = new JComboBox<String>();
		JComboMod.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				matModalidadeChange.setModalidade(JComboMod.getSelectedItem().toString());
			}
			
		});
		JComboMod.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {

				if(!isFilling) {
					JComboGrad.removeAllItems();
					JComboGrad.addItem("--Selecione--");

					ArrayList<GraduacaoModel> listG;
					try {
						listG = new GraduacaoDAO().getAllGraduacoes(JComboMod.getSelectedItem().toString());
						if(listG!=null) {
							for(GraduacaoModel graduacao : listG) {
								JComboGrad.addItem(graduacao.getGraduacao());
							}
						}
					} catch (SQLException e1) {
					}


					JComboPlano.removeAllItems();;
					JComboPlano.addItem("--Selecione--");

					ArrayList<PlanoModel> listP;
					try {
						listP = new PlanoDAO().getAllPlanos(JComboMod.getSelectedItem().toString());
						if(listP!=null) {
							for(PlanoModel plano : listP) {
								JComboPlano.addItem(plano.getPlano());
							}
						}
					} catch (SQLException e1) {
					}
				}

			}

		});
		JComboMod.setBounds(90, 50, 200, 26);
		getContentPane().add(JComboMod);

		JComboGrad = new JComboBox<>();
		JComboGrad.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				matModalidadeChange.setGraduacao(JComboGrad.getSelectedItem().toString());
			}
			
		});
		JComboGrad.setBounds(90, 80, 200, 26);
		getContentPane().add(JComboGrad);

		JComboPlano = new JComboBox<>();
		JComboPlano.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				matModalidadeChange.setPlano(JComboPlano.getSelectedItem().toString());
			}
			
		});
		JComboPlano.setBounds(90, 110, 200, 26);
		getContentPane().add(JComboPlano);

		try {
			JTextIni = new JFormattedTextField(new MaskFormatter("##/##/####"));
			JTextIni.addFocusListener(new FocusAdapter() {
				
				public void focusLost(FocusEvent e) {
					try {
						matModalidadeChange.setData_inicio(new SimpleDateFormat("dd/MM/yyyy").parse(JTextIni.getText()));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			});
			JTextIni.setBounds(90,140,200,26);
			getContentPane().add(JTextIni);

			JTextFim = new JFormattedTextField(new MaskFormatter("##/##/####"));
			JTextFim.addFocusListener(new FocusAdapter() {
				
				public void focusLost(FocusEvent e) {
					try {
						matModalidadeChange.setData_Fim(new SimpleDateFormat("dd/MM/yyyy").parse(JTextFim.getText()));
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			});
			JTextFim.setBounds(90,170,200,26);
			getContentPane().add(JTextFim);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new AbstractAction() {
			
			public void actionPerformed(ActionEvent e) {
				matModalidadeReturn = matModalidadeChange;
				dispose();
			}
		});
		btnSalvar.setBounds(210, 200, 80, 26);
		getContentPane().add(btnSalvar);
		
		
		//-------------------------------------
		
		
		JLModalidade = new JLabel("Modalidades:");
		JLModalidade.setBounds(10,50,100, 20);
		getContentPane().add(JLModalidade);

		JLGrad = new JLabel("Graduação:");
		JLGrad.setBounds(10,80,100, 20);
		getContentPane().add(JLGrad);

		JLPlano = new JLabel("Plano:");
		JLPlano.setBounds(10,110,100, 20);
		getContentPane().add(JLPlano);

		JLDataIni = new JLabel("Data Início:");
		JLDataIni.setBounds(10,140,100, 20);
		getContentPane().add(JLDataIni);

		JLDataFim = new JLabel("Data Fim:");
		JLDataFim.setBounds(10,170,100, 20);
		getContentPane().add(JLDataFim);


	}

	private void fillModalidades() {
		try {
			isFilling = true;

			JComboGrad.removeAllItems();
			JComboGrad.addItem("--Selecione--");

			JComboPlano.removeAllItems();
			JComboPlano.addItem("--Selecione--");

			JComboMod.addItem("--Selecione--");
			ArrayList<ModalidadeModel> list;
			try {
				list = new ModalidadeDAO().getAllModalidades();
				for(ModalidadeModel modalidade : list) {
					JComboMod.addItem(modalidade.getModalidade());
				}
			} catch (SQLException e) {
			}
		}finally {
			isFilling = false;
		}

	}

}
