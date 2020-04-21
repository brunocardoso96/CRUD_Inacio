package sala;

import javax.swing.JOptionPane;

import Controller.Banco_Curso;
import Controller.Banco_Sala;

public class Atualizacao_Sala {

	public static void main(String[] args) {
		/*
		String paramId = JOptionPane.showInputDialog("Entre com o id a ser atualizado: ");
		String paramFirstName = JOptionPane.showInputDialog("Entre com o novo primeiro nome: ");
		*/
		Banco_Sala.Select();
		Long paramId = Long.parseLong(JOptionPane.showInputDialog("Entre com o id a ser atualizado: "));
		String paramNome = JOptionPane.showInputDialog("Entre com a nova Sala: ");
		Banco_Curso.Select();
		Long paramCurso = Long.parseLong(JOptionPane.showInputDialog("Entre com a novo Curso: "));

		Banco_Sala.Update(paramId, paramNome, paramCurso);
		Banco_Sala.Select();
		
	}

}
