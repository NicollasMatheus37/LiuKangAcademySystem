package view;

import java.sql.SQLException;
import java.util.ArrayList;

import model.AlunoModel;

public class BuscarAluno extends Buscar {
	
	public AlunoModel alunoReturn;
	private ArrayList<AlunoModel> alunos;
	
	public BuscarAluno() {
		updateComp(new String[]{"Código","Nome"});
	}
		
	protected void buscar() {
		try {
			if(campos.getSelectedIndex()==1) {
				alunos = alunoDao.getAllAlunos();
				for(int i = 0; i < alunos.size(); i++) {

					if(campos.getSelectedIndex() > 0) {
						if(utils.compareStrings(alunos.get(i).getAluno(), jTxtBusca.getText())) {
							InsertRow(alunos.get(i).getcodigoAluno(), alunos.get(i).getAluno());
						}
					}

				}
			}else {						
				alunos = new ArrayList<AlunoModel>();
				alunos.add(alunoDao.getOneAluno(Integer.parseInt(jTxtBusca.getText())));
				InsertRow(alunos.get(0).getcodigoAluno(), alunos.get(0).getAluno());
			}	

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	protected void setReturn() {
		alunoReturn = alunos.get(table.getSelectedRow());
	}

}
