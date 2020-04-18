package sala;

import javax.swing.JOptionPane;

public class Exclusao_Sala {

	public static void main(String[] args) {
		
		JDBCSelect_Sala.getAll();
		String paramId = JOptionPane.showInputDialog("Entre com o id: ");
		
		Long id = Long.parseLong(paramId);
		
		JDBCDelete_Sala.delete(id);
		JDBCSelect_Sala.getAll();
	}

}
