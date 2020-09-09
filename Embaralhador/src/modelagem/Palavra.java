package modelagem;

public class Palavra {
	private String palavra;
	private int dificuldade;
	
	public Palavra(String palavra, int dificuldade) {
		this.palavra = palavra;
		this.dificuldade = dificuldade;
	}
	
	public Palavra(String palavra) {
		this.palavra = palavra;
		this.dificuldade = 0;
	}

	public String getPalavra() {
		return palavra;
	}

	public int getDificuldade() {
		return dificuldade;
	}
	
	@Override
	public String toString() {
		return "Palavra: " + getPalavra() + " | " + "Dificuldade: " + getDificuldade() + "\n";
	}
	
}
