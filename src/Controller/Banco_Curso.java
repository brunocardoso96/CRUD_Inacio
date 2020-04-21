package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Banco_Curso {
	
	static Connection conn = null;
	static Statement stmt = null;
	
	static Connection dbConnection = null;
	static PreparedStatement pstmt = null;
	
	public static void Select() {		
		   try{
				  conn = Conexao_Aluno.getDBConnection();
			      stmt = conn.createStatement();
			      String sql;
			      sql = "SELECT curso.id, curso.nome, professor.nome "
			      		+ "FROM curso, professor "
			      		+ "WHERE professor_id = professor.id "
			      		+ "ORDER BY curso.id asc";
			      
			      ResultSet rs = stmt.executeQuery(sql);

			      while(rs.next()){

			    	  String nome = rs.getString("curso.nome"); 
			    	  String nomeProfessor = rs.getString("professor.nome");
			    	  Long id =	rs.getLong("curso.id");
						 
			    	  System.out.println(id + ": " + nome + ": " + nomeProfessor);
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
	
	public static void Insert(String nome, Integer param_id_professor ) {
		String insertTableSQL = "INSERT INTO escola.curso (nome, professor_id) VALUES (?, ?)";
		 
		try{
			dbConnection = Conexao_Aluno.getDBConnection();
			
			pstmt = dbConnection.prepareStatement(insertTableSQL);
//		    pstmt.setLong(1, id);
//		    pstmt.setString(2, firstName);
//		    pstmt.setString(3, lastName);
//		    pstmt.setString(4, email);
		    
		    pstmt.setString(1, nome);
		    pstmt.setLong(2, param_id_professor);
			
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
		 
		for(int c = 1; c <= 3; c++) {
			
			if(c == 1 ) {
				deleteTableSQL = "DELETE FROM escola.matricula WHERE curso_id = ?";
			}
			if(c == 2 ) {
				deleteTableSQL = "DELETE FROM escola.sala WHERE curso_id = ?";
			}
			if(c == 3 ) {
				deleteTableSQL = "DELETE from escola.curso WHERE id = ?";
			}
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
	
	}
	
	public static void Update(Long id, String novoNome) {
		String updateTableSQL = "UPDATE escola.curso SET nome = ? WHERE id = ?";
		 
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
