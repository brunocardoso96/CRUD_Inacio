package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco_Sala {
	

	static Connection conn = null;
	static Statement stmt = null;
	
	static Connection dbConnection = null;
	static PreparedStatement pstmt = null;
	
	public static void Select() {
		 try{
			  conn = Conexao_Aluno.getDBConnection();
		      stmt = conn.createStatement();
		      String sql;
		      //sql = "SELECT EMPLOYEE_ID, FIRST_NAME FROM EMPLOYEES";
		      sql = "Select sala.id, sala.nome, curso.nome \n" + 
		      		"FROM sala, curso\n" + 
		      		"WHERE curso_id = curso.id;";  // Ordernar "ORDER BY sala.nome ASC;"
		      
		      ResultSet rs = stmt.executeQuery(sql);

		      while(rs.next()){
					/*
					  String nome = rs.getString("FIRST_NAME"); 
					  Long id = rs.getLong("EMPLOYEE_ID");
					 */

		    	  String nome = rs.getString("sala.nome"); 
		    	  Long id =	rs.getLong("sala.id");
		    	  String curso_nome =	rs.getString("curso.nome");
					 
		    	  System.out.println(id + ": " + nome + ": " + curso_nome);
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
	
	public static void Insert(String nome, Long curso_id) {
		
		String insertTableSQL = "INSERT INTO escola.sala (nome, curso_id) VALUES (?, ?)";
		 
		try{
			dbConnection = Conexao_Aluno.getDBConnection();
			
			pstmt = dbConnection.prepareStatement(insertTableSQL);
//		    pstmt.setLong(1, id);
//		    pstmt.setString(2, firstName);
//		    pstmt.setString(3, lastName);
//		    pstmt.setString(4, email);
		    
		    pstmt.setString(1, nome);
		    pstmt.setLong(2, curso_id);
			
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
		
		String deleteTableSQL = "DELETE from escola.sala WHERE id = ?";
		 
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
	
	public static void Update(Long id, String novoNome, Long curso_id) {
		String updateTableSQL = "UPDATE escola.sala SET nome = ?, curso_id = ? WHERE id = ?";
		 
		try {
			dbConnection = Conexao_Aluno.getDBConnection();
			
			pstmt = dbConnection.prepareStatement(updateTableSQL);
			
			
		    pstmt.setString(1, novoNome);
		    pstmt.setLong(2, curso_id);
		    pstmt.setLong(3, id);
 
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
