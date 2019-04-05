package dao;

public class GraduacaoDAO extends BaseDAO {
	
	public void getAllGraduacoes() {
		this.select("*")
			.from("graduacoes")
			.apply();
	}
	
	public void getOneGraduacao(Integer id) {
		this.select("*")
			.from("graduacoes")
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void createGraduacao(String fields, String values) {
		this.insertInto("graduacoes", fields)
			.values(values)
			.apply();
	}
	
	public void updateGraduacao(String fields, String value, Integer id) {
		this.update("graduacoes")
			.setValue(fields, value)
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void deleteGraduacao(Integer id) {
		this.delete()
			.from("graduacoes")
			.where("id", "=", id.toString());
	}

}
