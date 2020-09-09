package modelagem;

import java.io.IOException;

public class Mecânica implements MecanicaDoJogo {
	private FabricaEmbaralhadores f = new FabricaEmbaralhadores();
	private BancoDePalavras b = new BancoDePalavras();
	private String palavraEscolhidaAleatoria = b.getPalavraAleatoria();
	private String PalavraEscolhidaEmbaralhada = f.embalharPalavraEscolhida(palavraEscolhidaAleatoria);
	private boolean acertou;
	
	@Override
	public boolean testaPalavra(String tentativa) throws IOException {
		if (tentativa.equals(getPalavraEscolhida())){
			acertou = true;
			System.out.println("Você acertou!");
			return true;
		} else {
			acertou = false;
			System.out.println("Suas vidas acabaram :(");
			return false;
		}
	}

	@Override
	public boolean jogoTerminou(int tentativas) {
		if (tentativas == 5 || acertou){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getPalavraEscolhida() throws IOException {
		return palavraEscolhidaAleatoria;
		
	}

	@Override
	public String getPalavraEscolhidaEmbaralhada() throws IOException {
		return PalavraEscolhidaEmbaralhada;
	}

}
