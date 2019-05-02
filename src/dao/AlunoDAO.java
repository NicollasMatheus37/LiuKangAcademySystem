package dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.AlunoModel;

public class AlunoDAO extends BaseDAO {

	public ArrayList<AlunoModel> getAllAlunos() throws SQLException {
		ResultSet result = null;
		result = this.select("*")
				.from("alunos")
				.apply();
		ArrayList<AlunoModel> alunoList = new ArrayList<AlunoModel>();
		while(result.next()) {
			alunoList.add(new AlunoModel()
					.setAluno(result.getString("aluno"))
					.setBairro(result.getString("bairro"))
					.setCelular(result.getString("celular"))
					.setCep(result.getString("cep"))
					.setCidade(result.getString("cidade"))
					.setCodigoAluno(result.getInt("codigo_aluno"))
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

		}
		return alunoList;
	}

	public AlunoModel getOneAluno(Integer id) throws SQLException {
		ResultSet result = null;
		result = this.select("*")
				.from("alunos")
				.where("codigo_aluno", "=", id.toString())
				.apply();
		
		if(result.next()) {
			AlunoModel aluno = new AlunoModel();
			return aluno.setAluno(result.getString("aluno"))
					.setBairro(result.getString("bairro"))
					.setCelular(result.getString("celular"))
					.setCep(result.getString("cep"))
					.setCidade(result.getString("cidade"))
					.setCodigoAluno(result.getInt("codigo_aluno"))
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
		}else {
			return null;
		}
	}

	public void createAluno(AlunoModel aluno) throws SQLException {
		String fields = "aluno, bairro, celular, cep, cidade, complemento, "+ ((aluno.getDataNascimentoDate().compareTo(new Date(0))==0)? "" : "data_nascimento, ") +"email, endereco, " +
				"estado, numero, observacao, pais, sexo, telefone";
		this.insertInto("alunos", fields)
		.values("('"+
				aluno.getAluno()+"','"+
				aluno.getBairro()+"','"+
				aluno.getCelular()+"','"+
				aluno.getCep()+"','"+
				aluno.getCidade()+"','"+
				aluno.getComplemento()+"','"+
				((aluno.getDataNascimentoDate().compareTo(new Date(0))==0)? "" : (aluno.getDataNascimento()+"','"))+
				aluno.getEmail()+"','"+
				aluno.getEndereco()+"','"+
				aluno.getEstado()+"','"+
				aluno.getNumero()+"','"+
				aluno.getObservacao()+"','"+
				aluno.getPais()+"','"+
				aluno.getSexo()+"','"+
				aluno.getTelefone()+"')"
				)
		.commit();
	}

	public void updateAluno(AlunoModel aluno) throws SQLException {
		this.update("alunos")
		.setValue(
				"aluno = '"+aluno.getAluno()+"' "+
						", bairro = '"+aluno.getBairro()+"' "+
						", celular = '"+aluno.getCelular()+"' "+
						", cep = '"+aluno.getCep()+"' "+
						", cidade = '"+ aluno.getCidade()+"' "+
						", complemento = '"+aluno.getComplemento()+
						((aluno.getDataNascimentoDate().compareTo(new Date(0))==0)? "' '" : ("', data_nascimento = '"+aluno.getDataNascimento()+"' "))+
						", email = '"+aluno.getEmail()+"' "+
						", endereco = '"+aluno.getEndereco()+"' "+
						", estado = '"+aluno.getEstado()+"' "+
						", numero = '"+aluno.getNumero()+"' "+
						", observacao = '"+aluno.getObservacao()+"' "+
						", pais = '"+aluno.getPais()+"' "+
						", sexo = '"+aluno.getSexo()+"' "+
						", telefone = '"+aluno.getTelefone()+"' "
				)
		.where("codigo_aluno", "=", Integer.toString((aluno.getcodigoAluno())))
		.commit();
	}

	public void deleteAluno(Integer id) throws SQLException {
		this.delete()
		.from("alunos")
		.where("codigo_aluno", "=", id.toString())
		.commit();
	}

}
