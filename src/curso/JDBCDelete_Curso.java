package curso;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class JDBCDelete_Curso {
 
 
	public static void delete(Long id) {
 
		Connection dbConnection = null;
		PreparedStatement pstmt = null;
		
		String deleteTableSQL = "";  // Sla - id 7 Matricula id 26. 28, 29 curso id 7
 
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
				dbConnection = Conexao_Curso.getDBConnection();
				
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
 
}
