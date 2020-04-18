package matricula;

import javax.swing.JOptionPane;

import matricula.JDBCDelete_Matricula;
import matricula.JDBCSelect_Matricula;

public class Exclusao_Matricula {

	public static void main(String[] args) {
		
		JDBCSelect_Matricula.getAll();
		String paramId = JOptionPane.showInputDialog("Entre com o id da Matricula: ");
		
		Long id = Long.parseLong(paramId);
		
		JDBCDelete_Matricula.delete(id);
		JDBCSelect_Matricula.getAll();
	}

}
