package dao;

import java.sql.SQLException;

public class CidadeDAO extends BaseDAO {

	public void getAllCidades() throws SQLException {
		this.select("*")
			.from("cidades")
			.apply();
	}
	
	public void getOneCidade(Integer id) throws SQLException {
		this.select("*")
			.from("cidades")
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void createCidade(String fields, String values) throws SQLException {
		this.insertInto("cidades", fields)
			.values(values)
			.apply();
	}
	
	public void updateCidade(String fields, String value, Integer id) throws SQLException {
		this.update("cidades")
			.setValue(fields, value)
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void deleteCidade(Integer id) {
		this.delete()
			.from("cidades")
			.where("id", "=", id.toString());
	}
	
}
