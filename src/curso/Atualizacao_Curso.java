package curso;

import javax.swing.JOptionPane;


public class Atualizacao_Curso {

	public static void main(String[] args) {
		/*
		String paramId = JOptionPane.showInputDialog("Entre com o id a ser atualizado: ");
		String paramFirstName = JOptionPane.showInputDialog("Entre com o novo primeiro nome: ");
		*/
		Banco_Curso.Select();
		String paramId = JOptionPane.showInputDialog("Entre com o id a ser atualizado: ");
		String paramNome = JOptionPane.showInputDialog("Entre com o novo nome: ");
		
		Long id = Long.parseLong(paramId);
		
		Banco_Curso.Update(id, paramNome);
		Banco_Curso.Select();
		
	}

}
