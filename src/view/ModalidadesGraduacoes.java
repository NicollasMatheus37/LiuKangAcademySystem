package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.text.ParseException;

import javax.management.modelmbean.ModelMBean;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.LookAndFeel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SizeRequirements;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ModalidadesGraduacoes extends JInternalFrame {

		// Botoes
		private JButton btnAdd;
		private JButton btnSearch;	
		private JButton btnDelete;
		private JButton btnSave;
		private JButton btnOk;
		
		// icones
		private Icon icAdd;
		private Icon icSearch;
		private Icon icDelete;
		private Icon icSave;
		
		//labels
		private JLabel infoLabel[] = new JLabel[3];
		
		//Text Fields
		private JTextField txtModalidade, txtGraduacao;
	
		//tabela e modelo
		private JTable table;
		private DefaultTableModel model;
	

	public ModalidadesGraduacoes() {

		setLayout(null);
		setSize(510, 350);
		setTitle("Modalidades e Graduações");
		setResizable(false);
		setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createComponnents();

		getRootPane().setWindowDecorationStyle(JRootPane.NONE);

		setVisible(true);
	}
	
	public static void main(String [] Args) {
		new ModalidadesGraduacoes();
	}

	public void createComponnents() {
		
		//Botao btnSearch
		btnSearch = new JButton("Buscar", new ImageIcon(System.getProperty("user.dir")+"\\images\\22x22\\localizar.png"));
		btnSearch.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearch.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSearch.setMargin(new Insets(0, 0, 0, 0));
		btnSearch.setBounds(10, 10, 120, 35);
		getContentPane().add(btnSearch);
		
		//Botao Add
		btnAdd = new JButton("Adicionar", new ImageIcon(System.getProperty("user.dir")+"\\images\\22x22\\adicionar.png"));
		btnAdd.setHorizontalAlignment(SwingConstants.LEFT);
		btnAdd.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnAdd.setMargin(new Insets(0, 0, 0, 0));
		btnAdd.setBounds(130, 10, 120, 35);
		getContentPane().add(btnAdd);
		
		
		
		//Botao Add
		btnDelete = new JButton("Remover", new ImageIcon(System.getProperty("user.dir")+"\\images\\22x22\\remover.png"));
		btnDelete.setHorizontalAlignment(SwingConstants.LEFT);
		btnDelete.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnDelete.setMargin(new Insets(0, 0, 0, 0));
		btnDelete.setBounds(250, 10, 120, 35);
		getContentPane().add(btnDelete);
		
		//Botao Add
		btnSave = new JButton("Salvar", new ImageIcon(System.getProperty("user.dir")+"\\images\\22x22\\salvar.png"));
		btnSave.setHorizontalAlignment(SwingConstants.LEFT);
		btnSave.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnSave.setMargin(new Insets(0, 0, 0, 0));
		btnSave.setBounds(370, 10, 120, 35);
		getContentPane().add(btnSave);
		

		
		//add - labels
		infoLabel[0] = new JLabel("Modalidade: ");
		infoLabel[0].setBounds(10, 10, 350, 110);
		getContentPane().add(infoLabel[0]);
		
		infoLabel[1] = new JLabel("Graduação: ");
		infoLabel[1].setBounds(14, 10, 350, 170);
		getContentPane().add(infoLabel[1]);
		
		infoLabel[2] = new JLabel("Duplo clique na linha de graduação para remové-la.");
		infoLabel[2].setBounds(10, 10, 350, 570);
		getContentPane().add(infoLabel[2]);
		
		//add - TextFields
		txtModalidade = new JTextField();
		txtModalidade.setBounds(80, 55, 410, 25);
		getContentPane().add(txtModalidade);
		
		txtGraduacao = new JTextField();
		txtGraduacao.setBounds(80, 87, 345, 25);
		getContentPane().add(txtGraduacao);
		
		//add - Botões
		btnOk = new JButton(new AbstractAction("OK") {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(txtGraduacao.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Campo de Graduação Vazio");
				else {
					model.addRow(new String[] {txtGraduacao.getText()});
					int i=0;
				}
				txtGraduacao.setText(null);
			}
		});
		btnOk.setBounds(428, 86, 60, 25);
		getContentPane().add(btnOk);
		
		//Colunas pra Jtable
		String colunas[] = { "Graduação" };
		
		//add - Jtable
		model = new DefaultTableModel(null, colunas);
		table = new JTable(model);
		table.setBorder(BorderFactory.createLineBorder(Color.black));
		table.setEnabled(true);
		table.getTableHeader().setEnabled(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoCreateColumnsFromModel(false);
		table.setSelectionBackground(Color.cyan);

				
		
		// Criando o scrollPane
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 115, 479, 170);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.getContentPane().add(scrollPane);
		
		
		
		table.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				table.setEnabled(false);
				int linha = 0;
				if(e.getClickCount() == 2) {
					linha=table.getSelectedRow();
					
					System.out.println("Linha:::::" + linha);
					model.removeRow(linha);
					table.setEnabled(true);
				}
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
;

		setTitle("Modalidade e Graduações");
		setVisible(true);
	
	}
	public boolean isCellEditable(int row, int col) {
        return false;
    }

}

