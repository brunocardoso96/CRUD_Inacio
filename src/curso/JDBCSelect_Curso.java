package curso;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSelect_Curso {
   
   public static void getAll() {
	   
	   Connection conn = null;
	   Statement stmt = null;
	   try{
		  conn = Conexao_Curso.getDBConnection();
	      stmt = conn.createStatement();
	      String sql;
	      //sql = "SELECT EMPLOYEE_ID, FIRST_NAME FROM EMPLOYEES";
	      sql = "SELECT curso.id, curso.nome, professor.nome "
	      		+ "FROM curso, professor "
	      		+ "WHERE professor_id = professor.id";
	      
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
   
   public static void main(String[] args) throws SQLException {
	   getAll();
   }
}