package modelagem;

import java.io.IOException;

public interface Embaralhador {
	public BancoDePalavras embaralharDeckDePalavras() throws IOException, NullPointerException;
	String embalhararPalavraEscolhida(String s) throws NullPointerException;
}
