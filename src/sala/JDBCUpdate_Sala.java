package sala;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class JDBCUpdate_Sala {
 
 
	public static void update(Long id, String novoNome, Long curso_id) {
 
		Connection dbConnection = null;
		PreparedStatement pstmt = null;
 
		//String updateTableSQL = "UPDATE EMPLOYEES SET FIRST_NAME = ? WHERE EMPLOYEE_ID = ?";
		String updateTableSQL = "UPDATE escola.sala SET nome = ?, curso_id = ? WHERE id = ?";
 
		try {
			dbConnection = Conexao_Sala.getDBConnection();
			
			pstmt = dbConnection.prepareStatement(updateTableSQL);
			
			
		    pstmt.setString(1, novoNome);
		    pstmt.setLong(2, curso_id);
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
