import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class RelatorioMatriculas extends JInternalFrame {

	private JLabel De, Ate, Periodo;
	private JButton btnProcessar;
	private JComboBox<String> ComboHTML;
	private JTextField JTDe, JTAte;

	public RelatorioMatriculas() throws IOException {

		setSize(220, 200);
		setTitle("Relatório de Matricula");
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createComponnents();
		setVisible(true);

	}
	
	public void createComponnents() {
	
		De = new JLabel("De:");
		De.setBounds(30, 40, 100, 20);
		getContentPane().add(De);

		Ate = new JLabel("Até:");
		Ate.setBounds(30, 70, 100, 20);
		getContentPane().add(Ate);
	
		Periodo = new JLabel("Periodo:");
		Periodo.setBounds(80, 10, 100, 20);
		getContentPane().add(Periodo);
		
		JTDe = new JTextField();
		JTDe.setBounds(60, 35, 100, 26);
		getContentPane().add(JTDe);
		
		JTAte = new JTextField();
		JTAte.setBounds(60, 70, 100, 26);
		getContentPane().add(JTAte);
		
		btnProcessar = new JButton("Processar");
		btnProcessar.setBounds(100, 130, 100, 26);
		getContentPane().add(btnProcessar);
		
		ComboHTML = new JComboBox<String>();
		ComboHTML.addItem("HTML");
		ComboHTML.setBounds(10, 130, 80, 26);
		getContentPane().add(ComboHTML);
	
	}
	
}

