package aluno;

import javax.swing.JOptionPane;

import Controller.Banco_Aluno;

public class Selecao_Aluno {

	public static void main(String[] args) {
		
		Integer valor = 0;
		
		do {
			
			valor = Integer.parseInt((JOptionPane.showInputDialog(" ---- ALUNO ----\n "
												+"1 - SELECT \n "
												+"2 - INSERT\n "
												+"3 - UPDATE\n "
												+"4 - DELETE\n "
												+"5 - SAIR")));
			
			switch (valor) {
			
				case 1:
					Banco_Aluno.Select();
					break; 
					
				case 2:
					
					String paramNome = JOptionPane.showInputDialog("Entre com o nome do aluno: ");
					Banco_Aluno.Insert(paramNome);
					Banco_Aluno.Select();
					break;
					
				case 3:
					
					Banco_Aluno.Select();
					Long paramId = Long.parseLong(JOptionPane.showInputDialog("Entre com o id a ser atualizado: "));
					String paramNomeSelect = JOptionPane.showInputDialog("Entre com o novo nome: ");
					
					Banco_Aluno.Update(paramId, paramNomeSelect);
					Banco_Aluno.Select();
					break;
					
				case 4:
					
					Banco_Aluno.Select();
					Long paramIdSelect = Long.parseLong(JOptionPane.showInputDialog("Entre com o id: "));
					
					Banco_Aluno.Delete(paramIdSelect);
					Banco_Aluno.Select();
					break;
					
				case 5:
					
					break;
					
				default: 
					if(valor < 1 || valor > 5) { 
						JOptionPane.showMessageDialog(null, "Foi digitador um CODIGO Invalido");
					}
					break;
			}
			
		} while( valor != 5 );
		
			JOptionPane.showMessageDialog(null, "Finalizado CRUD ALUNO");	
	}

}
