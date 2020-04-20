package professor;

import javax.swing.JOptionPane;

public class Atualizacao_Professor {

	public static void main(String[] args) {
		/*
		String paramId = JOptionPane.showInputDialog("Entre com o id a ser atualizado: ");
		String paramFirstName = JOptionPane.showInputDialog("Entre com o novo primeiro nome: ");
		*/
		Banco_Professor.Select();
		String paramId = JOptionPane.showInputDialog("Entre com o id a ser atualizado: ");
		String paramNome = JOptionPane.showInputDialog("Entre com o novo nome: ");
		
		Long id = Long.parseLong(paramId);
		
		Banco_Professor.Update(id, paramNome);
		Banco_Professor.Select();
		
	}

}
