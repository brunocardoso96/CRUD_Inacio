package matricula;

import javax.swing.JOptionPane;

import aluno.Banco_Aluno;
import curso.JDBCSelect_Curso;
import matricula.JDBCSelect_Matricula;
import matricula.JDBCUpdate_Matricula;

public class Atualizacao_Matricula {

	public static void main(String[] args) {
		/*
		String paramId = JOptionPane.showInputDialog("Entre com o id a ser atualizado: ");
		String paramFirstName = JOptionPane.showInputDialog("Entre com o novo primeiro nome: ");
		*/
		JDBCSelect_Matricula.getAll();
		String paramId = JOptionPane.showInputDialog("Entre com o id a ser atualizado: ");
		JDBCSelect_Curso.getAll();
		Long paramCursoId = Long.parseLong(JOptionPane.showInputDialog("Entre com o novo Curso_id: "));
		Banco_Aluno.Select();
		Long paramAlunoId = Long.parseLong(JOptionPane.showInputDialog("Entre com o novo Aluno_id: "));
		
		Long id = Long.parseLong(paramId);
		
		JDBCUpdate_Matricula.update(id, paramCursoId, paramAlunoId);
		JDBCSelect_Matricula.getAll();
		
	}

}
