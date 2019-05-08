package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.PlanoModel;

public class PlanoDAO extends BaseDAO {

	public ArrayList<PlanoModel> getAllPlanos(String modalidade) throws SQLException{
		ResultSet result = null;
		if(modalidade.trim().isEmpty()) {
			result = this.select("*")
					.from("planos")
					.apply();
		}else {
			result = this.select("*")
					.from("planos")
					.where("modalidade", "=", quoteStr(modalidade))
					.apply();
		}

		ArrayList<PlanoModel> planoList = new ArrayList<PlanoModel>();
		while(result.next()) {
			planoList.add(new PlanoModel()
					.setModalidade(result.getString("modalidade"))
					.setPlano(result.getString("plano"))
					.setValorMensal(result.getFloat("valor_mensal"))
					);
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
				.setPlano(result.getString("planos"))
				.setValorMensal(result.getFloat("valor_mensal"));

	}

	public void createPlano(PlanoModel plano) throws SQLException{
		String fields = "modalidade, plano, valor_mensal";
		this.insertInto("planos", fields)
		.values(
				quoteStr(plano.getModalidade())+","+
				quoteStr(plano.getPlano())+","+
				Float.toString(plano.getValorMensal())
				)
		.commit();
	}

	public void updatePlano(PlanoModel plano, PlanoModel oldPlano) throws SQLException{
		this.update("planos")
		.setValue(
				"modalidade = "+quoteStr(plano.getModalidade())+","+
				"plano = "+quoteStr(plano.getPlano())+","+
				"valor_mensal = "+plano.getValorMensal()
				)
		.filter("modalidade", "=", quoteStr(oldPlano.getModalidade()))
		.filter("plano", "=", quoteStr(oldPlano.getPlano()))		
		.where()
		.apply();
	}

	public void deletePlano(PlanoModel plano) throws SQLException{
		this.delete()
		.from("planos")
		.filter("plano", "=", quoteStr(plano.getPlano()))
		.filter("modalidade", "=", quoteStr(plano.getModalidade()))
		.where()
		.commit();
	}

}
