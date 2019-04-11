package dao;

import java.sql.SQLException;

public class teste {
	
	public static void main(String args[]) throws SQLException {
		
		AlunoDAO aluno = null;
		String vrau = "";
		vrau = aluno.getAllAlunos().toString();
		System.out.println(vrau);
	}
}
