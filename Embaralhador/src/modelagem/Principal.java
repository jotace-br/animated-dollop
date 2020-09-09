package modelagem;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) throws IOException {
		BancoDePalavras bancoDePalavras = new BancoDePalavras();
		bancoDePalavras.bancoDePalavrasIniciais();
		Mecânica mecanicaJogo = new Mecânica();
		Scanner input = new Scanner(System.in);
		int score = 0;
		int opçãoMenu;
		int opção;
		
		do {
		System.out.println();
		System.out.println("-- Menu principal --");
		System.out.println("1. Desenvolvedor MODE");
		System.out.println("2. Jogar!");
		System.out.println("3. Ver score");
		System.out.println("4. Sair");
		System.out.println();
		System.out.print("Digite sua opção: ");
		opçãoMenu = input.nextInt();
		switch (opçãoMenu) {
			case 1:
				System.out.println();
				System.out.println("1. Adicionar palavras");
				System.out.println("2. Remover palavras");
				System.out.println("3. Listar banco de palavras");
				System.out.println("4. Voltar para o menu principal");
				System.out.println();
				System.out.print("Digite sua opção: ");
				opção = input.nextInt();
				switch (opção) {
					case 1:
						String adicionarNovamente;
						do {
							try {
								clearBuffer(input);
								System.out.print("Digite qual palavra você deseja adicionar: ");
								String novaPalavra = input.nextLine();
								
								System.out.print("Deseja adicionar a dificuldade da palavra?: ");
								int dificuldade = input.nextInt();
								clearBuffer(input);
								
								if(dificuldade == 0) {
									Palavra palavra = new Palavra(novaPalavra);
									bancoDePalavras.adicionaPalavrasNoBanco(palavra);
								} else {
									Palavra palavra = new Palavra(novaPalavra, dificuldade);
									bancoDePalavras.adicionaPalavrasNoBanco(palavra);
								}
							} catch (Exception e) {
								System.err.println("Não foi possível adicionar." + e);
							}
							System.out.println("Deseja adicionar outra palavra? [S/N]: ");
							adicionarNovamente = new Scanner(System.in).next();
						} while(adicionarNovamente.equalsIgnoreCase("S"));
						break;
					case 2:
						String removerNovamente;
						do {
							try {
								clearBuffer(input);
								System.out.print("Digite qual palavra você deseja remover: ");
								String palavraParaRemover = input.nextLine();
								bancoDePalavras.removePalavrasNoBanco(palavraParaRemover);
							} catch (Exception e) {
								System.err.println("Não foi possível remover." + e);
							}
							System.out.println("Deseja remover outra palavra? [S/N]: ");
							removerNovamente = new Scanner(System.in).next();
						} while(removerNovamente.equalsIgnoreCase("S"));
						break;
					case 3:
						System.out.println("\nLista atual: ");
						bancoDePalavras.listarBancoDePalavras();
						System.out.println();
						break;
					default:
						System.out.println("Voltando para o menu...");
						break;
				}
				break;
			case 2:
				String jogarNovamente;
				
				do {
					String palavraEscolhida = mecanicaJogo.getPalavraEscolhida();
					String palavraEmbaralhada = mecanicaJogo.getPalavraEscolhidaEmbaralhada();
					clearBuffer(input);
					System.out.println("5 tentativas para acertar!");
					System.out.println("\nDigite o significado da palavra embaralhada: " + palavraEmbaralhada);
					System.out.print("Digite sua tentativa: ");
					int tentativas = 1;
					boolean teste = mecanicaJogo.testaPalavra(input.nextLine());
					
					while(!mecanicaJogo.jogoTerminou(tentativas)){
						System.out.format("\nResposta incorreta! Você ainda tem %d tentativas.", (5-tentativas));
						if (tentativas < 3){
							 System.out.format(" Dica: %s...", palavraEscolhida.substring(0, palavraEscolhida.length()/4));
						} else if(tentativas >= 3) {
							System.out.format(" Dica: %s...", palavraEscolhida.substring(0, palavraEscolhida.length()/2));
						}
						System.out.format("\nPalavra embaralhada: %s\nTente novamente: ", palavraEmbaralhada);
						teste = mecanicaJogo.testaPalavra(input.nextLine());
						tentativas++;
							
						if (tentativas == 5) {
							System.out.println("Game Over! A palavra era: " + palavraEscolhida);
							score = 0;
						}
					}
					
					if (teste) {
						System.out.format("\nParabéns, você acertou na %dª tentativa!\n", tentativas);
						score++;
					}
					System.out.print("\nDeseja jogar novamente? [S/N]: ");
					jogarNovamente = input.next();
					
					if(jogarNovamente.equalsIgnoreCase("S")) {
						mecanicaJogo.gerarNovaPalavraAleatoria();
					}
				} while(jogarNovamente.equalsIgnoreCase("S"));
				break;
			case 3:
				System.out.format("\nSeu score atual é de %d pontos.\n", score);
				break;
			case 4:
				System.out.println("Obrigado por usar o programa!");
				System.exit(0);
				break;
			default:
				System.exit(0);
				break;
			}
		} while(opçãoMenu < 5);
	}
	
	private static void clearBuffer(Scanner scanner) {
		if(scanner.hasNextLine()) {
			scanner.nextLine();
		}
	}
	}
