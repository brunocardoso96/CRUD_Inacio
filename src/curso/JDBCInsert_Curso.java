package curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class JDBCInsert_Curso {
	
	//public static void insert(Long id, String firstName, String lastName, String email) {
	public static void insert(String nome, Integer param_id_professor) {
		 
		Connection dbConnection = null;
		PreparedStatement pstmt = null;
		
 
		/*
		 String insertTableSQL = "INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL) VALUES (?,?,?,?)";
		 */
		
		String insertTableSQL = "INSERT INTO escola.curso (nome, professor_id) VALUES (?, ?)";
 
		try{
			dbConnection = Conexao_Curso.getDBConnection();
			
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
}