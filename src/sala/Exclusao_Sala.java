package sala;

import javax.swing.JOptionPane;

import Controller.Banco_Sala;

public class Exclusao_Sala {

	public static void main(String[] args) {
		
		Banco_Sala.Select();
		Long paramId = Long.parseLong(JOptionPane.showInputDialog("Entre com o id: "));
		
		Banco_Sala.Delete(paramId);
		Banco_Sala.Select();
	}

}
