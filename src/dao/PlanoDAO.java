package dao;

public class PlanoDAO extends BaseDAO {
	
	public void getAllPlanos() {
		this.select("*")
			.from("planos")
			.apply();
	}
	
	public void getOnePlano(Integer id) {
		this.select("*")
			.from("planos")
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void createPlano(String fields, String values) {
		this.insertInto("planos", fields)
			.values(values)
			.apply();
	}
	
	public void updatePlano(String fields, String value, Integer id) {
		this.update("planos")
			.setValue(fields, value)
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void deletePlano(Integer id) {
		this.delete()
			.from("planos")
			.where("id", "=", id.toString());
	}
	
}
