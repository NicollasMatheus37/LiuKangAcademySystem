package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.GraduacaoModel;

public class GraduacaoDAO extends BaseDAO {

	public ArrayList<GraduacaoModel> getAllGraduacoes(String modalidade) throws SQLException{
		ResultSet result = null;
		if (modalidade.trim().isEmpty()) {
			result = this.select("*")
					.from("graduacoes")
					.apply();
		}else {
			result = this.select("*")
					.from("graduacoes")
					.where("modalidade", "=", quoteStr(modalidade))
					.apply();
		}
		ArrayList<GraduacaoModel> graduacaoList = new ArrayList<GraduacaoModel>();
		while(result.next()) {			
			graduacaoList.add(new GraduacaoModel()
					.setModalidade(result.getString("modalidade"))
					.setGraduacao(result.getString("graduacao"))
					);
		}

		return graduacaoList;

	}
	
	public void insertGraduacoes(ArrayList<GraduacaoModel> graduacoes, String modalidade) {
		deleteGraduacoes(modalidade);
		for(GraduacaoModel graduacaoModel : graduacoes) {
			try {
				this.insertInto("graduacoes", "modalidade, graduacao")
				.values(quoteStr(modalidade)+","+quoteStr(graduacaoModel.getGraduacao()))
				.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/*public GraduacaoModel getOneGraduacao(Integer id) throws SQLException{
		ResultSet result = null;
		result = this.select("*")
				.from("graduacoes")
				.where("id", "=", id.toString())
				.apply();

		GraduacaoModel graduacao = new GraduacaoModel();
		return graduacao.setModalidade(result.getString("modalidade"))
				.setGraduacao(result.getString("graduacao"));

	}*/

	

	/*public void updateGraduacao(GraduacaoModel graduacao, Integer id) throws SQLException{
		this.update("graduacoes")
		.setValue(
				"modalidade = "+graduacao.getModalidade()+
				"graduacao = "+graduacao.getGraduacao()

				)
		.where("id", "=", id.toString())
		.commit();
	}*/

	public void deleteGraduacoes(String modalidade) {

		try {
			this.delete()
			.from("graduacoes")
			.where("modalidade", "=", quoteStr(modalidade))
			.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
