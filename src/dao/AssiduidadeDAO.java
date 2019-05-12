package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.AssiduidadeModel;

public class AssiduidadeDAO extends BaseDAO {

	public ArrayList<AssiduidadeModel> getAllAssiduidades(Integer id, String dataIni, String dataFin) throws SQLException {
		ResultSet result = null;
		if(dataIni.isEmpty()) {
			result = this.select("*")
					.from("assiduidade")
					.where("codigo_matricula", "=", id.toString())
					.orderBy("data_entrada")
					.apply();
		}else {
			result = this.select("*")
					.from("assiduidade")
					.filter("codigo_matricula", "=", id.toString())
					.filter("data_entrada", "between", " '"+dataIni+"' and '"+dataFin+"' ")
					.where()
					.orderBy("data_entrada")
					.apply();
		}

		ArrayList<AssiduidadeModel> assiduidadeList = new ArrayList<AssiduidadeModel>();
		while(result.next()) {
			assiduidadeList.add(new AssiduidadeModel()
					.setCodigoMatricula(result.getInt("codigo_matricula"))
					.setDataEntrada(result.getDate("data_entrada"))					
					);
		}
		return assiduidadeList;

	}

	public AssiduidadeModel getOneAssiduidade(Integer id) throws SQLException {
		ResultSet result = null;
		result = this.select("*")
				.from("assiduidade")
				.where("codigo_matricula", "=", id.toString())
				.apply();

		AssiduidadeModel assiduidade = new AssiduidadeModel();
		return assiduidade.setCodigoMatricula(result.getInt("codigo_matricula"))
				.setDataEntrada(result.getDate("data_entrada"));


	}

	public void createAssiduidade(AssiduidadeModel assiduidade) throws SQLException {

		String fields = "codigo_matricula, data_entrada";
		this.insertInto("assiduidade", fields)
		.values(
				Integer.toString(assiduidade.getCodigoMatricula())+","+
						quoteStr(assiduidade.getDataEntrada())
				)
		.commit();
	}

	public void updateAssiduidade(AssiduidadeModel assiduidade, Integer id) throws SQLException {
		this.update("assiduidade")

		.setValue(
				"codigo_matricula = "+ assiduidade.getCodigoMatricula()+
				"data_entrega = "+quoteStr(assiduidade.getDataEntrada())
				)

		.where("codigo_matricula", "=", id.toString())
		.commit();;
	}

	public void deleteAssiduidade(Integer id) throws SQLException{
		this.delete()
		.from("assiduidade")
		.where("codigo_matricula", "=", id.toString())
		.commit();
	}


}
