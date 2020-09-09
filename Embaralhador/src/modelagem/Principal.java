package modelagem;

import java.io.IOException;
import java.util.Scanner;



public class Principal {
	static Scanner input;
	static int score = 0;
	
	public static void main(String[] args) throws IOException {
		BancoDePalavras bp = new BancoDePalavras();
		bp.bancoDePalavrasIniciais();
		FabricaEmbaralhadores em = new FabricaEmbaralhadores();
		Mecânica m = new Mecânica();
		boolean teste;
		int tentativas;
		input = new Scanner(System.in);
		
		System.out.println("MENU: ");
		System.out.println("1. Desenvolvedor MODE");
		System.out.println("2. Jogar!");
		System.out.println("3. Sair");
		System.out.print("Digite sua opção: ");
		String opçãoMenu = input.next();
		
		switch (opçãoMenu) {
		case "1":
			System.out.println("1. Adicionar palavras");
			System.out.println("2. Remover palavras");
			System.out.print("Digite sua opção: ");
			String opção = input.next();
			switch (opção) {
				case "1":
					System.out.print("Digite qual palavra você deseja adicionar: ");
					String novaPalavra = input.nextLine();
					System.out.print("Deseja adicionar a dificuldade da palavra?: ");
					String dificuldade = input.next();
					if(dificuldade.equals("") || dificuldade == null) {
						Palavra palavra = new Palavra(novaPalavra.toLowerCase());
						bp.adicionaPalavrasNoBanco(palavra);
					} else {
						Palavra palavra = new Palavra(novaPalavra.toLowerCase(), Integer.parseInt(dificuldade));
						bp.adicionaPalavrasNoBanco(palavra);
					}
					break;
				case "2":
					System.out.print("Digite qual palavra você deseja remover: ");
					String palavraParaRemover = input.nextLine();
					bp.removePalavrasNoBanco(palavraParaRemover);
					break;
				default:
					System.out.println("Voltando para o menu...");
					break;
			}
			break;
		case "2":
			String palavraEscolhida = m.getPalavraEscolhida();
			String palavraEmbaralhada = m.getPalavraEscolhidaEmbaralhada();
			
			System.out.println("5 tentativas para acertar!");
			System.out.println("\nDigite o significado da palavra embaralhada: " + palavraEmbaralhada);
			teste = m.testaPalavra(input.nextLine()); //limpar buffer
			tentativas = 1;
			
			while(!m.jogoTerminou(tentativas)){
				System.out.println("\nErrado!");
				System.out.println("Voce ainda tem " + (5-tentativas) +" tentativas!");
				 if (tentativas >1){
					 System.out.println("Dica: " +palavraEscolhida.substring(0, palavraEscolhida.length()/2) + "...");
				}
				System.out.println("palavra embaralhada: " +palavraEmbaralhada + "\nTente novamente: ");

				 teste = m.testaPalavra(input.nextLine()); //limpar buffer
				 tentativas ++;
				 if (tentativas == 5)
				 {
					 System.out.println("Game Over. A palavra era: " + palavraEscolhida );
					 score = 0;
				 }
			}
			if (teste){
				System.out.println("\nParabéns, você acertou na " +tentativas +"ª tentativa !" );
				score++;
			}
		default:
			break;
		}
		
		/*
		bp.adicionaPalavrasNoBanco(p);
		bp.adicionaPalavrasNoBanco(p1);
		bp.adicionaPalavrasNoBanco(p2);
		//bp.removePalavrasNoBanco("cão");
		//bp.removePalavrasNoBanco("gato");
		bp.listarBancoDePalavras();
		System.out.println("Palavra escolhida: " + bp.getPalavraAleatoria());
		System.out.println(bp);
		
		System.out.println("-------");
		
		System.out.println("Deck antigo: ");
		bp.listarBancoDePalavras();
		System.out.println("-------");
		System.out.println("Novo deck: ");
		em.embaralharDeckDePalavras();
		bp.listarBancoDePalavras();
		System.out.println("Palavra escolhida: " + bp.getPalavraAleatoria());
		System.out.println(em.embalharPalavraEscolhida(bp.getPalavraAleatoria()));
		System.out.println(m.getPalavraEscolhida());
		*/
	}
	
}
