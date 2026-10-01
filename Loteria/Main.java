
public class Main {

	public static void main(String[] args) {
		Loteria l1 = new Loteria();
		l1.cria_concurso(1, 50,3);
		l1.cria_concurso(2, 40,4);
		int qtde_pessoas = 5;
		Pessoa[] c_pessoas = new Pessoa[qtde_pessoas];
		c_pessoas[0] = new Pessoa(101, 100);
		c_pessoas[1] = new Pessoa(102, 50);
		c_pessoas[2] = new Pessoa(103, 10);
		c_pessoas[3] = new Pessoa(104, 0);
		c_pessoas[4] = new Pessoa(105, 30);

		l1.vender(c_pessoas[0], 1, 3, 6, 10);
		l1.vender(c_pessoas[0], 2);
		l1.vender(c_pessoas[1], 3, 6, 10);
		l1.vender(c_pessoas[1]);

		l1.sorteia_resultado();

		for (Pessoa p : c_pessoas) {
		if (p != null) {
		System.out.println(p);
		
		}

	}
	}
}
