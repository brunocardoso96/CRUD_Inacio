package professor;

import javax.swing.JOptionPane;

import professor.JDBCDelete_Professor;
import professor.JDBCSelect_Professor;

public class Exclusao_Professor {

	public static void main(String[] args) {
		
		JDBCSelect_Professor.getAll();
		Long paramId = Long.parseLong(JOptionPane.showInputDialog("Entre com o id: "));
		
		JDBCDelete_Professor.delete(paramId);
		JDBCSelect_Professor.getAll();
	}

}
