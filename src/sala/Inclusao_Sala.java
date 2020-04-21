package sala;

import javax.swing.JOptionPane;

import Controller.Banco_Curso;
import Controller.Banco_Sala;

public class Inclusao_Sala {

	public static void main(String[] args) {
		
		String paramNome = JOptionPane.showInputDialog("Entre com a Sala");
		Banco_Curso.Select();
		Long paramCurso = Long.parseLong(JOptionPane.showInputDialog("Entre com o Curso"));
		
		Banco_Sala.Insert(paramNome, paramCurso);
		

	}

}
