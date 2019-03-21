import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.AbstractAction;
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

public class Alunos extends JInternalFrame {

	private JTextField jcodigo, jaluno, jdata, jcelular, jtelefone, jemail, jnumero, jcomplemento, jbairro;
	private JTextArea jobservacao;
	private JComboBox<String> cbxGenero, pais, estado, cidade;
	private JButton btnSair, btnEnviar;
	private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12,
			label13, label14;
	private JLabel labelExiste, labelSuccess, labelPreencher, labelLocalexiste;
	private ArrayList<String> arlAluno = new ArrayList<String>(14);
	private boolean alteracao = false;
	private String[] infoA, lista;
	private Menu menuw;
	private JDesktopPane jdk;
	private Modalidades pA;
	static JOptionPane Preencher,Existe,NaoExiste,Sucesso;
	
	
	public Alunos(Menu menu) throws ParseException {
		menuw = menu;
		alteracao = false;
		setSize(690, 538);
		setTitle("Cadastro de Alunos");
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		
	
		setVisible(true);
	}

	public Alunos(JDesktopPane jdk, Modalidades pa, String[] info) throws ParseException {
		pA = pa;
		infoA = info;
		this.jdk = jdk;
		alteracao = true;
		setSize(690, 600);
		setTitle("Cadastro de Alunos");
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	
		setVisible(true);
	}
}

