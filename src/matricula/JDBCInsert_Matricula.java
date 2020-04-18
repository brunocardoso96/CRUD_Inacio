package matricula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class JDBCInsert_Matricula {
	
	//public static void insert(Long id, String firstName, String lastName, String email) {
	public static void insert(Long curso_id, Long aluno_id) {
		 
		Connection dbConnection = null;
		PreparedStatement pstmt = null;
		
 
		/*
		 String insertTableSQL = "INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL) VALUES (?,?,?,?)";
		 */
		
		String insertTableSQL = "INSERT INTO escola.matricula (curso_id, aluno_id) VALUES (?, ?)";
 
		try{
			dbConnection = Conexao_Matricula.getDBConnection();
			
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
}
