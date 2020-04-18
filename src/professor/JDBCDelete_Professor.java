package professor;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
public class JDBCDelete_Professor {
 
 
	public static void delete(Long id) {
 
		Connection dbConnection = null;
		PreparedStatement pstmt = null;
		
		String deleteTableSQL = "";
		
			for(int c = 1; c <= 4; c++) {
				
				if(c == 1) {
					// Delete matricula
					deleteTableSQL = "DELETE FROM escola.matricula where curso_id = Any (SELECT curso.id FROM curso WHERE professor_id = ?)";
				}
				if(c == 2) {
					//DELETE sala
					deleteTableSQL = "DELETE FROM escola.sala where curso_id = Any (SELECT curso.id FROM curso WHERE professor_id = ?)";
				}
				if(c == 3) {
					//DELETE curso
					deleteTableSQL = "DELETE FROM escola.curso WHERE professor_id = ?";
				}
				if(c == 4) {
					//DELETE Professor
					deleteTableSQL = "DELETE FROM escola.professor WHERE id = ?";
				}
	
			try {
				dbConnection = Conexao_Professor.getDBConnection();
				
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
