package dao;

public class MatriculaModalidadeDAO extends BaseDAO {
	
	public void getAllMatriculasModalidades() {
		this.select("*")
			.from("matriculas_modalidades")
			.apply();
	}
	
	public void getOneMatriculaModalidade(Integer id) {
		this.select("*")
			.from("matriculas_modalidades")
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void createMatriculaModalidade(String fields, String values) {
		this.insertInto("matriculas_modalidades", fields)
			.values(values)
			.apply();
	}
	
	public void updateMatriculaModalidade(String fields, String value, Integer id) {
		this.update("matriculas_modalidades")
			.setValue(fields, value)
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void deleteMatriculaModalidade(Integer id) {
		this.delete()
			.from("matriculas_modalidades")
			.where("id", "=", id.toString());
	}

}
