package matricula;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class JDBCUpdate_Matricula {
 
 
	public static void update(Long id, Long curso_id, Long aluno_id) {
 
		Connection dbConnection = null;
		PreparedStatement pstmt = null;
 
		//String updateTableSQL = "UPDATE EMPLOYEES SET FIRST_NAME = ? WHERE EMPLOYEE_ID = ?";
		String updateTableSQL = "UPDATE escola.matricula SET curso_id = ?, aluno_id = ? WHERE id = ?";
 
		try {
			dbConnection = Conexao_Matricula.getDBConnection();
			
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
