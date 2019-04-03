package view;

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
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class AdicionarModalidades extends JDialog {

	private JLabel JLModalidade, JLGrad, JLPlano, JLDataIni, JLDataFim;
	private JTextField JTextIni, JTextFim;
	private JComboBox<String> JComboMod, JComboGrad, JComboPlano;

	public AdicionarModalidades() {

		setSize(300, 290);
		setTitle("Adicionar Modalidades");
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		/*setModal(true);*/
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		creatComponents() ;
		setVisible(true);
	}

	public void creatComponents() {

		JLModalidade = new JLabel("Modalidades:");
		JLModalidade.setBounds(10,50,100, 20);
		getContentPane().add(JLModalidade);
		
		JLGrad = new JLabel("Graduação:");
		JLGrad.setBounds(10,80,100, 20);
		getContentPane().add(JLGrad);
		
		JLPlano = new JLabel("Plano:");
		JLPlano.setBounds(10,110,100, 20);
		getContentPane().add(JLPlano);
		
		JLDataIni = new JLabel("Data Início:");
		JLDataIni.setBounds(10,140,100, 20);
		getContentPane().add(JLDataIni);
		
		JLDataFim = new JLabel("Data Fim:");
		JLDataFim.setBounds(10,170,100, 20);
		getContentPane().add(JLDataFim);
		
		JComboMod = new JComboBox<String>();
		JComboMod.addItem("--Selecione--");
		JComboMod.setBounds(90, 110, 200, 26);
		getContentPane().add(JComboMod);
		
		JComboGrad = new JComboBox<>();
		JComboGrad.addItem("--Selecione--");
		JComboGrad.setBounds(90, 140, 200, 26);
		getContentPane().add(JComboGrad);
		
		JComboPlano = new JComboBox<>();
		JComboPlano.addItem("--Selecione--");
		JComboPlano.setBounds(90, 170, 200, 26);
		getContentPane().add(JComboPlano);
		
		JTextIni = new JTextField();
		JTextIni.setBounds(90,50,200,26);
		getContentPane().add(JTextIni);
		
		JTextFim = new JTextField();
		JTextFim.setBounds(90,80,200,26);
		getContentPane().add(JTextFim);
		
		
	}

}
