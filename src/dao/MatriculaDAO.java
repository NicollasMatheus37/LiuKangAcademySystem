package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AlunoModel;
import model.MatriculaModel;

public class MatriculaDAO extends BaseDAO {
	
	public ArrayList<MatriculaModel> getAllMatriculas() throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("matriculas")
			.apply();
		
		ArrayList<MatriculaModel> matriculaList = new ArrayList<MatriculaModel>();
			while(result.next()) {
				matriculaList.add(new MatriculaModel()
					.setCodigoMatricula(result.getInt("codigo_matricula"))
					.setCodigoAluno(result.getInt("codigo_aluno"))
					.setDataMatricula(result.getDate("data_matricula"))
					.setDiaVencimento(result.getInt("dia_vencimento"))
					.setDataEncerramento(result.getDate("data_encerramento"))
					);
				
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
	
	public void createMatricula(MatriculaModel matricula) throws SQLException{
		String fields ="codigo_matricula, codigo_aluno,  data_matricula, dia_vencimento, data_encerramento";
		this.insertInto("matriculas", fields)
		.values(
				Integer.toString(matricula.getCodigoMatricula())+","+
				Integer.toString(matricula.getCodigoAluno())+","+
				matricula.getDataMatricula()+","+
				Integer.toString(matricula.getDiaVencimento())+","+
				matricula.getDataEncerramento()	
				)
		.commit();
	}
	
	public void updateMatricula(MatriculaModel matricula, Integer id) throws SQLException{
		this.update("matriculas")
		.setValue(
				  "codigo_matricula = "+matricula.getCodigoMatricula()+
				  "codigo_aluno = "+matricula.getCodigoAluno()+
				  "data_matricula = "+matricula.getDataMatricula()+
				  "dia_vencimento = "+matricula.getDiaVencimento()+
				  "data_encerramento = "+matricula.getDataEncerramento()
				)
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
