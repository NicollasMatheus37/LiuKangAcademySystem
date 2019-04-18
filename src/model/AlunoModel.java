package model;

import java.util.Date;
import java.util.Map;

public class AlunoModel {

	private int codigoAluno;	
	private String aluno; 
	private Date dataNascimento;
	private char sexo;
	private String telefone;
	private String celular;
	private String email;
	private String observacao;
	private String endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String pais;
	private String cep;


	public int getcodigoAluno() {
		return codigoAluno;
	}
	public AlunoModel setCodigoAluno(int codigo_aluno) {
		codigo_aluno = this.codigoAluno;	
		return this;
	}

	public String getAluno() {
		return aluno;
	}
	public AlunoModel setAluno(String aluno) {
		this.aluno = aluno;
		return this;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public AlunoModel setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
	}
	public char getSexo() {
		return sexo;
	}
	public AlunoModel setSexo(char sexo) {
		this.sexo = sexo;
		return this;
	}
	public String getTelefone() {
		return telefone;
	}
	public AlunoModel setTelefone(String telefone) {
		this.telefone = telefone;
		return this;
	}
	public String getCelular() {
		return celular;
	}
	public AlunoModel setCelular(String celular) {
		this.celular = celular;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public AlunoModel setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getObservacao() {
		return observacao;
	}
	public AlunoModel setObservacao(String observacao) {
		this.observacao = observacao;
		return this;
	}
	public String getEndereco() {
		return endereco;
	}
	public AlunoModel setEndereco(String endereco) {
		this.endereco = endereco;
		return this;
	}
	public String getNumero() {
		return numero;
	}
	public AlunoModel setNumero(String numero) {
		this.numero = numero;
		return this;
	}
	public String getComplemento() {
		return complemento;
	}
	public AlunoModel setComplemento(String complemento) {
		this.complemento = complemento;
		return this;
	}
	public String getBairro() {
		return bairro;
	}
	public AlunoModel setBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}
	public String getCidade() {
		return cidade;
	}
	public AlunoModel setCidade(String cidade) {
		this.cidade = cidade;
		return this;
	}
	public String getEstado() {
		return estado;
	}
	public AlunoModel setEstado(String estado) {
		this.estado = estado;
		return this;
	}
	public String getPais() {
		return pais;
	}
	public AlunoModel setPais(String pais) {
		this.pais = pais;
		return this;
	}
	public String getCep() {
		return cep;
	}
	public AlunoModel setCep(String cep) {
		this.cep = cep;
		return this;
	}

}
