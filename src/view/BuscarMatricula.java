package view;

import java.sql.SQLException;

import dao.AlunoDAO;
import dao.MatriculaDAO;
import model.MatriculaModel;

@SuppressWarnings("serial")
public class BuscarMatricula extends MasterBuscar {

	public MatriculaModel matriculaReturn;
	private MatriculaDAO matriculaDAO;
	private MatriculaModel matricula;
	
	public BuscarMatricula() {
		matriculaDAO = new MatriculaDAO();
		updateComp(new String[]{"Código","Nome"});
		matriculaReturn = null;
	}
	
	protected void buscar() {		
		try {
			clean();
			matricula = matriculaDAO.getOneMatricula(Integer.parseInt(jTxtBusca.getText()));
			if(matricula!=null) {
				InsertRow(Integer.toString(matricula.getCodigoMatricula()), new AlunoDAO().getOneAluno(matricula.getCodigoAluno()).getAluno());
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	protected void setReturn() {
		matriculaReturn = matricula; 
	}
	
	
}
