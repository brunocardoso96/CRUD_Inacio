package matricula;

import javax.swing.JOptionPane;

import Controller.Banco_Aluno;
import Controller.Banco_Curso;
import Controller.Banco_Matricula;

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
		Banco_Matricula.Insert(paramCursoId, paramAlunoId);
		Banco_Matricula.Select();
	}

}
