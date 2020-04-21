package professor;

import javax.swing.JOptionPane;

import Controller.Banco_Professor;

public class Inclusao_Porfessor {

	public static void main(String[] args) {
		/*
		String paramId = JOptionPane.showInputDialog("Entre com o id: ");
		String paramFirstName = JOptionPane.showInputDialog("Entre com o primeiro nome: ");
		String paramLastName = JOptionPane.showInputDialog("Entre com o último nome: ");
		String paramEmail = JOptionPane.showInputDialog("Entre com o email: ");
		Long id = Long.parseLong(paramId);
		JDBCInsert.insert(id, paramFirstName, paramLastName, paramEmail);
		*/
		
		String paramNome = JOptionPane.showInputDialog("Entre com o nome do Professor: ");
		Banco_Professor.Insert(paramNome);
		Banco_Professor.Select();
	}

}
