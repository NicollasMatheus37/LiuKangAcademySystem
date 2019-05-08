package view;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import dao.FaturaMatriculaDAO;
import model.FaturaMatriculaModel;

public class GerarFaturas extends JInternalFrame {

	private JLabel DataFatura;
	private JButton btnGerarFatura;
	BaseMonthChooser data;
	Date date;
	
	public GerarFaturas() {

		setSize(305, 110);
		setTitle("Gerar Faturas");
		setResizable(false);
		setClosable(true);
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createComponents();
		setVisible(true);

	}

	public void createComponents() {

		data = new BaseMonthChooser();
		data.setBounds(100, 10, 185, 26);
		getContentPane().add(data);

		java.util.Date dueDate = data.getDate();
		date = new Date(dueDate.getYear(), dueDate.getMonth(), dueDate.getDate());
		System.out.println(date);
		
		DataFatura = new JLabel("Data da fatura: ");
		DataFatura.setBounds(10, 0, 100, 45);
		getContentPane().add(DataFatura);
		
		btnGerarFatura = new JButton("Gerar Fatura");
		btnGerarFatura.setBounds(100, 40, 185, 30);
		getContentPane().add(btnGerarFatura);
		
	}
	
	public ArrayList<FaturaMatriculaModel> getMatriculas(String data) throws SQLException {
		ArrayList<FaturaMatriculaModel> faturaMatriculas = (new FaturaMatriculaDAO()).getFromCustomSql(data);
		return faturaMatriculas;
	}
	
	public void gerarFaturas() throws SQLException {
		 ArrayList<FaturaMatriculaModel> faturaMatriculas = this.getMatriculas(""
		 		+ "select matricula.dia_vencimento as data_vencimento,"
		 		+ "plano.valor_mensal as valor, matricula_modalidade.codigo_matricula"
		 		+ "from matricula"
		 		+ "inner join matricula_modalidade on matricula.codigo_matricula = matricula_modalidade.codigo_matricula"
		 		+ "inner join plano on matricula_modalidade.plano = plano.plano"
		 		+ "where matricula_modalidade.data_fim is null");
		 
		 for(FaturaMatriculaModel faturaMatricula : faturaMatriculas) {
			 new FaturaMatriculaDAO().createFaturaMatricula(faturaMatricula);
		 }
	}
	
	// 
}
