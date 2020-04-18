package matricula;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class JDBCDelete_Matricula {
 
 
	public static void delete(Long id) {
 
		Connection dbConnection = null;
		PreparedStatement pstmt = null;
 
		//String deleteTableSQL = "DELETE from EMPLOYEES WHERE EMPLOYEE_ID = ?";
		String deleteTableSQL = "DELETE from escola.matricula WHERE id = ?";
 
		try {
			dbConnection = Conexao_Matricula.getDBConnection();
			
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
