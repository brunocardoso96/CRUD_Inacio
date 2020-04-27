package Solicitacao_tabelas;

import javax.swing.JOptionPane;

import Banco.Banco_Curso;
import Banco.Banco_Sala;

public class Sala {

	public static void main(String[] args) {
		
		
		
		Integer valor = 0;
		
		do {
			
			valor = Integer.parseInt((JOptionPane.showInputDialog
												(" ---- SALA ----\n "
												+"1 - SELECT \n "
												+"2 - INSERT\n "
												+"3 - UPDATE\n "
												+"4 - DELETE\n "
												+"5 - SAIR")));
			switch (valor) {
			
				case 1:
					
					Banco_Sala.Select();
					break; 
					
				case 2:
					
					String paramNome = JOptionPane.showInputDialog("Entre com a Sala");
					Banco_Curso.Select();
					Long paramCurso = Long.parseLong(JOptionPane.showInputDialog("Entre com o Curso"));
					Banco_Sala.Insert(paramNome, paramCurso);					
					break;
					
				case 3:
					
					Banco_Sala.Select();
					Long paramId = Long.parseLong(JOptionPane.showInputDialog("Entre com o id a ser atualizado: "));
					String paramNomeUpdate = JOptionPane.showInputDialog("Entre com a nova Sala: ");
					Banco_Curso.Select();
					Long paramCursoUpdate = Long.parseLong(JOptionPane.showInputDialog("Entre com a novo Curso: "));
					Banco_Sala.Update(paramId, paramNomeUpdate, paramCursoUpdate);
					Banco_Sala.Select();					
					break;
					
				case 4:
					
					Banco_Sala.Select();
					Long paramIdDelete = Long.parseLong(JOptionPane.showInputDialog("Entre com o id: "));
					Banco_Sala.Delete(paramIdDelete);
					Banco_Sala.Select();
					break;

				default: 
					if(valor < 1 || valor > 5) { JOptionPane.showMessageDialog(null, "Foi digitador um CODIGO Invalido");}
					break;
			}
			
			
			
		} while( valor != 5 );
		
			JOptionPane.showMessageDialog(null, "Finalizado CRUD - PROFESSOR");	
	

	

	}

}
