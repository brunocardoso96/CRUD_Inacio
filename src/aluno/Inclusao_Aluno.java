package aluno;

import javax.swing.JOptionPane;

public class Inclusao_Aluno {

	public static void main(String[] args) {
		
		String paramNome = JOptionPane.showInputDialog("Entre com o nome do aluno: ");
		Banco_Aluno.Insert(paramNome);
		Banco_Aluno.Select();
	}
}