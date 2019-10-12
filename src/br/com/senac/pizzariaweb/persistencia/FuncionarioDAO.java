package br.com.senac.pizzariaweb.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.senac.pizzariaweb.modelo.Funcionario;

// classe responsável por fazer as transações com o banco de dados
public class FuncionarioDAO extends DAO {

	private Connection conn;
	
	public FuncionarioDAO() {
		
	}
	
	public void gravar(Funcionario c) throws SQLException {
		try {
			conn = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERRO AO TENTAR ABRIR A CONEXÃO");
		}
		

		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("insert into tb_funcionario(nome, cpf, salario, matricula) values(?, ?, ?,?)");
			
			pstmt.setString(1, c.getNome());
			pstmt.setString(2, c.getCpf());
			pstmt.setDouble(3, c.getSalario());
			pstmt.setInt(4, c.getMatricula());
			
			int flag = pstmt.executeUpdate();
			

			if(flag == 0) {
				throw new SQLException("Erro ao gravar no banco!");
			}
		} finally {
			if(conn != null) {
				conn.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
		}
	}
}