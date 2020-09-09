package modelagem;

import java.io.IOException;

public class Mecânica implements MecanicaDoJogo {
	private FabricaEmbaralhadores fabricaEmbaralhadores = new FabricaEmbaralhadores();
	private BancoDePalavras bancoDePalavras = new BancoDePalavras();
	private String palavraEscolhidaAleatoria = bancoDePalavras.getPalavraAleatoria();
	private String PalavraEscolhidaEmbaralhada = fabricaEmbaralhadores.embalhararPalavraEscolhida(palavraEscolhidaAleatoria);
	private boolean acertou;

	@Override
	public boolean testaPalavra(String tentativa) throws IOException {
		if (tentativa.equals(getPalavraEscolhida())){
			acertou = true;
			return true;
		} else {
			acertou = false;
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
	public void gerarNovaPalavraAleatoria() {
		String novaPalavra = bancoDePalavras.getPalavraAleatoria();
		this.palavraEscolhidaAleatoria = novaPalavra;
		this.PalavraEscolhidaEmbaralhada = fabricaEmbaralhadores.embalhararPalavraEscolhida(novaPalavra);
	}

	@Override
	public String getPalavraEscolhida() throws IOException {
		return palavraEscolhidaAleatoria;
	}

	public void setPalavraEscolhidaAleatoria(String palavraEscolhidaAleatoria) {
		this.palavraEscolhidaAleatoria = palavraEscolhidaAleatoria;
	}

	public void setPalavraEscolhidaEmbaralhada(String palavraEscolhidaEmbaralhada) {
		PalavraEscolhidaEmbaralhada = palavraEscolhidaEmbaralhada;
	}

	@Override
	public String getPalavraEscolhidaEmbaralhada() throws IOException {
		return PalavraEscolhidaEmbaralhada;
	}

}
