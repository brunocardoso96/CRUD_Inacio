package professor;

import javax.swing.JOptionPane;

import professor.JDBCSelect_Professor;
import professor.JDBCUpdate_Professor;

public class Atualizacao_Professor {

	public static void main(String[] args) {
		/*
		String paramId = JOptionPane.showInputDialog("Entre com o id a ser atualizado: ");
		String paramFirstName = JOptionPane.showInputDialog("Entre com o novo primeiro nome: ");
		*/
		JDBCSelect_Professor.getAll();
		String paramId = JOptionPane.showInputDialog("Entre com o id a ser atualizado: ");
		String paramNome = JOptionPane.showInputDialog("Entre com o novo nome: ");
		
		Long id = Long.parseLong(paramId);
		
		JDBCUpdate_Professor.update(id, paramNome);
		JDBCSelect_Professor.getAll();
		
	}

}
