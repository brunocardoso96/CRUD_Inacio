package Solicitacao_tabelas;

import javax.swing.JOptionPane;

import Banco.Banco_Curso;

public class Curso {

	public static void main(String[] args) {
		
		Integer valor;

		do {
			
			valor = Integer.parseInt((JOptionPane.showInputDialog
												(" ---- CURSO ----\n "
												+"1 - SELECT \n "
												+"2 - INSERT\n "
												+"3 - UPDATE\n "
												+"4 - DELETE\n "
												+"5 - SAIR")));
			switch (valor) {
			
				case 1:
					Banco_Curso.Select();
					break; 
					
				case 2:
					
					String paramNome = JOptionPane.showInputDialog("Entre com o nome do Curso: ");
					Banco.Banco_Professor.Select();
					Integer param_id_professor = Integer.parseInt(JOptionPane.showInputDialog("Entre com o ID o professor: "));
					Banco_Curso.Insert(paramNome, param_id_professor);
					break;
					
				case 3:
					
					Banco_Curso.Select();
					Long paramId = Long.parseLong(JOptionPane.showInputDialog("Entre com o id a ser atualizado: "));
					String paramNomeUpdate = JOptionPane.showInputDialog("Entre com o novo nome: ");
					Banco_Curso.Update(paramId, paramNomeUpdate);
					Banco_Curso.Select();
					break;
					
				case 4:
					
					Banco_Curso.Select();
					String paramIdDelete = JOptionPane.showInputDialog("Entre com o id do curso : ");
					Long id = Long.parseLong(paramIdDelete);
					Banco_Curso.Delete(id);
					Banco_Curso.Select();
					break;

				default: 
					if(valor < 1 || valor > 5) { 
						JOptionPane.showMessageDialog(null, "Foi digitador um CODIGO Invalido");
					}
					break;
			}

		} while( valor != 5 );
		
			JOptionPane.showMessageDialog(null, "Finalizado CRUD CURSO");	
	}

}
