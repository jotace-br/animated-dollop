package modelagem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FabricaEmbaralhadores implements Embaralhador {
	List<String> palavraEmbaralhada = new ArrayList<>();
	
	public BancoDePalavras embaralharDeckDePalavras() throws IOException, NullPointerException {
		Collections.shuffle(BancoDePalavras.bancoDePalavras);
		return null;
	}

	@Override
	public String embalhararPalavraEscolhida(String s) throws NullPointerException {
	    List<String> letras = Arrays.asList(s.split(""));
	    palavraEmbaralhada.addAll(letras);
	    Collections.shuffle(letras);
	    StringBuilder t = new StringBuilder(s.length());
	    for (String k : letras) {
	        t.append(k);
	    }
	    return t.toString();
	}

}
