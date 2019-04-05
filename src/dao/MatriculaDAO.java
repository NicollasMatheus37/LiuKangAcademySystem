package dao;

public class MatriculaDAO extends BaseDAO {
	
	public void getAllMatriculas() {
		this.select("*")
			.from("matriculas")
			.apply();
	}
	
	public void getOneMatricula(Integer id) {
		this.select("*")
			.from("matriculas")
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void createMatricula(String fields, String values) {
		this.insertInto("matriculas", fields)
			.values(values)
			.apply();
	}
	
	public void updateMatricula(String fields, String value, Integer id) {
		this.update("matriculas")
			.setValue(fields, value)
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void deleteMatricula(Integer id) {
		this.delete()
			.from("matriculas")
			.where("id", "=", id.toString());
	}
	
}
