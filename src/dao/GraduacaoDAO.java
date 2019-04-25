package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.GraduacaoModel;

public class GraduacaoDAO extends BaseDAO {
	
	public ArrayList<GraduacaoModel> getAllGraduacoes() throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("graduacoes")
			.apply();
		
		result.first();
		
		ArrayList<GraduacaoModel> graduacaoList = new ArrayList<GraduacaoModel>();
			while((result.getRow() != 0) && (!result.isAfterLast())) {
				graduacaoList.add(new GraduacaoModel()
					.setModalidade(result.getString("modalidade"))
					.setGraduacao(result.getString("graduacao"))
					);
				
				result.next();
					}
			
		return graduacaoList;
				
	}
	
	public GraduacaoModel getOneGraduacao(Integer id) throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("graduacoes")
			.where("id", "=", id.toString())
			.apply();
		
		GraduacaoModel graduacao = new GraduacaoModel();
		return graduacao.setModalidade(result.getString("modalidade"))
						.setGraduacao(result.getString("graduacao"));
		
	}
	
	public void createGraduacao(GraduacaoModel graduacao) throws SQLException{
		String fields = "modalidade, graduacao";
		this.insertInto("graduacoes", fields)
		.values(
				graduacao.getModalidade()+","+
				graduacao.getGraduacao()
				)
		.commit();
	}
	
	public void updateGraduacao(GraduacaoModel graduacao, Integer id) throws SQLException{
		this.update("graduacoes")
		.setValue(
				  "modalidade = "+graduacao.getModalidade()+
				  "graduacao = "+graduacao.getGraduacao()
				
				)
		.where("id", "=", id.toString())
		.commit();
	}
	
	public void deleteGraduacao(Integer id) throws SQLException{
		this.delete()
		.from("graducoes")
		.where("id", "=", id.toString())
		.commit();
	}

}
