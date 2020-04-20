package matricula;

import javax.swing.JOptionPane;

import aluno.Banco_Aluno;
import curso.Banco_Curso;
import matricula.JDBCInsert_Matricula;
import matricula.JDBCSelect_Matricula;

public class Inclusao_Matricula {

	public static void main(String[] args) {
		/*
		String paramId = JOptionPane.showInputDialog("Entre com o id: ");
		String paramFirstName = JOptionPane.showInputDialog("Entre com o primeiro nome: ");
		String paramLastName = JOptionPane.showInputDialog("Entre com o último nome: ");
		String paramEmail = JOptionPane.showInputDialog("Entre com o email: ");
		Long id = Long.parseLong(paramId);
		JDBCInsert.insert(id, paramFirstName, paramLastName, paramEmail);
		*/
		
		Banco_Curso.Select();
		Long paramCursoId = (long) Integer.parseInt(JOptionPane.showInputDialog("Entre com o id do curso: "));
		Banco_Aluno.Select();
		Long paramAlunoId = (long) Integer.parseInt(JOptionPane.showInputDialog("Entre com o id do aluno: "));
		JDBCInsert_Matricula.insert(paramCursoId, paramAlunoId);
		matricula.JDBCSelect_Matricula.getAll();
	}

}
