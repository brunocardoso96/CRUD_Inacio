package matricula;

import javax.swing.JOptionPane;

import Controller.Banco_Aluno;
import Controller.Banco_Curso;
import Controller.Banco_Matricula;

public class Atualizacao_Matricula {

	public static void main(String[] args) {

		Banco_Matricula.Select();
		Long paramId = Long.parseLong(JOptionPane.showInputDialog("Entre com o id a ser atualizado: "));
		Banco_Curso.Select();
		Long paramCursoId = Long.parseLong(JOptionPane.showInputDialog("Entre com o novo Curso_id: "));
		Banco_Aluno.Select();
		Long paramAlunoId = Long.parseLong(JOptionPane.showInputDialog("Entre com o novo Aluno_id: "));
		
		Banco_Matricula.Update(paramId, paramCursoId, paramAlunoId);
		
		Banco_Matricula.Select();
		
	}

}
