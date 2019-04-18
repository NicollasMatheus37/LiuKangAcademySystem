package dao;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import model.AlunoModel;

public class AlunoDAO extends BaseDAO {

	public ArrayList getAllAlunos() throws SQLException {
		ResultSet result = null;
		result = this.select("*")
			.from("alunos")
			.apply();
		result.first();
		ArrayList<AlunoModel> alunoList = new ArrayList<AlunoModel>();
		while((result.getRow() != 0) && (!result.isAfterLast())) {
			alunoList.add(new AlunoModel()
						.setAluno(result.getString("aluno"))
						.setBairro(result.getString("bairro"))
						.setCelular(result.getString("celular"))
						.setCep(result.getString("cep"))
						.setCidade(result.getString("cidade"))
						.setCodigoAluno(result.getInt("codigo"))
						.setComplemento(result.getString("complemento"))
						.setDataNascimento(result.getDate("data_nascimento"))
						.setEmail(result.getString("email"))
						.setEndereco(result.getString("endereco"))
						.setEstado(result.getString("estado"))
						.setNumero(result.getString("numero"))
						.setObservacao(result.getString("observacao"))
						.setPais(result.getString("pais"))
						.setSexo((result.getString("sexo").charAt(0)))
						.setTelefone(result.getString("telefone"))
						);
			result.next();
		}
		return alunoList;
	}
	
	public AlunoModel getOneAluno(Integer id) throws SQLException {
		ResultSet result = null;
		result = this.select("*")
			.from("alunos")
			.where("id", "=", id.toString())
			.apply();
		
		AlunoModel aluno = new AlunoModel();
		return aluno.setAluno(result.getString("aluno"))
					.setBairro(result.getString("bairro"))
					.setCelular(result.getString("celular"))
					.setCep(result.getString("cep"))
					.setCidade(result.getString("cidade"))
					.setCodigoAluno(result.getInt("codigoAluno"))
					.setComplemento(result.getString("complemento"))
					.setDataNascimento(result.getDate("data_nascimento"))
					.setEmail(result.getString("email"))
					.setEndereco(result.getString("endereco"))
					.setEstado(result.getString("estado"))
					.setNumero(result.getString("numero"))
					.setObservacao(result.getString("observacao"))
					.setPais(result.getString("pais"))
					.setSexo((result.getString("sexo").charAt(0)))
					.setTelefone(result.getString("telefone"));
	}
	
	public void createAluno(String fields, String values) throws SQLException {
		this.insertInto("alunos", fields)
			.values(values)
			.commit();
	}
	
	public void updateAluno(String fields, String value, Integer id) throws SQLException {
		this.update("alunos")
			.setValue(fields, value)
			.where("id", "=", id.toString())
			.commit();
	}
	
	public void deleteAluno(Integer id) throws SQLException {
		this.delete()
			.from("alunos")
			.where("id", "=", id.toString())
			.commit();
	}
	
}
