package dao;

public class CidadeDAO extends BaseDAO {

	public void getAllCidades() {
		this.select("*")
			.from("cidades")
			.apply();
	}
	
	public void getOneCidade(Integer id) {
		this.select("*")
			.from("cidades")
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void createCidade(String fields, String values) {
		this.insertInto("cidades", fields)
			.values(values)
			.apply();
	}
	
	public void updateCidade(String fields, String value, Integer id) {
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
