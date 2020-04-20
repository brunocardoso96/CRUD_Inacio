package curso;

import javax.swing.JOptionPane;

import professor.Banco_Professor;

public class Inclusao_Curso {

	public static void main(String[] args) {
		
		String paramNome = JOptionPane.showInputDialog("Entre com o nome do Curso: ");
		professor.Banco_Professor.Select();
		Integer param_id_professor = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID o professor: "));
		
		Banco_Curso.Insert(paramNome, param_id_professor);
	}

}
