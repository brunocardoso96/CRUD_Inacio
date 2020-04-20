package curso;

import javax.swing.JOptionPane;

public class Exclusao_Curso {

	public static void main(String[] args) {
		
		Banco_Curso.Select();
		String paramId = JOptionPane.showInputDialog("Entre com o id do curso : ");
		
		Long id = Long.parseLong(paramId);
		
		Banco_Curso.Delete(id);
		Banco_Curso.Select();
	}

}
