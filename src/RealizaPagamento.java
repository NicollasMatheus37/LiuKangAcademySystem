import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class RealizaPagamento extends JInternalFrame {

	private JLabel De, Ate, Situacao;
	private JTextField JTDe, JTAte;
	private JComboBox<String> JComboSituacao;
	private JButton btnPesq;
	private DefaultTableModel model;
	private JTable table;

	public RealizaPagamento() {

		setSize(690, 538);
		setTitle("Consultar Faturas");
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createComponnents();
		setVisible(true);

	}

	public void createComponnents() {

		De = new JLabel("De:");
		De.setBounds(10, 10, 100, 20);
		getContentPane().add(De);

		Ate = new JLabel("Até:");
		Ate.setBounds(140, 10, 100, 20);
		getContentPane().add(Ate);

		Situacao = new JLabel("Situação:");
		Situacao.setBounds(270, 10, 100, 20);
		getContentPane().add(Situacao);

		JTDe = new JTextField();
		JTDe.setBounds(40, 10, 90, 26);
		getContentPane().add(JTDe);

		JTAte = new JTextField();
		JTAte.setBounds(170, 10, 90, 26);
		getContentPane().add(JTAte);

		btnPesq = new JButton("Pesquisar");
		btnPesq.setBounds(560, 5, 110, 35);
		getContentPane().add(btnPesq);

		JComboSituacao = new JComboBox<String>();
		JComboSituacao.addItem("Todas");
		JComboSituacao.addItem("Em Aberto");
		JComboSituacao.addItem("Pagas");
		JComboSituacao.addItem("Canceladas");
		JComboSituacao.setBounds(340, 10, 200, 26);
		getContentPane().add(JComboSituacao);

		String colunas[] = { "Matrícula", "Aluno", "Vencimento", "Valor", "Pagamento", "Cancelamento" };

		model = new DefaultTableModel(colunas, 0);

		table = new JTable(model);
		table.setBorder(BorderFactory.createLineBorder(Color.black));
		table.setEnabled(true);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 50, 660, 450);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.getContentPane().add(scrollPane);
		table.getTableHeader().setEnabled(false);

	}

}
