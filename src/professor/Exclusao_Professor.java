package professor;

import javax.swing.JOptionPane;

import Controller.Banco_Professor;

public class Exclusao_Professor {

	public static void main(String[] args) {
		
		Banco_Professor.Select();
		Long paramId = Long.parseLong(JOptionPane.showInputDialog("Entre com o id: "));
		
		Banco_Professor.Delete(paramId);
		Banco_Professor.Select();
	}

}
