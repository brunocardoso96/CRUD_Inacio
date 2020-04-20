package sala;

import javax.swing.JOptionPane;

import curso.Banco_Curso;

public class Inclusao_Sala {

	public static void main(String[] args) {
		
		String paramNome = JOptionPane.showInputDialog("Entre com a Sala");
		Banco_Curso.Select();
		Long paramCurso = Long.parseLong(JOptionPane.showInputDialog("Entre com o Curso"));
		JDBCInsert_Sala.insert(paramNome, paramCurso);
		

	}

}
