package modelagem;
import java.io.IOException;

public interface MecanicaDoJogo {
	public boolean testaPalavra(String tentativa) throws IOException;
	public boolean jogoTerminou (int tentativas);
	public String getPalavraEscolhida() throws IOException;
	public String getPalavraEscolhidaEmbaralhada() throws IOException;
	public void gerarNovaPalavraAleatoria();

}
