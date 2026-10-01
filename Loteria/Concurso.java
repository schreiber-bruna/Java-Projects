public class Concurso {
	private Pessoa pessoa;
	private int concurso;
	private int[] numeros;

	public Concurso(Pessoa pessoa, int concurso, int[] numeros) {
		this.pessoa = pessoa;
		this.concurso = concurso;
		this.numeros = numeros;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public int getConcurso() {
		return concurso;
	}

	public int[] getNumeros() {
		return numeros;
	}

	public int acertos(int[] sorteados) {
		int cont = 0;
		for(int i =0; i<numeros.length;i++) {
			for(int j=0;j<sorteados.length;j++) {
				if(numeros[i]==sorteados[j]) {
					cont++;
				}
			}
		}
		return cont;
		}
}
