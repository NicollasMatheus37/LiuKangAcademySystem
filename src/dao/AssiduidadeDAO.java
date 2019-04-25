package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.AssiduidadeModel;

public class AssiduidadeDAO extends BaseDAO {
	
 	public ArrayList<AssiduidadeModel> getAllAssiduidades() throws SQLException {
		ResultSet result = null;
		result = this.select("*")
			.from("assiduidade")
			.apply();

		result.first();
		
		ArrayList<AssiduidadeModel> assiduidadeList = new ArrayList<AssiduidadeModel>();
		while((result.getRow() != 0) && (!result.isAfterLast())) {
			assiduidadeList.add(new AssiduidadeModel()
					
					.setCodigoMatricula(result.getInt("codigo_matricula"))
					.setDataEntrada(result.getDate("data_entrada"))
					);
					result.next();
					}
					return assiduidadeList;
				
	}
	
	public AssiduidadeModel getOneAssiduidade(Integer id) throws SQLException {
		ResultSet result = null;
		result = this.select("*")
			.from("assiduidade")
			.where("id", "=", id.toString())
			.apply();
		
		AssiduidadeModel assiduidade = new AssiduidadeModel();
		return assiduidade.setCodigoMatricula(result.getInt("codigo_matricula"))
						  .setDataEntrada(result.getDate("data_entrada"));
						 
					
	}
	
	public void createAssiduidade(String fields, String values) throws SQLException {
		this.insertInto("assiduidade", fields)
			.values(values)
			.apply();
	}
	
	public void updateAssiduidade(String fields, String value, Integer id) throws SQLException {
		this.update("assiduidade")
		.setValue(fields, value)
		.where("id", "=", id.toString())
		.commit();;
	}
	
	public void deleteAssiduidade(Integer id) throws SQLException{
		this.delete()
		.from("assiduidade")
		.where("id", "=", id.toString())
		.commit();
	}

	
}
