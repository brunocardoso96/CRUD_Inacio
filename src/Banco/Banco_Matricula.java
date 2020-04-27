package Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Banco_Matricula {
	
	static Connection conn = null;
	static Statement stmt = null;
	
	static Connection dbConnection = null;
	static PreparedStatement pstmt = null;
	
	
	public static void Select() {
		
		try{
			  conn = Conexao_Banco.getDBConnection();
		      stmt = conn.createStatement();
		      
		      String sql;
		     
		      sql = "SELECT matricula.id, curso.nome, aluno.nome "
		      		+ "FROM matricula, curso, aluno "
		      		+ "WHERE curso.id = curso_id "
		      		+ "AND aluno.id = aluno_id "; // Ordernar + "ORDER BY curso.nome ASC "
		      
		      ResultSet rs = stmt.executeQuery(sql);

		      while(rs.next()){

		    	  String id = rs.getString("id"); 
		    	  String curso_nome =	rs.getString("curso.nome");
		    	  String aluno_nome =	rs.getString("aluno.nome");
					 
		    	  System.out.println(id + ": " + curso_nome + ": " + aluno_nome);
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
	
	public static void Insert(Long curso_id, Long aluno_id) {
		
		
		String insertTableSQL = "INSERT INTO escola.matricula (curso_id, aluno_id) VALUES (?, ?)";
 
		try{
			dbConnection = Conexao_Banco.getDBConnection();
			
			pstmt = dbConnection.prepareStatement(insertTableSQL);
//		    pstmt.setLong(1, id);
//		    pstmt.setString(2, firstName);
//		    pstmt.setString(3, lastName);
//		    pstmt.setString(4, email);
		    
		    pstmt.setLong(1, curso_id);
		    pstmt.setLong(2, aluno_id);
			
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
		
		String deleteTableSQL = "DELETE from escola.matricula WHERE id = ?";
		 
		try {
			dbConnection = Conexao_Banco.getDBConnection();
			
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
	
	public static void Update(Long id, Long curso_id, Long aluno_id) {
		String updateTableSQL = "UPDATE escola.matricula SET curso_id = ?, aluno_id = ? WHERE id = ?";
		 
		try {
			dbConnection = Conexao_Banco.getDBConnection();
			
			pstmt = dbConnection.prepareStatement(updateTableSQL);
			
			
		    pstmt.setLong(1, curso_id);
		    pstmt.setLong(2, aluno_id);
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
