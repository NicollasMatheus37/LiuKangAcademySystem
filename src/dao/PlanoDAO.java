package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AssiduidadeModel;
import model.PlanoModel;

public class PlanoDAO extends BaseDAO {
	
	public ArrayList<PlanoModel> getAllPlanos() throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("planos")
			.apply();
		
		result.first();
		
		ArrayList<PlanoModel> planoList = new ArrayList<PlanoModel>();
		while((result.getRow() != 0) && (!result.isAfterLast())) {
			planoList.add(new PlanoModel()
					.setModalidade(result.getString("modalidade"))
					.setPlano(result.getString("plano"))
					.setValorMensal(result.getFloat("valor_mensal"))
					);
					result.next();
					}
					return planoList;
	}
	
	public PlanoModel getOnePlano(Integer id) throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("planos")
			.where("id", "=", id.toString())
			.apply();

		PlanoModel plano = new PlanoModel();
		return plano.setModalidade(result.getString("modalidade"))
				.setPlano(result.getString("plano"))
				.setValorMensal(result.getFloat("valor_mensal"));
		
	}
	
	public void createPlano(String fields, String values) throws SQLException{
		this.insertInto("planos", fields)
		.values(values)
		.commit();
	}
	
	public void updatePlano(String fields, String value, Integer id) throws SQLException{
		this.update("planos")
			.setValue(fields, value)
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void deletePlano(Integer id) throws SQLException{
		this.delete()
		.from("planos")
		.where("id", "=", id.toString())
		.commit();
	}
	
}
