package professor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSelect_Professor {
   
   public static void getAll() {
	   
	   Connection conn = null;
	   Statement stmt = null;
	   try{
		  conn = Conexao_Professor.getDBConnection();
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
   
   public static void main(String[] args) throws SQLException {
	   getAll();
   }
}