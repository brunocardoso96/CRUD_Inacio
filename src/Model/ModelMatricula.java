package Model;

import javax.swing.JOptionPane;

import Controller.Banco_Aluno;
import Controller.Banco_Curso;
import Controller.Banco_Matricula;

//import br.com.inaciojr9.bancosimples.banco.JDBCSelect;

public class ModelMatricula {

	public static void main(String[] args) {

		Integer valor;

		do {
			
			valor = Integer.parseInt((JOptionPane.showInputDialog
												(" ---- MATRICULA ----\n "
												+"1 - SELECT \n "
												+"2 - INSERT\n "
												+"3 - UPDATE\n "
												+"4 - DELETE\n "
												+"5 - SAIR")));
			switch (valor) {
			
				case 1:
					
					Banco_Matricula.Select();
					break; 
					
				case 2:
					
					Banco_Curso.Select();
					Long paramCursoId = (long) Integer.parseInt(JOptionPane.showInputDialog("Entre com o id do curso: "));
					Banco_Aluno.Select();
					Long paramAlunoId = (long) Integer.parseInt(JOptionPane.showInputDialog("Entre com o id do aluno: "));
					Banco_Matricula.Insert(paramCursoId, paramAlunoId);
					Banco_Matricula.Select();
					break;
					
				case 3:
					
					Banco_Matricula.Select();
					Long paramId = Long.parseLong(JOptionPane.showInputDialog("Entre com o id a ser atualizado: "));
					Banco_Curso.Select();
					Long paramCursoIdUpdate = Long.parseLong(JOptionPane.showInputDialog("Entre com o novo Curso_id: "));
					Banco_Aluno.Select();
					Long paramAlunoIdUpdate = Long.parseLong(JOptionPane.showInputDialog("Entre com o novo Aluno_id: "));
					Banco_Matricula.Update(paramId, paramCursoIdUpdate, paramAlunoIdUpdate);
					Banco_Matricula.Select();
					break;
					
				case 4:
					
					Banco_Matricula.Select();
					Long paramIdDelete = Long.parseLong(JOptionPane.showInputDialog("Entre com o id da Matricula: "));
					Banco_Matricula.Delete(paramIdDelete);
					Banco_Matricula.Select();
					
					break;

				default: 
					if(valor < 1 || valor > 5) { 
						JOptionPane.showMessageDialog(null, "Foi digitador um CODIGO Invalido");
					}
					break;
			}

		} while( valor != 5 );
		
			JOptionPane.showMessageDialog(null, "Finalizado CRUD - MATRICULA");	
	}


}
