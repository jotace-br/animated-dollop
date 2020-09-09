package modelagem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BancoDePalavras {
	public static List<Palavra> bancoDePalavras = new ArrayList<>();
	public static String palavraEscolhida;

	public void adicionaPalavrasNoBanco(Palavra palavraNova) throws IOException {
		try {
			bancoDePalavras.add(palavraNova);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void removePalavrasNoBanco(String palavra) throws NullPointerException {
		try {
			bancoDePalavras.removeIf(k -> k.getPalavra().equals(palavra));
			System.out.println("Removido com sucesso!");
		} catch (Exception e) {
			System.out.println("Não foi possível remover. Erro: " + e);
		}		
	}
	
	public String getPalavraAleatoria() throws NullPointerException {
		try {
			Palavra selecionarPalavra = bancoDePalavras.get(new Random().nextInt(bancoDePalavras.size()));
			palavraEscolhida =  selecionarPalavra.getPalavra();
		} catch (Exception e) {
			System.out.println(e);
		}
		return palavraEscolhida;
	}
	
	public void listarBancoDePalavras() {
		for (int i = 0; i < bancoDePalavras.size(); i++) {
			System.out.format("Palavra: %s | Dificuldade: %d\n",bancoDePalavras.get(i).getPalavra(),bancoDePalavras.get(i).getDificuldade());
		}
	}
	
	public void bancoDePalavrasIniciais() {
		Palavra palavra = new Palavra("papagaio", 3);
		Palavra palavra2 = new Palavra("cachorro", 2);
		Palavra palavra3 = new Palavra("whatsapp", 1);
		Palavra palavra4 = new Palavra("smartphone", 3);
		Palavra palavra5 = new Palavra("notebook", 2);
		Palavra palavra6 = new Palavra("chocalho", 2);
		Palavra palavra7 = new Palavra("gelo", 1);
		Palavra palavra8 = new Palavra("agua", 1);
		Palavra palavra9 = new Palavra("gato", 1);
		Palavra palavra10 = new Palavra("girafa", 2);
		bancoDePalavras.add(palavra);
		bancoDePalavras.add(palavra2);
		bancoDePalavras.add(palavra3);
		bancoDePalavras.add(palavra4);
		bancoDePalavras.add(palavra5);
		bancoDePalavras.add(palavra6);
		bancoDePalavras.add(palavra7);
		bancoDePalavras.add(palavra8);
		bancoDePalavras.add(palavra9);
		bancoDePalavras.add(palavra10);
	}

	@Override
	public String toString() {
		return "BancoDePalavras: \n" + bancoDePalavras;
	}

}
