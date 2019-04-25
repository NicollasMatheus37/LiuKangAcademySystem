package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.AssiduidadeModel;
import model.FaturaMatriculaModel;

public class FaturaMatriculaDAO extends BaseDAO {
	
	public ArrayList<FaturaMatriculaModel> getAllFaturasMatriculas() throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("faturas_matriculas")
			.apply();
		
		
		result.first();
		
		ArrayList<FaturaMatriculaModel> faturaMatriculaList = new ArrayList<FaturaMatriculaModel>();
		while((result.getRow() != 0) && (!result.isAfterLast())) {
			faturaMatriculaList.add(new FaturaMatriculaModel()
					
					.setCodigoMatricula(result.getInt("codigo_matricula"))
					.setDataVencimento(result.getDate("data_vencimento"))
					.setValor(result.getFloat("Valor"))
					.setDataPagamento(result.getDate("data_pagamento"))
					.setDataCancelamento(result.getDate("data_cancelamento"))
					
					);
					result.next();
					}
					return faturaMatriculaList;
	}
	
	public FaturaMatriculaModel getOneFaturaMatricula(Integer id) throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("faturas_matriculas")
			.where("id", "=", id.toString())
			.apply();
		
		FaturaMatriculaModel faturaMatricula = new FaturaMatriculaModel();
		return faturaMatricula.setCodigoMatricula(result.getInt("codigo_matricula"))
						      .setDataVencimento(result.getDate("data_vencimento"))
							  .setValor(result.getFloat("Valor"))
							  .setDataPagamento(result.getDate("data_pagamento"))
							  .setDataCancelamento(result.getDate("data_cancelamento"));
							  
	}
	
	public void createFaturaMatricula(String fields, String values) throws SQLException{
		this.insertInto("faturas_matriculas", fields)
		.values(values)
		.commit();
	}
	
	public void updateFaturaMatricula(String fields, String value, Integer id) throws SQLException{
		this.update("faturas_matriculas")
		.setValue(fields, value)
		.where("id", "=", id.toString())
		.commit();
	}
	
	public void deleteFaturaMatricula(Integer id) throws SQLException{
		this.delete()
		.from("faturas_matriculas")
		.where("id", "=", id.toString())
		.commit();
	}

}
