package sala;

import javax.swing.JOptionPane;

import curso.JDBCSelect_Curso;

public class Inclusao_Sala {

	public static void main(String[] args) {
		/*
		String paramId = JOptionPane.showInputDialog("Entre com o id: ");
		String paramFirstName = JOptionPane.showInputDialog("Entre com o primeiro nome: ");
		String paramLastName = JOptionPane.showInputDialog("Entre com o último nome: ");
		String paramEmail = JOptionPane.showInputDialog("Entre com o email: ");
		Long id = Long.parseLong(paramId);
		JDBCInsert.insert(id, paramFirstName, paramLastName, paramEmail);
		*/
		
		String paramNome = JOptionPane.showInputDialog("Entre com a Sala");
		JDBCSelect_Curso.getAll();
		Long paramCurso = Long.parseLong(JOptionPane.showInputDialog("Entre com o Curso"));
		JDBCInsert_Sala.insert(paramNome, paramCurso);
		

	}

}
