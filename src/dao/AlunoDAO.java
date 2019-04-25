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
					.setTelefone(result.getString("telefone"));
	}
	
	public void createAluno(AlunoModel aluno) throws SQLException {
		String fields = "aluno, bairro, celular, cep, cidade, codigo, complemento, data_nascimento, email, endereco, " +
	"estado, numero, observacao, pais, sexo, telefone";
		this.insertInto("alunos", fields)
			.values(
					aluno.getAluno()+","+
					aluno.getBairro()+","+
					aluno.getCelular()+","+
					aluno.getCep()+","+
					aluno.getCidade()+","+
					Integer.toString(aluno.getcodigoAluno())+","+
					aluno.getComplemento()+","+
					aluno.getEmail()+","+
					aluno.getEndereco()+","+
					aluno.getEstado()+","+
					aluno.getNumero()+","+
					aluno.getObservacao()+","+
					aluno.getPais()+","+
					aluno.getSexo()+","+
					aluno.getTelefone()+","+
					aluno.getDataNascimento())
			.commit();
	}
	
	public void updateAluno(AlunoModel aluno, Integer id) throws SQLException {
		this.update("alunos")
			.setValue(
					"aluno = "+aluno.getAluno()+
					", bairro = "+aluno.getBairro()+
					", celular = "+aluno.getCelular()+
					", cep = "+aluno.getCep()+
					", cidade = "+ aluno.getCidade()+
					", codigo = "+aluno.getcodigoAluno()+
					", complemento = "+aluno.getComplemento()+
					", data_nascimento = "+aluno.getDataNascimento()+
					", email = "+aluno.getEmail()+
					", endereco = "+aluno.getEndereco()+
					", estado = "+aluno.getEstado()+
					", numero = "+aluno.getNumero()+
					", observacao = "+aluno.getObservacao()+
					", pais = "+aluno.getPais()+
					", sexo = "+aluno.getSexo()+
					", telefone = "+aluno.getTelefone()
					)
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
