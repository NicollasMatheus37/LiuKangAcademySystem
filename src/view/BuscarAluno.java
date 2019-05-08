package view;

import java.sql.SQLException;
import java.util.ArrayList;

import model.AlunoModel;

@SuppressWarnings("serial")
public class BuscarAluno extends MasterBuscar {

	public AlunoModel alunoReturn;
	private ArrayList<AlunoModel> alunos;

	public BuscarAluno() {		
		updateComp(new String[]{"Código","Nome"});
		alunoReturn = null;
	}

	protected void buscar() {		
		try {
			clean();
			if(campos.getSelectedIndex()==1) {
				alunos = alunoDao.getAllAlunos();
				for(int i = 0; i < alunos.size(); i++) {

					if(utils.containsIgnoreCase(alunos.get(i).getAluno(), jTxtBusca.getText())) {						
						InsertRow(Integer.toString(alunos.get(i).getcodigoAluno()), alunos.get(i).getAluno());
					}else {
						alunos.remove(i);
						i--;
					}

				}
			}else {			
				if(jTxtBusca.getText().matches("[0123456789]+")) {
					alunos = new ArrayList<AlunoModel>();
					AlunoModel alunoResult = alunoDao.getOneAluno(Integer.parseInt(jTxtBusca.getText().trim()));
					if(alunoResult!=null) {
						alunos.add(alunoResult);
						InsertRow(Integer.toString(alunos.get(0).getcodigoAluno()), alunos.get(0).getAluno());
					}
				}
			}	

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	protected void setReturn() {
		alunoReturn = alunos.get(table.getSelectedRow());
	}

}
