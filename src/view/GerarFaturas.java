package view;
import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import base.BaseMonthChooser;

public class GerarFaturas extends JInternalFrame {

	private JLabel DataFatura;
	private JButton btnGerarFatura;
	BaseMonthChooser data;
	
	public GerarFaturas() {

		setSize(305, 110);
		setTitle("Gerar Faturas");
		setResizable(false);
		setClosable(true);
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createComponnents();
		setVisible(true);

	}

	public void createComponnents() {
		
		data = new BaseMonthChooser();
		data.setBounds(100, 10, 185, 26);
		getContentPane().add(data);
		
		
		DataFatura = new JLabel("Data da fatura: ");
		DataFatura.setBounds(10, 0, 100, 45);
		getContentPane().add(DataFatura);
		
		btnGerarFatura = new JButton("Gerar Fatura");
		btnGerarFatura.setBounds(100, 40, 185, 30);
		getContentPane().add(btnGerarFatura);
		
		
				

	}

}
