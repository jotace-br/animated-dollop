package modelagem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FabricaEmbaralhadores implements Embaralhador {
	BancoDePalavras bp;
	Palavra p;
	List<String> dica = new ArrayList<>();
	
	public BancoDePalavras embaralharDeckDePalavras() { //ok
		Collections.shuffle(BancoDePalavras.bancoDePalavras);
		return null;
	}

	@Override
	public String embalharPalavraEscolhida(String s) throws NullPointerException {
		//String s = bp.getPalavraAleatoria();
	    List<String> letras = Arrays.asList(s.split(""));
	    dica.addAll(letras);
	    Collections.shuffle(letras);
	    StringBuilder t = new StringBuilder(s.length());
	    for (String k : letras) {
	        t.append(k);
	    }
	    return t.toString();
	}

}
