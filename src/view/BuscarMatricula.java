package view;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.AlunoDAO;
import dao.MatriculaDAO;
import model.AlunoModel;
import model.MatriculaModel;

@SuppressWarnings("serial")
public class BuscarMatricula extends MasterBuscar {

	public MatriculaModel matriculaReturn;
	private ArrayList<MatriculaModel> matriculas;
	private MatriculaDAO matriculaDAO;

	public BuscarMatricula() {
		matriculaDAO = new MatriculaDAO();
		updateComp(new String[]{"Código","Aluno"});
		matriculaReturn = null;
	}

	protected void buscar() {		
		try {
			clean();

			if(campos.getSelectedIndex() == 1) {
				String alunos = "";
				ArrayList<AlunoModel> list = alunoDao.getAllAlunos(); 
				for(AlunoModel aluno : list) {
					if(utils.containsIgnoreCase(aluno.getAluno(), jTxtBusca.getText())) {
						alunos = alunos + ((alunos.isEmpty()) ? "" : ", ") + Integer.toString(aluno.getcodigoAluno()); 
					}
				}
				matriculas = matriculaDAO.getAllMatriculas(alunos);
				for(MatriculaModel mat : matriculas) {
					InsertRow(Integer.toString(mat.getCodigoMatricula()), mat.getDataMatricula());
				}
			} else {

				MatriculaModel matricula = matriculaDAO.getOneMatricula(Integer.parseInt(jTxtBusca.getText()), true);
				if(matricula!=null) {
					InsertRow(Integer.toString(matricula.getCodigoMatricula()), new AlunoDAO().getOneAluno(matricula.getCodigoAluno()).getAluno());
					matriculas = new ArrayList<>();
					matriculas.add(matricula);
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	protected void setReturn() {
		matriculaReturn = matriculas.get(table.getSelectedRow()); 
	}


}
