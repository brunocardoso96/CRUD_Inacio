package curso;

import javax.swing.JOptionPane;

import curso.JDBCDelete_Curso;
import curso.JDBCSelect_Curso;

public class Exclusao_Curso {

	public static void main(String[] args) {
		
		JDBCSelect_Curso.getAll();
		String paramId = JOptionPane.showInputDialog("Entre com o id do curso : ");
		
		Long id = Long.parseLong(paramId);
		
		JDBCDelete_Curso.delete(id);
		JDBCSelect_Curso.getAll();
	}

}
