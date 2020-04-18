package curso;

import javax.swing.JOptionPane;

import curso.JDBCSelect_Curso;
import curso.JDBCUpdate_Curso;

public class Atualizacao_Curso {

	public static void main(String[] args) {
		/*
		String paramId = JOptionPane.showInputDialog("Entre com o id a ser atualizado: ");
		String paramFirstName = JOptionPane.showInputDialog("Entre com o novo primeiro nome: ");
		*/
		JDBCSelect_Curso.getAll();
		String paramId = JOptionPane.showInputDialog("Entre com o id a ser atualizado: ");
		String paramNome = JOptionPane.showInputDialog("Entre com o novo nome: ");
		
		Long id = Long.parseLong(paramId);
		
		JDBCUpdate_Curso.update(id, paramNome);
		JDBCSelect_Curso.getAll();
		
	}

}
