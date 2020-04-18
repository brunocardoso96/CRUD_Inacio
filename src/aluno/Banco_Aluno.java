package aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco_Aluno {
	
	//Select
	static Connection conn = null;
	static Statement stmt = null;
	
	static Connection dbConnection = null;
	static PreparedStatement pstmt = null;
	
	//Metodos do Aluno
	
	public static void Select() {

		   try{
			  conn = Conexao_Aluno.getDBConnection();
		      stmt = conn.createStatement();
		      String sql;
		      //sql = "SELECT EMPLOYEE_ID, FIRST_NAME FROM EMPLOYEES";
		      sql = "SELECT id, nome FROM aluno";
		      
		      ResultSet rs = stmt.executeQuery(sql);

		      while(rs.next()){
					/*
					  String nome = rs.getString("FIRST_NAME"); 
					  Long id = rs.getLong("EMPLOYEE_ID");
					 */

		    	  String nome = rs.getString("nome"); 
		    	  Long id =	rs.getLong("id");
					 
		    	  System.out.println(id + ": " + nome);
		      }
		      
		      rs.close();
		      stmt.close();
		      conn.close();
		      
		   } catch (SQLException e) {
			   throw new RuntimeException(e.getMessage());
		   }finally{
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
	   
		
	}
	
	public static void Insert(String nome) {
		
		String insertTableSQL = "INSERT INTO escola.aluno (nome) VALUES (?)";
		 
		try{
			dbConnection = Conexao_Aluno.getDBConnection();
			
			pstmt = dbConnection.prepareStatement(insertTableSQL);
		    pstmt.setString(1, nome);
			
		    pstmt.executeUpdate();
 
			System.out.println("Registro foi inserido na tabela!");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
 
		} finally {
 
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
 
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void Delete(Long id) {
		
		String deleteTableSQL = "DELETE FROM escola.aluno WHERE id = ?";
 
		try {
			dbConnection = Conexao_Aluno.getDBConnection();
			
			pstmt = dbConnection.prepareStatement(deleteTableSQL);
		    pstmt.setLong(1, id);
		    pstmt.execute();
 
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
			
 
		} finally {
 
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
 
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void Update(Long id, String novoNome) {

 
		//String updateTableSQL = "UPDATE EMPLOYEES SET FIRST_NAME = ? WHERE EMPLOYEE_ID = ?";
		String updateTableSQL = "UPDATE escola.aluno SET nome = ? WHERE id = ?";
 
		try {
			dbConnection = Conexao_Aluno.getDBConnection();
			
			pstmt = dbConnection.prepareStatement(updateTableSQL);
			
			
		    pstmt.setString(1, novoNome);
		    pstmt.setLong(2, id);
 
			// execute update SQL stetement
			pstmt.execute();
 
			System.out.println("Registro foi atualizado na tabela!");
 
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
 
		} finally {
 
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
 
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
 
		}
 
	
	}
}
