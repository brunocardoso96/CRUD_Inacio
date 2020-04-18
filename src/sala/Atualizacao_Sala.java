package sala;

import javax.swing.JOptionPane;

import curso.JDBCSelect_Curso;

public class Atualizacao_Sala {

	public static void main(String[] args) {
		/*
		String paramId = JOptionPane.showInputDialog("Entre com o id a ser atualizado: ");
		String paramFirstName = JOptionPane.showInputDialog("Entre com o novo primeiro nome: ");
		*/
		JDBCSelect_Sala.getAll();
		Long paramId = Long.parseLong(JOptionPane.showInputDialog("Entre com o id a ser atualizado: "));
		String paramNome = JOptionPane.showInputDialog("Entre com a nova Sala: ");
		JDBCSelect_Curso.getAll();
		Long paramCurso = Long.parseLong(JOptionPane.showInputDialog("Entre com a novo Curso: "));

		
		JDBCUpdate_Sala.update(paramId, paramNome, paramCurso);
		JDBCSelect_Sala.getAll();
		
	}

}
