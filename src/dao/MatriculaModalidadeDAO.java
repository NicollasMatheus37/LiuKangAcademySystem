package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.MatriculaModalidadeModel;

public class MatriculaModalidadeDAO extends BaseDAO {

	public ArrayList<MatriculaModalidadeModel> getAllMatriculasModalidades(int Matricula) throws SQLException{
		ResultSet result = null;
		if(Matricula>0) {
			result = this.select("*")
					.from("matriculas_modalidades")
					.where("matricula", "=", Integer.toString(Matricula))
					.apply();
		}else {
			result = this.select("*")
					.from("matriculas_modalidades")
					.apply();
		}

		ArrayList<MatriculaModalidadeModel> matriculaModalidadeList = new ArrayList<MatriculaModalidadeModel>();
		while(result.next()) {
			matriculaModalidadeList.add(new MatriculaModalidadeModel()

					.setCodigoMatricula(result.getInt("codigo_matricula"))
					.setModalidade(result.getString("modalidade"))
					.setGraduacao(result.getString("graduacao"))
					.setPlano(result.getString("plano"))
					.setData_inicio(result.getDate("data_inicio"))
					.setData_Fim(result.getDate("data_fim"))
					);

		}
		return matriculaModalidadeList;
	}

	public void createMatriculaModalidade(ArrayList<MatriculaModalidadeModel> matModalidades, int matricula) throws SQLException{
		String fields = "codigo_matricula, modalidade, graduacao, plano, data_inicio, data_fim";
		deleteMatriculaModalidade(matricula);
		for(MatriculaModalidadeModel matriculaModalidade : matModalidades) {
			this.insertInto("matriculas_modalidades", fields)
			.values(
					Integer.toString(matriculaModalidade.getCodigoMatricula())+",'"+
							matriculaModalidade.getModalidade()+"','"+
							matriculaModalidade.getGraduacao()+"','"+
							matriculaModalidade.getPlano()+"','"+
							matriculaModalidade.getData_inicio()+"','"+
							matriculaModalidade.getData_fim()+"'"
					)
			.commit();
		}
	}
	
	public void updateMatriculaModalidade(MatriculaModalidadeModel matriculaModaliade, Integer id) throws SQLException{
		this.update("matriculas_modalidades")
		.setValue(
				  "codigo_matricula = "+matriculaModaliade.getCodigoMatricula()+
				  "modalidade = "+matriculaModaliade.getModalidade()+
				  "graduacao = "+matriculaModaliade.getGraduacao()+
				  "plano = "+matriculaModaliade.getPlano()+
				  "data_inicio = "+matriculaModaliade.getData_inicio()+
				  "data_fim = "+matriculaModaliade.getData_fim()
				)
		.where("id", "=", id.toString())
		.commit();
	}
	
	public void deleteMatriculaModalidade(Integer id) throws SQLException{
		this.delete()
		.from("matriculas_modalidades")
		.where("matricula", "=", id.toString())
		.commit();
	}

}
