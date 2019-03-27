import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Planos extends JInternalFrame {

	private JButton btnSearch, btnAdd, btnDelete, btnSave, btnOk;
	private JLabel Modalidade, Plano, Valor;
	private JTextField JTPlano,JTValor;
	private JComboBox<String> ComboModalidade;
	
	public Planos() {

		setSize(690, 538);
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
