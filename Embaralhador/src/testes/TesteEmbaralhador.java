package testes;

import static org.junit.Assert.assertNotEquals;
import java.io.IOException;
import org.junit.jupiter.api.Test;

import modelagem.BancoDePalavras;
import modelagem.FabricaEmbaralhadores;

class TesteEmbaralhador {

	@Test
	void testeEmbaralhadorDeckDePalavras() throws NullPointerException, IOException {
		FabricaEmbaralhadores fe = new FabricaEmbaralhadores();
		BancoDePalavras bp = new BancoDePalavras();
		bp.bancoDePalavrasIniciais();
		//bp.listarBancoDePalavras(); banco de palavras atual sem mexer
		//fe.embaralharDeckDePalavras(); banco de palavras sortido
		assertNotEquals(bp.toString(), fe.embaralharDeckDePalavras());
	}
	
	@Test
	void testeEmbaralhadorDePalavras() throws IOException {
		FabricaEmbaralhadores fe = new FabricaEmbaralhadores();
		assertNotEquals("embaralhador", fe.embalhararPalavraEscolhida("embaralhador"));
	}
	




}
