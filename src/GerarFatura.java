import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class GerarFatura extends JInternalFrame {

	private JLabel DataFatura;
	private JButton btnGerarFatura;
	
	
	public GerarFatura() {

		setSize(690, 538);
		setTitle("Gerar Faturas");
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createComponnents();
		setVisible(true);

	}

	public void createComponnents() {
		
		DataFatura = new JLabel("Data da fatura: ");
		DataFatura.setBounds(10, 0, 100, 100);
		getContentPane().add(DataFatura);
		
		btnGerarFatura = new JButton("Gerar Fatura");
		btnGerarFatura.setBounds(110, 80, 120, 30);
		getContentPane().add(btnGerarFatura);
				

	}

}
