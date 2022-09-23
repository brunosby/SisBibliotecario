package bdbiblioteca;

import java.util.Scanner;

public class BibliotecaTeste {
	public static void main(String[] args) {
		BDbiblioteca bancoDeDados = new BDbiblioteca();
		bancoDeDados.conectar();
		if(bancoDeDados.estaConectado()) {
			Scanner entrada = new Scanner(System.in);
			int opc;
			
			System.out.println("Bem vindo ao sistema bibliotecario!");
			System.out.println("1- Cadastrar livro");
			System.out.println("2- Listar Livros");
			System.out.println("3- Editar Livro");
			System.out.println("4- Alugar Livro");
			System.out.println("5- Devolver Livro");
			System.out.println("6- Excluir Livro");
			System.out.println("7- Cadastrar Editora");
			System.out.println("8- Listar Editora");
			System.out.println("9- Editar Editora");
			System.out.println("10- Excluir Editora");
			System.out.println("0- Sair do programa");
			
			System.out.println("Insira a operacao que deseja: ");
			opc = entrada.nextInt();
			entrada.nextLine();
			
			while(opc != 0) {
				Livro l = new Livro();
				Editora e = new Editora();
				switch(opc) {
				case 1: 
					System.out.println("Insira o nome do livro que deseja cadastrar: ");
					l.setNomelivro(entrada.nextLine());
					System.out.println("Insira o id da editora que deseja cadastrar: ");
					e.setIdEditora(entrada.nextInt());
					entrada.nextLine();
					l.setEditora(e);
					bancoDeDados.cadastrarLivro(l);
					System.out.println("Livro cadastrado!");
					break;
				case 2: 
					System.out.println("-------Livros Cadastrados-------");
					bancoDeDados.listarLivros();
					break;
				case 3: 
					System.out.println("Insira o id do livro que deseja alterar: ");
					l.setIdLivro(entrada.nextInt());
					entrada.nextLine();
					System.out.println("Insira o novo titulo: ");
					l.setNomelivro(entrada.nextLine());
					bancoDeDados.editarLivro(l);
					break;
				case 4: 
					System.out.println("Insira o id dos livros que deseja alugar (0 para sair): ");
					l.setIdLivro(entrada.nextInt());
					entrada.nextLine();
					while(l.getIdLivro() != 0) {
						bancoDeDados.alugarLivro(l);
						l.setIdLivro(entrada.nextInt());
						entrada.nextLine();
					}
					break;
				case 5: 
					System.out.println("Insira o id dos livros que deseja alugar (0 para sair): ");
					l.setIdLivro(entrada.nextInt());
					entrada.nextLine();
					while(l.getIdLivro() != 0) {
						bancoDeDados.devolverLivro(l);
						l.setIdLivro(entrada.nextInt());
						entrada.nextLine();
					}
					break;
				case 6: 
					System.out.println("Insira o id do livro que deseja excluir: ");
					l.setIdLivro(entrada.nextInt());
					entrada.nextLine();
					bancoDeDados.apagarLivro(l);
					break;
				case 7: 
					System.out.println("Insira o nome da editora: ");
					e.setNomeEditora(entrada.nextLine());
					System.out.println("Insira o telefone da editora: ");
					e.setTelEditora(entrada.nextLine());
					System.out.println("Insira o endereco da editora: ");
					e.setEndEditora(entrada.nextLine());
					bancoDeDados.cadastrarEditora(e);
					break;
				case 8: 
					System.out.println("-------Editoras Cadastradas-------");
					bancoDeDados.listarEditora();
					break;
				case 9:
					System.out.println("Insira o id da editora que deseja atualizar: ");
					e.setIdEditora(entrada.nextInt());
					entrada.nextLine();
					System.out.println("Insira o nome da editora: ");
					e.setNomeEditora(entrada.nextLine());
					System.out.println("Insira o telefone da editora: ");
					e.setTelEditora(entrada.nextLine());
					System.out.println("Insira o endereco da editora: ");
					e.setEndEditora(entrada.nextLine());
					bancoDeDados.editarEditora(e);
					break;
				case 10:
					System.out.println("Insira o id da editora que deseja excluir: ");
					e.setIdEditora(entrada.nextInt());
					entrada.nextLine();
					bancoDeDados.apagarEditora(e);
					break;
				default:
					System.out.println("Opcao invalida! Insira novamente.");
					break;
				}
				System.out.println("1- Cadastrar livro");
				System.out.println("2- Listar Livros");
				System.out.println("3- Editar Livro");
				System.out.println("4- Alugar Livro");
				System.out.println("5- Devolver Livro");
				System.out.println("6- Excluir Livro");
				System.out.println("7- Cadastrar Editora");
				System.out.println("8- Listar Editora");
				System.out.println("9- Editar Editora");
				System.out.println("10- Excluir Editora");
				System.out.println("0- Sair do programa");
				
				System.out.println("Insira a opracao que deseja: ");
				opc = entrada.nextInt();
				entrada.nextLine();
			}
			
			System.out.println("Finalizando Programa...");
			entrada.close();
		}
		else {
			System.out.println("Não foi possível conectar");
		}
	}
}
