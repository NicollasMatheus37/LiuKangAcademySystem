package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.FaturaMatriculaModel;
import model.GraduacaoModel;
import model.MatriculaModel;

public class MatriculaDAO extends BaseDAO {
	
	public ArrayList<MatriculaModel> getAllMatriculas() throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("matriculas")
			.apply();
		
		result.first();
		
		ArrayList<MatriculaModel> matriculaList = new ArrayList<MatriculaModel>();
			while((result.getRow() != 0) && (!result.isAfterLast())) {
				matriculaList.add(new MatriculaModel()
					.setCodigoMatricula(result.getInt("codigo_matricula"))
					.setCodigoAluno(result.getInt("codigo_aluno"))
					.setDataMatricula(result.getDate("data_matricula"))
					.setDiaVencimento(result.getInt("dia_vencimento"))
					.setDataEncerramento(result.getDate("data_encerramento"))
					);
				
				result.next();
					}
			
		return matriculaList;
	}
	
	public MatriculaModel getOneMatricula(Integer id) throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("matriculas")
			.where("id", "=", id.toString())
			.apply();


		MatriculaModel matricula = new MatriculaModel();
		return matricula.setCodigoMatricula(result.getInt("codigo_matricula"))
				.setCodigoAluno(result.getInt("codigo_aluno"))
				.setDataMatricula(result.getDate("data_matricula"))
				.setDiaVencimento(result.getInt("dia_vencimento"))
				.setDataEncerramento(result.getDate("data_encerramento"));
	}
	
	public void createMatricula(String fields, String values) throws SQLException{
		this.insertInto("matriculas", fields)
		.values(values)
		.commit();
	}
	
	public void updateMatricula(String fields, String value, Integer id) throws SQLException{
		this.update("matriculas")
		.setValue(fields, value)
		.where("id", "=", id.toString())
		.commit();
	}
	
	public void deleteMatricula(Integer id) throws SQLException{
		this.delete()
		.from("matriculas")
		.where("id", "=", id.toString())
		.commit();
	}
	
}
