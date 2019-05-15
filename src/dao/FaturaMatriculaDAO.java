package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.FaturaMatriculaModel;

public class FaturaMatriculaDAO extends BaseDAO {
	
	public ArrayList<FaturaMatriculaModel> getAllFaturasMatriculas(Integer matricula) throws SQLException{
		ResultSet result = null;
		if(matricula > 0) {
			result = this.select("*")
					.from("faturas_matriculas")
					.apply();
		}else {
			result = this.select("*")
					.from("faturas_matriculas")
					.where("codigo_matricula", "=", matricula.toString())
					.apply();
			
		}
		
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
	
	public FaturaMatriculaModel getOneFaturaMatricula(Integer matricula, String vencimento) throws SQLException{
		ResultSet result = null;
		result = this.select("*")
			.from("faturas_matriculas")
			.filter("codigo_matricula", "=", matricula.toString())
			.filter("data_vencimento", "=", quoteStr(vencimento))
			.where()
			.apply();
		
		FaturaMatriculaModel faturaMatricula = new FaturaMatriculaModel();
		return faturaMatricula.setCodigoMatricula(result.getInt("codigo_matricula"))
						      .setDataVencimento(result.getDate("data_vencimento"))
							  .setValor(result.getFloat("valor"))
							  .setDataPagamento(result.getDate("data_pagamento"))
							  .setDataCancelamento(result.getDate("data_cancelamento"));
							  
	}
	
	public void createFaturaMatricula(FaturaMatriculaModel faturaMatricula) throws SQLException{
		String fields = "codigo_matricula, data_vencimento, valor, data_pagamento, data_cancelamento, situacao";
		this.insertInto("faturas_matriculas", fields)
		.values(
				Integer.toString(faturaMatricula.getCodigoMatricula())+","+
				quoteStr(faturaMatricula.getDataVencimento())+","+
				Float.toString(faturaMatricula.getValor())+","+
				quoteStr(faturaMatricula.getDataPagamento())+","+
				quoteStr(faturaMatricula.getDataCancelamento())+","+
				quoteStr(faturaMatricula.getSituacao())
				)
		.commit();
	}
	
	public void updateFaturaMatricula(FaturaMatriculaModel faturaMatricula, Integer id) throws SQLException{
		this.update("faturas_matriculas")
		.setValue(
				  "codigo_matricula = "+faturaMatricula.getCodigoMatricula()+
				  "data_vencimento = "+quoteStr(faturaMatricula.getDataVencimento())+
				  "valor = "+faturaMatricula.getValor()+
				  "data_pagamento = "+quoteStr(faturaMatricula.getDataPagamento())+
				  "data_cancelamento = "+quoteStr(faturaMatricula.getDataCancelamento())+
				  "situacao = "+quoteStr(faturaMatricula.getSituacao())
				 )
		.where("id", "=", id.toString())
		.commit();
	}
	
	public void deleteFaturaMatricula(Integer matricula, String vencimento) throws SQLException{
		this.delete()
		.from("faturas_matriculas")
		.filter("codigo_matricula", "=", matricula.toString())
		.filter("data_vencimento", "=", quoteStr(vencimento))
		.where()
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
