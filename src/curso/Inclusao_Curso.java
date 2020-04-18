package curso;

import javax.swing.JOptionPane;

import curso.JDBCInsert_Curso;
import curso.JDBCSelect_Curso;

public class Inclusao_Curso {

	public static void main(String[] args) {
		/*
		String paramId = JOptionPane.showInputDialog("Entre com o id: ");
		String paramFirstName = JOptionPane.showInputDialog("Entre com o primeiro nome: ");
		String paramLastName = JOptionPane.showInputDialog("Entre com o último nome: ");
		String paramEmail = JOptionPane.showInputDialog("Entre com o email: ");
		Long id = Long.parseLong(paramId);
		JDBCInsert.insert(id, paramFirstName, paramLastName, paramEmail);
		*/
		
		String paramNome = JOptionPane.showInputDialog("Entre com o nome do Curso: ");
		professor.JDBCSelect_Professor.getAll();
		Integer param_id_professor = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID o professor: "));
		JDBCInsert_Curso.insert(paramNome, param_id_professor);
	}

}
