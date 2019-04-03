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
	
	public void createAluno(String values) {
		this.insertInto("alunos", values);
	}
	
}
