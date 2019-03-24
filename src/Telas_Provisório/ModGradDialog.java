package Telas_Provisório;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;


public class ModGradDialog extends MasterDialog{
	
	//labels
	private JLabel infoLabel[] = new JLabel[3];
	
	//Text Fields
	private JTextField txtModalidade, txtGraduacao;
	
	//Botões
	private JButton btnOk;
	
	//tabela e modelo
	private JTable table;
	private DefaultTableModel model;
	
	
	public static void main(String Args[]) {
		
		new ModGradDialog();
	}


	public ModGradDialog(){

		
		//add - labels
		infoLabel[0] = new JLabel("Modalidade: ");
		infoLabel[0].setBounds(5, 10, 350, 110);
		getContentPane().add(infoLabel[0]);
		
		infoLabel[1] = new JLabel("Graduação: ");
		infoLabel[1].setBounds(5, 10, 350, 170);
		getContentPane().add(infoLabel[1]);
		
		infoLabel[2] = new JLabel("Duplo clique na linha de graduação para remové-la.");
		infoLabel[2].setBounds(5, 10, 350, 570);
		getContentPane().add(infoLabel[2]);
		
		//add - TextFields
		txtModalidade = new JTextField();
		txtModalidade.setBounds(80, 55, 400, 20);
		getContentPane().add(txtModalidade);
		
		txtGraduacao = new JTextField();
		txtGraduacao.setBounds(80, 87, 335, 20);
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
		btnOk.setBounds(420, 83, 60, 25);
		getContentPane().add(btnOk);
		
		//Colunas pra Jtable
		String colunas[] = { "Graduação" };
		
		//add - Jtable
		model = new DefaultTableModel(null, colunas);
		table = new JTable(model);
		table.setBorder(BorderFactory.createLineBorder(Color.black));
		table.setEnabled(true);
		table.setRowSelectionAllowed(true);
		table.getTableHeader().setEnabled(false);
		table.setSelectionBackground(Color.cyan);
		table.setCellSelectionEnabled(true);
		
		
		// Criando o scrollPane
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 115, 460, 170);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.getContentPane().add(scrollPane);
		
		
		
		table.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				int linha = 0;
				if(e.getClickCount() == 2) {
					linha=table.getSelectedRow();
					
					System.out.println("Linha:::::" + linha);
					model.removeRow(linha);
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

