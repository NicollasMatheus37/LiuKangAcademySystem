package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class teste {
	
	public static void main(String args[]) throws SQLException {
		
		AlunoDAO aluno = new AlunoDAO();
		String vrau = "";
		
		ResultSet rst = aluno.getAllAlunos();
		
		while (rst.next()) {
			System.out.println(rst.getString("aluno"));
		}
		
		
	}
}
