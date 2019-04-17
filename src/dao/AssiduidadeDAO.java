package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AssiduidadeDAO extends BaseDAO {
	
	public ResultSet getAllAssiduidades() throws SQLException {
		ResultSet result = null;
		result = this.select("*")
			.from("assiduidade")
			.apply();
		return result;
	}
	
	public ResultSet getOneAssiduidade(Integer id) throws SQLException {
		ResultSet result = null;
		result = this.select("*")
			.from("assiduidade")
			.where("id", "=", id.toString())
			.apply();
		return result;
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
