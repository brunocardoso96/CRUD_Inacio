package aluno;

import javax.swing.JOptionPane;

import Controller.Banco_Aluno;

public class Atualizacao_Aluno {

	public static void main(String[] args) {

		Banco_Aluno.Select();
		Long paramId = Long.parseLong(JOptionPane.showInputDialog("Entre com o id a ser atualizado: "));
		String paramNome = JOptionPane.showInputDialog("Entre com o novo nome: ");
		
		Banco_Aluno.Update(paramId, paramNome);
		Banco_Aluno.Select();
		
	}

}
