import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class Cadastro_Alunos extends JInternalFrame {

	private JButton btnSearch, btnAdd, btnDelete, btnSave;
	private JLabel Aluno, DataNasc, Tel, Email, Obs, Endereco, Complemento, Bairro, Estado,
	CEP, Numero, Cidade, Pais, Sexo, Celular;
	private JTextField JTAluno, JTDataNasc, JTTel, JTEmail, JTEndereco, JTComplemento, JTBairro,
	JTEstado, JTCEP, JTNumero, JTCidade, JTPais, JTCel;
	private JTextArea JTObs;
	private JComboBox<String> ComboSexo;
	
	public Cadastro_Alunos() throws ParseException {

		setSize(690, 538);
		setTitle("Cadastro de Alunos");
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createComponnents();
		setVisible(true);
	}

	public void createComponnents() {

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
		

		JTAluno = new JTextField();
		JTAluno.setBounds(135, 50, 250, 26);
		getContentPane().add(JTAluno);

		JTDataNasc = new JTextField();
		JTDataNasc.setBounds(135, 80, 250, 26);
		getContentPane().add(JTDataNasc);

		JTTel = new JTextField();
		JTTel.setBounds(135, 110, 250, 26);
		getContentPane().add(JTTel);
		
		JTEmail = new JTextField();
		JTEmail.setBounds(135, 140, 250, 26);
		getContentPane().add(JTEmail);
		
		JTEndereco = new JTextField();
		JTEndereco.setBounds(100, 315, 250, 26);
		getContentPane().add(JTEndereco);

		JTComplemento = new JTextField();
		JTComplemento.setBounds(100, 345, 570, 26);
		getContentPane().add(JTComplemento);

		JTBairro = new JTextField();
		JTBairro.setBounds(100, 375, 250, 26);
		getContentPane().add(JTBairro);
		
		JTEstado = new JTextField();
		JTEstado.setBounds(100, 405, 250, 26);
		getContentPane().add(JTEstado);
		
		JTCEP = new JTextField();
		JTCEP.setBounds(100, 435, 250, 26);
		getContentPane().add(JTCEP);

		JTNumero = new JTextField();
		JTNumero.setBounds(420, 315, 250, 26);
		getContentPane().add(JTNumero);

		JTCidade = new JTextField();
		JTCidade.setBounds(420, 375, 250, 26);
		getContentPane().add(JTCidade);
		
		JTPais = new JTextField();
		JTPais.setBounds(420, 405, 250, 26);
		getContentPane().add(JTPais);
		
		JTCel = new JTextField();
		JTCel.setBounds(435, 110, 235, 26);
		getContentPane().add(JTCel);
		
		JTObs = new JTextArea();
		getContentPane().add(JTObs);
		JTObs.setLineWrap(true);

		JScrollPane sp = new JScrollPane(JTObs);
		sp.setBounds(10, 210, 657, 70);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.getContentPane().add(sp);
		
		ComboSexo = new JComboBox<String>();
		ComboSexo.addItem("--Selecione--");
		ComboSexo.addItem("Masculino");
		ComboSexo.addItem("Feminino");
		ComboSexo.setBounds(435, 80, 235, 26);
		getContentPane().add(ComboSexo);
		
		
		// Botao btnSearch
		btnSearch = new JButton("Buscar",
			new ImageIcon(System.getProperty("user.dir") + "\\images\\22x22\\localizar.png"));
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearch.setHorizontalTextPosition(SwingConstants.RIGHT);
		/* btnSearch.setMargin(0, 0, 0, 0); */
		btnSearch.setBounds(10, 10, 120, 35);
		getContentPane().add(btnSearch);

		// Botao Add
		btnAdd = new JButton("Adicionar",
		new ImageIcon(System.getProperty("user.dir") + "\\images\\22x22\\adicionar.png"));
		btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdd.setHorizontalTextPosition(SwingConstants.RIGHT);
		/* btnAdd.setMargin(new Insets(0, 0, 0, 0)); */
		btnAdd.setBounds(130, 10, 120, 35);
		getContentPane().add(btnAdd);

		// Botao Add
		btnDelete = new JButton("Remover",
		new ImageIcon(System.getProperty("user.dir") + "\\images\\22x22\\remover.png"));
		btnDelete.setHorizontalAlignment(SwingConstants.LEFT);
		btnDelete.setHorizontalTextPosition(SwingConstants.RIGHT);
		/* btnDelete.setMargin(new Insets(0, 0, 0, 0)); */
		btnDelete.setBounds(250, 10, 120, 35);
		getContentPane().add(btnDelete);

		// Botao Add
		btnSave = new JButton("Salvar", new ImageIcon(System.getProperty("user.dir") + "\\images\\22x22\\salvar.png"));
		btnSave.setHorizontalAlignment(SwingConstants.LEFT);
		btnSave.setHorizontalTextPosition(SwingConstants.RIGHT);
		/* btnSave.setMargin(new Insets(0, 0, 0, 0)); */
		btnSave.setBounds(370, 10, 120, 35);
		getContentPane().add(btnSave);

	}

}
