package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AssiduidadeModel;
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
	
	public void createCidade(String fields, String values) throws SQLException {
		this.insertInto("cidades", fields)
		.values(values)
		.commit();
	}
	
	public void updateCidade(String fields, String value, Integer id) throws SQLException {
		this.update("cidades")
		.setValue(fields, value)
		.where("id", "=", id.toString())
		.commit();
	}
	
	public void deleteCidade(Integer id) throws SQLException{
		this.delete()
		.from("cidades")
		.where("id", "=", id.toString())
		.commit();
	}
	
}
