package view;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.MaskFormatter;

import dao.AlunoDAO;
import dao.CidadeDAO;
import model.AlunoModel;

@SuppressWarnings("serial")
public class CadastroAlunos extends MasterDialogCad {

	private JLabel Aluno, DataNasc, Tel, Email, Obs, Endereco, Complemento, Bairro, Estado, CEP, Numero, Cidade, Pais,
	Sexo, Celular;
	private JTextField JTAluno, JTTel, JTEmail, JTEndereco, JTComplemento, JTBairro, JTCEP,
	JTNumero,  JTCel;
	JFormattedTextField JTDataNasc;
	private JTextArea JTObs;
	private JComboBox<String> ComboSexo, ComboCidade, ComboEstado, ComboPais;
	private CidadeDAO cidadeDAO;
	private AlunoDAO alunoDao;
	private AlunoModel aluno, alunoChange;
	private BuscarAluno busca;
	private boolean isFillingCombos;



	public CadastroAlunos() throws ParseException {

		alunoDao = new AlunoDAO();
		cidadeDAO = new CidadeDAO();

		setSize(690, 538);
		setTitle("Cadastro de Alunos");
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);		
		setVisible(true);
		try {
			isFillingCombos = true;
			fillPais();
		} catch (SQLException e) {
		}finally {
			isFillingCombos = false;
		}

	}

	protected boolean actionDelete() {
		if((aluno!=null) && (!isInserting)) {
			try {
				alunoDao.deleteAluno(aluno.getcodigoAluno());
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
				aluno = new AlunoModel();
				return true;
			} catch (Exception e) {
				return false;
			}			
		}else {
			return false;
		}
	}

	protected void actionSearch() {
		busca = new BuscarAluno();
		try {						
			busca.addWindowListener(eventWindowSearchClosed);				
		} catch (Exception e2) {
			busca = null;
		}
	}

	protected boolean afterSearch() {
		if(busca.alunoReturn!=null) {
			aluno = busca.alunoReturn;
			return true;
		}
		return false;
	}

	protected boolean actionSave() {
		if(alunoChange!=null) {
			try {
				if(isInserting) {
					alunoDao.createAluno(alunoChange);
				}else {
					alunoDao.updateAluno(alunoChange);
				}
			} catch (SQLException e) {
				return false;
			}

			return true;
		}else {
			return false;
		}
	}

	protected boolean actionCancel() {
		try {		
			if(isInserting) {
				aluno = null;
			}
			alunoChange = null;			
		}catch (Exception e) {
			return false;
		}				
		return true;		
	}

	protected void fillFields() {

		JTAluno.setText(aluno.getAluno());
		JTDataNasc.setText(aluno.getDataNascimento());
		JTTel.setText(aluno.getTelefone());
		JTEmail.setText(aluno.getEmail());
		JTEndereco.setText(aluno.getEndereco());
		JTComplemento.setText(aluno.getComplemento());
		JTBairro.setText(aluno.getBairro());		
		JTCEP.setText(aluno.getCep());
		JTNumero.setText(aluno.getNumero());		
		ComboPais.setSelectedItem(aluno.getPais());
		ComboEstado.setSelectedItem(aluno.getEstado());
		ComboCidade.setSelectedItem(aluno.getCidade());
		JTCel.setText(aluno.getCelular());
		JTObs.setText(aluno.getObservacao());
		JTCel.setText(aluno.getCelular());	
		ComboSexo.setSelectedIndex((aluno.getSexo() == 'M') ? 1 : 2);

		alunoChange = aluno;

	}

	protected void subComponents() {

		JTAluno = new JTextField();
		JTAluno.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				if((!e.isTemporary()) && (alunoChange!=null)) {
					alunoChange.setAluno(JTAluno.getText());
				}
			}

		});
		JTAluno.setBounds(135, 50, 250, 26);
		getContentPane().add(JTAluno);

		try {
			JTDataNasc = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e2) {
		}
		JTDataNasc.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				try {
					if(!JTDataNasc.hasFocus()) {
						alunoChange.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse(JTDataNasc.getText()));
						//JOptionPane.showMessageDialog(null,"Saiu");
					}
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}

		});
		JTDataNasc.setBounds(135, 80, 250, 26);
		getContentPane().add(JTDataNasc);

		JTTel = new JTextField();
		JTTel.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				if(!e.isTemporary()) {
					alunoChange.setTelefone(JTTel.getText());
				}
			}

		});
		JTTel.setBounds(135, 110, 250, 26);
		getContentPane().add(JTTel);

		JTEmail = new JTextField();
		JTEmail.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				if(!e.isTemporary()) {
					alunoChange.setEmail(JTEmail.getText());
				}
			}

		});
		JTEmail.setBounds(135, 140, 250, 26);
		getContentPane().add(JTEmail);

		JTEndereco = new JTextField();
		JTEndereco.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				if(!e.isTemporary()) {
					alunoChange.setEndereco(JTEndereco.getText());
				}
			}

		});
		JTEndereco.setBounds(100, 315, 250, 26);
		getContentPane().add(JTEndereco);

		JTComplemento = new JTextField();
		JTComplemento.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				if(!e.isTemporary()) {
					alunoChange.setComplemento(JTComplemento.getText());
				}
			}

		});
		JTComplemento.setBounds(100, 345, 570, 26);
		getContentPane().add(JTComplemento);

		JTBairro = new JTextField();
		JTBairro.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				if(!e.isTemporary()) {
					alunoChange.setBairro(JTBairro.getText());
				}
			}

		});
		JTBairro.setBounds(100, 375, 250, 26);
		getContentPane().add(JTBairro);		

		JTCEP = new JTextField();
		JTCEP.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				if(!e.isTemporary()) {
					alunoChange.setCep(JTCEP.getText());
				}
			}

		});
		JTCEP.setBounds(100, 435, 250, 26);
		getContentPane().add(JTCEP);

		JTNumero = new JTextField();
		JTNumero.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				if(!e.isTemporary()) {
					alunoChange.setNumero(JTNumero.getText());
				}
			}

		});
		JTNumero.setBounds(420, 315, 250, 26);
		getContentPane().add(JTNumero);



		JTCel = new JTextField();
		JTCel.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				if(!e.isTemporary()) {
					alunoChange.setCelular(JTCel.getText());
				}
			}

		});
		JTCel.setBounds(435, 110, 235, 26);
		getContentPane().add(JTCel);

		JTObs = new JTextArea();
		JTObs.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				if((!e.isTemporary()) && (alunoChange!=null)) {
					alunoChange.setObservacao(JTObs.getText());
				}
			}

		});
		getContentPane().add(JTObs);
		JTObs.setLineWrap(true);

		JScrollPane sp = new JScrollPane(JTObs);
		sp.setBounds(10, 210, 657, 70);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.getContentPane().add(sp);

		ComboSexo = new JComboBox<String>();
		ComboSexo.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				if(ComboSexo.getSelectedIndex()>0) {
					alunoChange.setSexo((ComboSexo.getSelectedIndex() == 1) ? 'M' : 'F');
				}else {
					alunoChange.setSexo(' ');
				}
			}

		});
		ComboSexo.addItem("--Selecione--");
		ComboSexo.addItem("Masculino");
		ComboSexo.addItem("Feminino");
		ComboSexo.setBounds(435, 80, 235, 26);
		getContentPane().add(ComboSexo);

		//labels

		Aluno = new JLabel("Aluno:");		
		Aluno.setBounds(10, 10, 100, 100);
		getContentPane().add(Aluno);

		DataNasc = new JLabel("Data de Nascimento:");		
		DataNasc.setBounds(10, 40, 150, 100);
		getContentPane().add(DataNasc);

		Tel = new JLabel("Telefone:");
		Tel.setBounds(10, 70, 200, 100);
		getContentPane().add(Tel);

		Email = new JLabel("Email:");
		Email.setBounds(10, 100, 110, 100);
		getContentPane().add(Email);

		Endereco = new JLabel("Endereço:");
		Endereco.setBounds(10, 280, 100, 100);
		getContentPane().add(Endereco);

		Complemento = new JLabel("Complemento:");
		Complemento.setBounds(10, 310, 150, 100);
		getContentPane().add(Complemento);

		Bairro = new JLabel("Bairro:");
		Bairro.setBounds(10, 340, 200, 100);
		getContentPane().add(Bairro);

		Estado = new JLabel("Estado:");
		Estado.setBounds(10, 370, 110, 100);
		getContentPane().add(Estado);

		CEP = new JLabel("CEP:");
		CEP.setBounds(10, 400, 100, 100);
		getContentPane().add(CEP);

		Numero = new JLabel("Numero:");
		Numero.setBounds(370, 280, 150, 100);
		getContentPane().add(Numero);

		Cidade = new JLabel("Cidade:");
		Cidade.setBounds(375, 340, 200, 100);
		getContentPane().add(Cidade);

		Pais = new JLabel("País:");
		Pais.setBounds(390, 370, 110, 100);
		getContentPane().add(Pais);

		Sexo = new JLabel("Sexo:");
		Sexo.setBounds(400, 40, 150, 100);
		getContentPane().add(Sexo);

		Celular = new JLabel("Celular:");
		Celular.setBounds(390, 70, 200, 100);
		getContentPane().add(Celular);

		Obs = new JLabel("Observações:");
		Obs.setBounds(10, 130, 110, 100);
		getContentPane().add(Obs);

		ComboPais = new JComboBox<>();
		ComboPais.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				if(!e.isTemporary()) {
					alunoChange.setPais(ComboPais.getItemAt(ComboPais.getSelectedIndex()));
				}
			}

		});
		ComboPais.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(!isFillingCombos) {
					try {
						isFillingCombos = true;
						fillEstado();						
					} catch (SQLException e1) {
						e1.printStackTrace();
					} finally {
						isFillingCombos = false;
					}
				}
			}
		});
		ComboPais.setBounds(420, 405, 250, 26);
		getContentPane().add(ComboPais);

		ComboEstado = new JComboBox<>();
		ComboEstado.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				if(!e.isTemporary()) {
					alunoChange.setEstado(ComboEstado.getItemAt(ComboEstado.getSelectedIndex()));
				}
			}

		});
		ComboEstado.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(!isFillingCombos) {
					try {
						isFillingCombos = true;
						fillCidade();

					} catch (SQLException e1) {
						e1.printStackTrace();
					} finally {
						isFillingCombos = false;
					}
				}
			}
		});
		ComboEstado.setBounds(100, 405, 250, 26);
		getContentPane().add(ComboEstado);

		ComboCidade = new JComboBox<>();
		ComboCidade.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				if(!e.isTemporary()) {
					alunoChange.setCidade(ComboCidade.getItemAt(ComboCidade.getSelectedIndex()));
				}
			}

		});		
		ComboCidade.setBounds(420, 375, 250, 26);
		getContentPane().add(ComboCidade);

		childContainer = getContentPane();

	}

	private void fillPais() throws SQLException {

		ArrayList<String> list = cidadeDAO.getPaises();		

		ComboCidade.removeAllItems();
		ComboCidade.addItem("-Selecione-");

		ComboEstado.removeAllItems();
		ComboEstado.addItem("-Selecione-");

		ComboPais.removeAllItems();
		ComboPais.addItem("-Selecione-");
		for(int i = 0; i < list.size(); i++) {
			ComboPais.addItem(list.get(i));		
		}

	}

	private void fillEstado() throws SQLException {
		ArrayList<String> list = cidadeDAO.getEstados(ComboPais.getItemAt(ComboPais.getSelectedIndex()));

		ComboCidade.removeAllItems();
		ComboCidade.addItem("-Selecione-");

		ComboEstado.removeAllItems();
		ComboEstado.addItem("-Selecione-");
		for(int i = 0; i < list.size(); i++) {
			ComboEstado.addItem(list.get(i));		
		}
	}

	private void fillCidade() throws SQLException {
		ArrayList<String> list = cidadeDAO.getCidades(ComboPais.getItemAt(ComboPais.getSelectedIndex()), ComboEstado.getItemAt(ComboEstado.getSelectedIndex()));

		ComboCidade.removeAllItems();
		ComboCidade.addItem("-Selecione-");
		for(int i = 0; i < list.size(); i++) {
			ComboCidade.addItem(list.get(i));		
		}
	}

}
