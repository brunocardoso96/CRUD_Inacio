package Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco_Professor {

	static Connection conn = null;
	static Statement stmt = null;
	
	static Connection dbConnection = null;
	static PreparedStatement pstmt = null;
	
	public static void Select() {
		
		try{
			  conn = Conexao_Banco.getDBConnection();
		      stmt = conn.createStatement();
		      
		      String sql = "SELECT id, nome FROM escola.professor";
		      
		      ResultSet rs = stmt.executeQuery(sql);

		      while(rs.next()){
		    	  
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
		String insertTableSQL = "INSERT INTO escola.professor (nome) VALUES (?)";
		 
		try{
			dbConnection = Conexao_Banco.getDBConnection();
			
			pstmt = dbConnection.prepareStatement(insertTableSQL);
//		    pstmt.setLong(1, id);
//		    pstmt.setString(2, firstName);
//		    pstmt.setString(3, lastName);
//		    pstmt.setString(4, email);
		    
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
		
		String deleteTableSQL = "";
		
		for(int c = 1; c <= 4; c++) {
			
			if(c == 1) {
				// Delete matricula
				deleteTableSQL = "DELETE FROM escola.matricula where curso_id = Any (SELECT curso.id FROM curso WHERE professor_id = ?)";
			}
			if(c == 2) {
				//DELETE sala
				deleteTableSQL = "DELETE FROM escola.sala where curso_id = Any (SELECT curso.id FROM curso WHERE professor_id = ?)";
			}
			if(c == 3) {
				//DELETE curso
				deleteTableSQL = "DELETE FROM escola.curso WHERE professor_id = ?";
			}
			if(c == 4) {
				//DELETE Professor
				deleteTableSQL = "DELETE FROM escola.professor WHERE id = ?";
			}

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
	

	}
	
	public static void Update(Long id, String novoNome) {
		
		String updateTableSQL = "UPDATE escola.professor SET nome = ? WHERE id = ?";
		 
		try {
			dbConnection = Conexao_Banco.getDBConnection();
			
			pstmt = dbConnection.prepareStatement(updateTableSQL);
			
			
		    pstmt.setString(1, novoNome);
		    pstmt.setLong(2, id);
 
			// execute update SQL stetement
			pstmt.execute();
 
			System.out.println("");
			System.out.println("");
			System.out.println("Registro foi atualizado na tabela!");
			System.out.println("");
			System.out.println("");
 
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
