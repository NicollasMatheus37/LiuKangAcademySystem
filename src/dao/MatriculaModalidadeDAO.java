package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.MatriculaModalidadeModel;

public class MatriculaModalidadeDAO extends BaseDAO {
	
	public ArrayList<MatriculaModalidadeModel> getAllMatriculasModalidades() throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("matriculas_modalidades")
			.apply();
			
		result.first();
		
		ArrayList<MatriculaModalidadeModel> matriculaModalidadeList = new ArrayList<MatriculaModalidadeModel>();
		while((result.getRow() != 0) && (!result.isAfterLast())) {
			matriculaModalidadeList.add(new MatriculaModalidadeModel()
					
					.setCodigoMatricula(result.getInt("codigo_matricula"))
					.setModalidade(result.getString("modalidade"))
					.setGraduacao(result.getString("graduacao"))
					.setPlano(result.getString("plano"))
					.setDataInicio(result.getDate("data_inicio"))
					.setDataFim(result.getDate("data_fim"))
					);
					result.next();
					}
					return matriculaModalidadeList;
	}
	
	public MatriculaModalidadeModel getOneMatriculaModalidade(Integer id) throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("matriculas_modalidades")
			.where("id", "=", id.toString())
			.apply();
		
		MatriculaModalidadeModel matriculaModalidade = new MatriculaModalidadeModel();
		return matriculaModalidade.setCodigoMatricula(result.getInt("codigo_matricula"))
				.setModalidade(result.getString("modalidade"))
				.setGraduacao(result.getString("graduacao"))
				.setPlano(result.getString("plano"))
				.setDataInicio(result.getDate("data_inicio"))
				.setDataFim(result.getDate("data_fim"));
	}
	
	public void createMatriculaModalidade(MatriculaModalidadeModel matriculaModalidade) throws SQLException{
		String fields = "codigo_matricula, modalidade, graduacao, plano, data_inicio, data_fim";
		this.insertInto("matriculas_modalidades", fields)
		.values(
				Integer.toString(matriculaModalidade.getCodigoMatricula())+","+
				matriculaModalidade.getModalidade()+","+
				matriculaModalidade.getGraduacao()+","+
				matriculaModalidade.getPlano()+","+
				matriculaModalidade.getDataMatricula()+","+
				matriculaModalidade.getData_fim()
				)
		.commit();
	}
	
	public void updateMatriculaModalidade(MatriculaModalidadeModel matriculaModaliade, Integer id) throws SQLException{
		this.update("matriculas_modalidades")
		.setValue(
				  "codigo_matricula = "+matriculaModaliade.getCodigoMatricula()+
				  "modalidade = "+matriculaModaliade.getModalidade()+
				  "graduacao = "+matriculaModaliade.getGraduacao()+
				  "plano = "+matriculaModaliade.getPlano()+
				  "data_inicio = "+matriculaModaliade.getDataMatricula()+
				  "data_fim = "+matriculaModaliade.getData_fim()
				)
		.where("id", "=", id.toString())
		.commit();
	}
	
	public void deleteMatriculaModalidade(Integer id) throws SQLException{
		this.delete()
		.from("matriculas_modalidades")
		.where("id", "=", id.toString())
		.commit();
	}

}
