package dao;

public class FaturaMatriculaDAO extends BaseDAO {
	
	public void getAllFaturasMatriculas() {
		this.select("*")
			.from("faturas_matriculas")
			.apply();
	}
	
	public void getOneFaturaMatricula(Integer id) {
		this.select("*")
			.from("faturas_matriculas")
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void createFaturaMatricula(String fields, String values) {
		this.insertInto("faturas_matriculas", fields)
			.values(values)
			.apply();
	}
	
	public void updateFaturaMatricula(String fields, String value, Integer id) {
		this.update("faturas_matriculas")
			.setValue(fields, value)
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void deleteFaturaMatricula(Integer id) {
		this.delete()
			.from("faturas_matriculas")
			.where("id", "=", id.toString());
	}

}
