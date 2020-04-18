package matricula;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSelect_Matricula {
   
   public static void getAll() {
	   
	   Connection conn = null;
	   Statement stmt = null;
	   try{
		  conn = Conexao_Matricula.getDBConnection();
	      stmt = conn.createStatement();
	      String sql;
	      //sql = "SELECT EMPLOYEE_ID, FIRST_NAME FROM EMPLOYEES";
	      sql = "SELECT matricula.id, curso.nome, aluno.nome "
	      		+ "FROM matricula, curso, aluno "
	      		+ "WHERE curso.id = curso_id "
	      		+ "AND aluno.id = aluno_id "; // Ordernar + "ORDER BY curso.nome ASC "
	      
	      ResultSet rs = stmt.executeQuery(sql);

	      while(rs.next()){
				/*
				  String nome = rs.getString("FIRST_NAME"); 
				  Long id = rs.getLong("EMPLOYEE_ID");
				 */

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
   
   public static void main(String[] args) throws SQLException {
	   getAll();
   }
}