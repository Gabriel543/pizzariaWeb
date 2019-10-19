package br.com.senac.pizzariaweb.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.pizzariaweb.modelo.Funcionario;

// classe responsável por fazer as transações com o banco de dados
public class FuncionarioDAO extends DAO {

	private Connection conn;
	
	public FuncionarioDAO() {
		
	}
	
	public int gravar(Funcionario c) throws SQLException {
		abreConexao();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("insert into tb_funcionario(nome, cpf, salario, matricula) values(?, ?, ?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, c.getNome());
			pstmt.setString(2, c.getCpf());
			pstmt.setDouble(3, c.getSalario());
			pstmt.setInt(4, c.getMatricula());
			
			int flag = pstmt.executeUpdate();
			int id;
			if(flag != 0) {				
				rs = pstmt.getGeneratedKeys();
				rs.next();
				id = rs.getInt(1);
			}else {
				throw new SQLException("Erro ao gravar no banco!");
			}
			
			return id;
		} finally {
			if(conn != null) {
				conn.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
		}
	}
	
	private void abreConexao() {
		try {
			conn = getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERRO AO TENTAR ABRIR A CONEXÃO");
		}
	}
	
	public List<Funcionario> listar() throws SQLException {
		abreConexao();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from tb_funcionario");
			
			rs = pstmt.executeQuery();
			System.out.println(pstmt);
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			
			while(rs.next()) { // rs.next() - valida se existe um valor e anda o cursor
				funcionarios.add(criaFuncionario(rs));
			}
			
			return funcionarios;			
		}finally {
			if(conn != null) {
				conn.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
	}
	
	public List<Funcionario> listar(String nome) throws SQLException {
		abreConexao();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from tb_funcionario where nome like ?");
			pstmt.setString(1, nome); ;
			rs = pstmt.executeQuery();
			System.out.println(pstmt);
			
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			
			while(rs.next()) {
				funcionarios.add(criaFuncionario(rs));
			}
			
			return funcionarios;			
		}finally {
			if(conn != null) {
				conn.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
	}

	
	public void deletaFuncionario(int id) throws SQLException{
		abreConexao();
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement("delete from tb_funcionario where id = ?");
			pstmt.setInt(1,id); // bind
			
			int flag = pstmt.executeUpdate();
			if(flag == 0) {
				throw new SQLException("Erro ao excluir o funcionario: " +id + " do banco!");
			}
		}finally {
			if(conn != null) {
				conn.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}
	
	private Funcionario criaFuncionario(ResultSet rs) throws SQLException {
		Funcionario f;
		f = new Funcionario();
		f.setId(rs.getInt(1));
		f.setNome(rs.getString(2));
		f.setCpf(rs.getString(3));
		f.setSalario(rs.getDouble(4));
		f.setMatricula(rs.getInt(5));
		return f;
	}
}