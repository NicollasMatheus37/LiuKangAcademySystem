package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BackupRestore extends JInternalFrame{
	
	private JLabel lblBackup, lblRestore, lblDiretorio, lblArquivo;
	private JTextField txtDiretorio, txtArquivo;
	private JButton btnBackup, btnRestore, btnBusca, btnArchive;
	private String dirDestino, dirArquivo, arquivo;
    
	public BackupRestore() {

		setSize(500, 200);
		setTitle("Restore e Backup");
		setLayout(null);
		setResizable(false);
		setClosable(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		CreateComponnents();
		setVisible(true);

	}
	
	public void CreateComponnents() {
		
		lblDiretorio = new JLabel("Buscar Diretório");
		lblDiretorio.setBounds(20, 14, 437, 38);
		getContentPane().add(lblDiretorio);
		
		txtDiretorio = new JTextField();
		txtDiretorio.setBounds(120, 20, 200, 26);
		getContentPane().add(txtDiretorio);
		
		lblArquivo = new JLabel("Buscar Arquivo");
		lblArquivo.setBounds(20, 54, 437, 38);
		getContentPane().add(lblArquivo);
		
		txtArquivo = new JTextField();
		txtArquivo.setBounds(120, 60, 200, 26);
		getContentPane().add(txtArquivo);

		
		btnBusca = new JButton("Buscar");
		btnBusca.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        int value = fileChooser.showOpenDialog(null);
		        if (value == JFileChooser.APPROVE_OPTION) {
		          dirDestino = fileChooser.getSelectedFile().getPath();
		          txtDiretorio.setText(dirDestino);
		        }
			}
		});
		btnBusca.setBounds(330, 20, 80, 26 );
		getContentPane().add(btnBusca);
		
		btnArchive = new JButton("Buscar");
		btnArchive.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fileChooser = new JFileChooser();
		        int value = fileChooser.showOpenDialog(null);
		        if (value == JFileChooser.APPROVE_OPTION) {
		          dirArquivo = fileChooser.getSelectedFile().getPath();
		          txtArquivo.setText(dirArquivo);
		          arquivo = fileChooser.getSelectedFile().getName();
		        }
			}
		});
		btnArchive.setBounds(330, 60, 80, 26 );
		getContentPane().add(btnArchive);
		
		btnBackup = new JButton("Fazer Backup");
		btnBackup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!txtArquivo.getText().isEmpty() || !txtDiretorio.getText().isEmpty() || !arquivo.equals("pg_dump")) {
					try {
						Backup();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Diretórios Incorretos ou não informados!");
				
			}
		});
		btnBackup.setBounds(90, 100, 120, 40);
		getContentPane().add(btnBackup);
		
		btnBackup = new JButton("Fazer Restore");
		btnBackup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!txtArquivo.getText().isEmpty() || !txtDiretorio.getText().isEmpty() || !arquivo.equals("pg_restore")) {
					try {
						Restore();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Diretórios Incorretos ou não informados");
				
			}
		});
		btnBackup.setBounds(230, 100, 120, 40);
		getContentPane().add(btnBackup);

	}

		
	
	
	
	public void Restore() throws IOException, InterruptedException{      
        final ArrayList<String> comandos = new ArrayList<String>();      
          
        comandos.add(dirArquivo);
        comandos.add("-i");      
        comandos.add("-h");      
        comandos.add("localhost");
        comandos.add("-p");      
        comandos.add("5432");      
        comandos.add("-U");      
        comandos.add("admin");      
        comandos.add("-d");      
        comandos.add("master");     
        comandos.add("-v");      
          
        comandos.add(dirDestino);

        ProcessBuilder pb = new ProcessBuilder(comandos);      
          
        pb.environment().put("PGPASSWORD", "admin");        
          
        try {      
            final Process process = pb.start();      
      
            final BufferedReader r = new BufferedReader(      
                new InputStreamReader(process.getErrorStream()));      
            String line = r.readLine();      
            while (line != null) {      
            System.err.println(line);      
            line = r.readLine();      
            }      
            r.close();      
      
            process.waitFor();    
            process.destroy(); 
            JOptionPane.showMessageDialog(null,"Restore realizado com sucesso.");  
      
        } catch (IOException e) {      
            e.printStackTrace();      
        } catch (InterruptedException ie) {      
            ie.printStackTrace();      
        }         
            
    }      

    public void Backup() throws IOException, InterruptedException{      
        List<String> comandos = new ArrayList<String>();     
             comandos.add(dirArquivo);
      
                    comandos.add("-h");      
                    comandos.add("localhost");
                    comandos.add("-p");      
                    comandos.add("5432");      
                    comandos.add("-U");      
                    comandos.add("postgres");      
                    comandos.add("-F");      
                    comandos.add("c");      
                    comandos.add("-b");      
                    comandos.add("-v");      
                    comandos.add("-f"); 

                    comandos.add(dirDestino);       
                    ProcessBuilder pb = new ProcessBuilder(comandos);      

                    //pb.environment().put("PGPASSWORD", "admin");              

                    try {      
                        Process process = pb.start();  


                        BufferedReader r = new BufferedReader(      
                            new InputStreamReader(process.getErrorStream()));      
                        String line = r.readLine();      
                        while (line != null) {      
                        System.err.println(line);      
                        line = r.readLine();      
                        }      
                        r.close();      

                        process.waitFor();    
                        process.destroy(); 
                        JOptionPane.showMessageDialog(null,"backup realizado com sucesso.");  

                    } catch (IOException e) {      
                        e.printStackTrace();      
                    } catch (InterruptedException ie) {      
                        ie.printStackTrace();      
                    } 
  }
    
    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy HHmm");
        Date date = new Date();
        return dateFormat.format(date);
    } 

}
