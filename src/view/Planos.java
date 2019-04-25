package view;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Planos extends MasterDialogCad {

	private JButton  btnOk;
	private JLabel Modalidade, Plano, Valor;
	private JTextField JTPlano,JTValor;
	private JComboBox<String> ComboModalidade;
	
	public Planos() {

		setSize(690, 180);
		setTitle("Planos");
		setLayout(null);
		setResizable(false);
		setClosable(true);
		// this.setBorder(javax.swing.BorderFactory.createLineBorder(Color.DARK_GRAY));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createComponnents();
		setVisible(true);
	}

	public void createComponnents() {

		Modalidade = new JLabel("Modalidade:");
		Modalidade.setBounds(10, 10, 100, 100);
		getContentPane().add(Modalidade);

		Plano = new JLabel("Plano:");
		Plano.setBounds(10, 40, 100, 100);
		getContentPane().add(Plano);
		
		Valor = new JLabel("Valor:");
		Valor.setBounds(10, 70, 100, 100);
		getContentPane().add(Valor);
		
		ComboModalidade = new JComboBox<String>();
		ComboModalidade.addItem("--Selecione--");
		ComboModalidade.setBounds(85, 47, 585, 26);
		getContentPane().add(ComboModalidade);

		JTPlano = new JTextField();
		JTPlano.setBounds(85, 80, 585, 26);
		getContentPane().add(JTPlano);
		
		JTValor = new JTextField();
		JTValor.setBounds(85, 110, 205, 26);
		getContentPane().add(JTValor);

	}

}
