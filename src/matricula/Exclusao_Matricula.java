package matricula;

import javax.swing.JOptionPane;

public class Exclusao_Matricula {

	public static void main(String[] args) {
		
		Banco_Matricula.Select();
		Long paramId = Long.parseLong(JOptionPane.showInputDialog("Entre com o id da Matricula: "));
		
		Banco_Matricula.Delete(paramId);
		Banco_Matricula.Select();
	}

}
