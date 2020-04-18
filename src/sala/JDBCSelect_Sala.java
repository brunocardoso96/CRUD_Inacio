package sala;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSelect_Sala {
   
   public static void getAll() {
	   
	   Connection conn = null;
	   Statement stmt = null;
	   try{
		  conn = Conexao_Sala.getDBConnection();
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
   
   public static void main(String[] args) throws SQLException {
	   getAll();
   }
}