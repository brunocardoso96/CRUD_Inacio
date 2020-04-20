package curso;

import javax.swing.JOptionPane;

public class Inclusao_Curso {

	public static void main(String[] args) {
		
		String paramNome = JOptionPane.showInputDialog("Entre com o nome do Curso: ");
		professor.JDBCSelect_Professor.getAll();
		Integer param_id_professor = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID o professor: "));
		
		Banco_Curso.Insert(paramNome, param_id_professor);
	}

}
