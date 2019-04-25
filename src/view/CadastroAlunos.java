package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import dao.AlunoDAO;
import model.AlunoModel;

public class CadastroAlunos extends MasterDialogCad {

	private JLabel Aluno, DataNasc, Tel, Email, Obs, Endereco, Complemento, Bairro, Estado, CEP, Numero, Cidade, Pais,
	Sexo, Celular;
	private JTextField JTAluno, JTDataNasc, JTTel, JTEmail, JTEndereco, JTComplemento, JTBairro, JTEstado, JTCEP,
	JTNumero, JTCidade, JTPais, JTCel;
	private JTextArea JTObs;
	private JComboBox<String> ComboSexo;
	private AlunoDAO alunoDao;
	private AlunoModel aluno, alunoChange;
	

	public CadastroAlunos() throws ParseException {

		setSize(690, 538);
		setTitle("Cadastro de Alunos");
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createComponnents();
		setVisible(true);
		
	}
	
	private void fillFields() {
		
		JTAluno.setText(aluno.getAluno());
		JTDataNasc.setText(new SimpleDateFormat("dd-mm-yyyy").format(aluno.getDataNascimento()));
		JTTel.setText(aluno.getTelefone());
		JTEmail.setText(aluno.getEmail());
		JTEndereco.setText(aluno.getEndereco());
		JTComplemento.setText(aluno.getComplemento());
		JTBairro.setText(aluno.getBairro());
		JTEstado.setText(aluno.getEstado());
		JTCEP.setText(aluno.getCep());
		JTNumero.setText(aluno.getNumero());
		JTCidade.setText(aluno.getCidade());
		JTPais.setText(aluno.getPais());
		JTCel.setText(aluno.getCelular());
		JTObs.setText(aluno.getObservacao());
		JTCel.setText(aluno.getCelular());	
		ComboSexo.setSelectedIndex((aluno.getSexo() == 'M') ? 1 : 2);
		
		alunoChange = aluno;
		
	}

	private void createComponnents() {

		// Botao btnSearch
		
		btnSearch.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				BuscarAluno busca = new BuscarAluno();
				aluno = busca.alunoReturn;
				fillFields();

			}
		});
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearch.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSearch.setBounds(10, 10, 120, 35);
		getContentPane().add(btnSearch);		
		
		JTAluno = new JTextField();
		JTAluno.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				alunoChange.setAluno(JTAluno.getText());
			}
			
		});
		JTAluno.setBounds(135, 50, 250, 26);
		getContentPane().add(JTAluno);

		JTDataNasc = new JTextField();
		JTDataNasc.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				try {
					alunoChange.setDataNascimento(new SimpleDateFormat("dd-mm-yyyy").parse(JTDataNasc.getText()));
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
				alunoChange.setTelefone(JTTel.getText());
			}
			
		});
		JTTel.setBounds(135, 110, 250, 26);
		getContentPane().add(JTTel);

		JTEmail = new JTextField();
		JTEmail.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				alunoChange.setEmail(JTEmail.getText());
			}
			
		});
		JTEmail.setBounds(135, 140, 250, 26);
		getContentPane().add(JTEmail);

		JTEndereco = new JTextField();
		JTEndereco.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				alunoChange.setEndereco(JTEndereco.getText());
			}
			
		});
		JTEndereco.setBounds(100, 315, 250, 26);
		getContentPane().add(JTEndereco);

		JTComplemento = new JTextField();
		JTComplemento.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				alunoChange.setComplemento(JTComplemento.getText());
			}
			
		});
		JTComplemento.setBounds(100, 345, 570, 26);
		getContentPane().add(JTComplemento);

		JTBairro = new JTextField();
		JTBairro.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				alunoChange.setBairro(JTBairro.getText());
			}
			
		});
		JTBairro.setBounds(100, 375, 250, 26);
		getContentPane().add(JTBairro);

		JTEstado = new JTextField();
		JTEstado.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				alunoChange.setEstado(JTEstado.getText());
			}
			
		});
		JTEstado.setBounds(100, 405, 250, 26);
		getContentPane().add(JTEstado);

		JTCEP = new JTextField();
		JTCEP.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				alunoChange.setCep(JTCEP.getText());
			}
			
		});
		JTCEP.setBounds(100, 435, 250, 26);
		getContentPane().add(JTCEP);

		JTNumero = new JTextField();
		JTNumero.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				alunoChange.setNumero(JTNumero.getText());
			}
			
		});
		JTNumero.setBounds(420, 315, 250, 26);
		getContentPane().add(JTNumero);

		JTCidade = new JTextField();
		JTCidade.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				alunoChange.setCidade(JTCidade.getText());
			}
			
		});
		JTCidade.setBounds(420, 375, 250, 26);
		getContentPane().add(JTCidade);

		JTPais = new JTextField();
		JTPais.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				alunoChange.setPais(JTPais.getText());
			}
			
		});
		JTPais.setBounds(420, 405, 250, 26);
		getContentPane().add(JTPais);

		JTCel = new JTextField();
		JTCel.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				alunoChange.setCelular(JTCel.getText());
			}
			
		});
		JTCel.setBounds(435, 110, 235, 26);
		getContentPane().add(JTCel);

		JTObs = new JTextArea();
		JTObs.addFocusListener(new FocusAdapter() {
			
			public void focusLost(FocusEvent e) {
				alunoChange.setObservacao(JTObs.getText());
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


		btnAdd.addActionListener(new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//A função precisa ser mudada para aceitar um model para dar insert em todos campos de uma vez
				//alunoDao.createAluno(alunoChange);								
				
			}
		});

		btnDelete.addActionListener(new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(alunoChange != null) {
					try {
						alunoDao.deleteAluno(alunoChange.getcodigoAluno());
					} catch (SQLException e1) {
					}
				}				
			}
		});

		btnSave.addActionListener(new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//A função precisa ser mudada para aceitar um model para dar Update em todos campos de uma vez
				//alunoDao.updateAluno(alunoChange);				
			}
		});
		
		
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

	}
	
}
