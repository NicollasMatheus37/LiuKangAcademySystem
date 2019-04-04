package dao;

import java.util.Map;
import model.AlunoModel;

public class AlunoDAO extends BaseDAO {

	public void getAllAlunos() {
		this.select("*")
			.from("alunos")
			.apply();
	}
	
	public void getOneAluno(Integer id) {
		this.select("*")
			.from("alunos")
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void createAluno(String fields, String values) {
		this.insertInto("alunos", fields)
			.values(values)
			.apply();
	}
	
	public void updateAluno(String fields, String value, Integer id) {
		this.update("alunos")
			.setValue(fields, value)
			.where("id", "=", id.toString())
			.apply();
	}
	
	public void deleteAluno(Integer id) {
		this.delete()
			.from("alunos")
			.where("id", "=", id.toString());
	}
	
}
