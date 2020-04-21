package aluno;

import javax.swing.JOptionPane;

import Controller.Banco_Aluno;

public class Exclusao_Aluno {

	public static void main(String[] args) {
		
		Banco_Aluno.Select();
		Long paramId = Long.parseLong(JOptionPane.showInputDialog("Entre com o id: "));
		
		Banco_Aluno.Delete(paramId);
		Banco_Aluno.Select();
	}

}
