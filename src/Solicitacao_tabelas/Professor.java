package Solicitacao_tabelas;

import javax.swing.JOptionPane;

import Banco.Banco_Professor;

public class Professor {

	public static void main(String[] args) {

		Integer valor = 0;
		
		do {
			
			valor = Integer.parseInt((JOptionPane.showInputDialog
												(" ---- PROFESSOR ----\n "
												+"1 - SELECT \n "
												+"2 - INSERT\n "
												+"3 - UPDATE\n "
												+"4 - DELETE\n "
												+"5 - SAIR")));
			switch (valor) {
			
				case 1:
					Banco_Professor.Select();
					break; 
					
				case 2:
					
					String paramNome = JOptionPane.showInputDialog("Entre com o nome do Professor: ");
					Banco_Professor.Insert(paramNome);
					Banco_Professor.Select();
					break;
					
				case 3:
					
					Banco_Professor.Select();
					String paramId = JOptionPane.showInputDialog("Entre com o id a ser atualizado: ");
					String paramNomeUpdate = JOptionPane.showInputDialog("Entre com o novo nome: ");
					
					Long id = Long.parseLong(paramId);
					
					Banco_Professor.Update(id, paramNomeUpdate);
					Banco_Professor.Select();
					
					break;
					
				case 4:
					
					Banco_Professor.Select();
					Long paramIdDelete = Long.parseLong(JOptionPane.showInputDialog("Entre com o id: "));
					Banco_Professor.Delete(paramIdDelete);
					Banco_Professor.Select();
					break;

				default: 
					if(valor < 1 || valor > 5) { 
						JOptionPane.showMessageDialog(null, "Foi digitador um CODIGO Invalido");
					}
					break;
			}
			
			
			
		} while( valor != 5 );
		
			JOptionPane.showMessageDialog(null, "Finalizado CRUD - PROFESSOR");	
	

	}

}
