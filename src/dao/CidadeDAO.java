package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.CidadeModel;

public class CidadeDAO extends BaseDAO {

	public ArrayList<CidadeModel> getAllCidades() throws SQLException {
		ResultSet result = null;
		result = this.select("*")
				.from("cidades")
				.apply();


		result.first();

		ArrayList<CidadeModel> cidadeList = new ArrayList<CidadeModel>();
		while((result.getRow() != 0) && (!result.isAfterLast())) {
			cidadeList.add(new CidadeModel()

					.setCidade(result.getString("cidade"))
					.setEstado(result.getString("estado"))
					.setPais(result.getString("pais"))
					);
			result.next();
		}
		return cidadeList;
	}

	public CidadeModel getOneCidade(Integer id) throws SQLException {
		ResultSet result = null;
		result = this.select("*")
				.from("cidades")
				.where("id", "=", id.toString())
				.apply();

		CidadeModel cidade = new CidadeModel();
		return cidade.setCidade(result.getString("cidade"))
				.setEstado(result.getString("estado"))
				.setPais(result.getString("pais"));


	}

	public void createCidade(CidadeModel cidade) throws SQLException {
		String fields = "cidade, estado, pais";
		this.insertInto("cidades", fields)
		.values(
				cidade.getCidade()+","+
						cidade.getEstado()+","+
						cidade.getPais()
				)
		.commit();
	}

	public void updateCidade(CidadeModel cidade, Integer id) throws SQLException {
		this.update("cidades")
		.setValue(
				"cidade = "+cidade.getCidade()+
				"estado = "+cidade.getEstado()+
				"pais = "+cidade.getPais()

				)
		.where("id", "=", id.toString())
		.commit();
	}

	public void deleteCidade(Integer id) throws SQLException{
		this.delete()
		.from("cidades")
		.where("id", "=", id.toString())
		.commit();
	}

	public ArrayList<String> getPaises() throws SQLException{
		ResultSet result = this.select("pais")
				.from("cidades").group("pais").groupBy().orderBy("pais").apply();

		ArrayList<String> list = new ArrayList<>();
		while(result.next()) {
			list.add(result.getString("pais"));			
		}
		return list;		
	}

	public ArrayList<String> getEstados(String pais) throws SQLException{
		ResultSet result = this.select("estado")
				.from("cidades").where("pais", "=", "'"+pais+"'").group("estado").groupBy().orderBy("estado").apply();

		ArrayList<String> list = new ArrayList<>();
		while(result.next()) {
			list.add(result.getString("estado"));			
		}
		return list;	
	}

	public ArrayList<String> getCidades(String pais, String estado) throws SQLException{
		ResultSet result = this.select("cidade")
				.from("cidades").filter("estado", "=", "'"+estado+"'").filter("pais", "=", "'"+pais+"'").where().group("cidade").groupBy().orderBy("cidade").apply();

		ArrayList<String> list = new ArrayList<>();
		while(result.next()) {
			list.add(result.getString("cidade"));			
		}
		return list;	
	}

}
