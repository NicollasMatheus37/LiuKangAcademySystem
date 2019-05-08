package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.FaturaMatriculaModel;
import model.MatriculaModel;

public class FaturaMatriculaDAO extends BaseDAO {
	
	public ArrayList<FaturaMatriculaModel> getAllFaturasMatriculas() throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("faturas_matriculas")
			.apply();
		
		ArrayList<FaturaMatriculaModel> faturaMatriculaList = new ArrayList<FaturaMatriculaModel>();
		while(result.next()) {
			faturaMatriculaList.add(new FaturaMatriculaModel()
					
					.setCodigoMatricula(result.getInt("codigo_matricula"))
					.setDataVencimento(result.getDate("data_vencimento"))
					.setValor(result.getFloat("Valor"))
					.setDataPagamento(result.getDate("data_pagamento"))
					.setDataCancelamento(result.getDate("data_cancelamento"))
					
					);
					
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
							  .setValor(result.getFloat("valor"))
							  .setDataPagamento(result.getDate("data_pagamento"))
							  .setDataCancelamento(result.getDate("data_cancelamento"));
							  
	}
	
	public void createFaturaMatricula(FaturaMatriculaModel faturaMatricula) throws SQLException{
		String fields = "codigo_matricula, data_vencimento, valor, data_pagamento, data_cancelamento";
		this.insertInto("faturas_matriculas", fields)
		.values(
				Integer.toString(faturaMatricula.getCodigoMatricula())+","+
				faturaMatricula.getDataVencimento()+","+
				Float.toString(faturaMatricula.getValor())+","+
				faturaMatricula.getDataPagamento()+","+
				faturaMatricula.getDataCancelamento()
				)
		.commit();
	}
	
	public void updateFaturaMatricula(FaturaMatriculaModel faturaMatricula, Integer id) throws SQLException{
		this.update("faturas_matriculas")
		.setValue(
				  "codigo_matricula = "+faturaMatricula.getCodigoMatricula()+
				  "data_vencimento = "+faturaMatricula.getDataVencimento()+
				  "valor = "+faturaMatricula.getValor()+
				  "data_pagamento = "+faturaMatricula.getDataPagamento()+
				  "data_cancelamento = "+faturaMatricula.getDataCancelamento()				
				 )
		.where("id", "=", id.toString())
		.commit();
	}
	
	public void deleteFaturaMatricula(Integer id) throws SQLException{
		this.delete()
		.from("faturas_matriculas")
		.where("id", "=", id.toString())
		.commit();
	}
	

 	public ArrayList<FaturaMatriculaModel> getFromCustomSql(String sql) throws SQLException {
		ResultSet result = null;
		result = this.customSql(sql).apply();
		ArrayList<FaturaMatriculaModel> faturaMatriculaList = new ArrayList<FaturaMatriculaModel>();
			while(result.next()) {
				faturaMatriculaList.add(new FaturaMatriculaModel()
						.setCodigoMatricula(result.getInt("codigo_matricula"))
						.setDataVencimento(result.getDate("data_vencimento"))
						.setValor(result.getFloat("Valor"))
						.setDataPagamento(result.getDate("data_pagamento"))
						.setDataCancelamento(result.getDate("data_cancelamento"))
					);
			}
			
		return faturaMatriculaList;
	}

}
