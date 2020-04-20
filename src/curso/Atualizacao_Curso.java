package curso;

import javax.swing.JOptionPane;


public class Atualizacao_Curso {

	public static void main(String[] args) {
		
		Banco_Curso.Select();
		Long paramId = Long.parseLong(JOptionPane.showInputDialog("Entre com o id a ser atualizado: "));
		String paramNome = JOptionPane.showInputDialog("Entre com o novo nome: ");

		Banco_Curso.Update(paramId, paramNome);
		Banco_Curso.Select();
		
	}

}
