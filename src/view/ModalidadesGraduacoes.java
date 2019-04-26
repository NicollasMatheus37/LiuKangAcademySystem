package view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class ModalidadesGraduacoes extends MasterDialogCad {

		private JButton btnOk;
		
		//labels
		private JLabel lblModalidade, lblGraduacao, lblTip;
		
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
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		setVisible(true);
	}
	
	public static void main(String [] Args) {
		new ModalidadesGraduacoes();
	}
	

	protected void subComponnents() {
		
		//add - labels
		lblModalidade = new JLabel("Modalidade: ");
		lblModalidade.setBounds(10, 10, 350, 110);
		getContentPane().add(lblModalidade);
		
		lblGraduacao = new JLabel("Graduação: ");
		lblGraduacao.setBounds(14, 10, 350, 170);
		getContentPane().add(lblGraduacao);
		
		lblTip = new JLabel("Duplo clique na linha de graduação para remové-la.");
		lblTip.setBounds(10, 10, 350, 570);
		getContentPane().add(lblTip);
		
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
		
		btnCancel.setVisible(false);
	
	}
	public boolean isCellEditable(int row, int col) {
        return false;
    }

}

