import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Loteria l1 = new Loteria();
		int idConcurso = 1;
		int limiteNumeros = 50;
		int precoAposta = 3;
		
		l1.cria_concurso(idConcurso, limiteNumeros, precoAposta); 
		
		Scanner leitor = new Scanner(System.in);

		System.out.print("Qual é o seu saldo inicial? R$ ");
		int saldoUsuario = leitor.nextInt();
		Pessoa usuario = new Pessoa(101, saldoUsuario);

		System.out.print("Quantas pessoas a mais vão jogar com você? Digite 0 se for só você: ");
		int qtdExtras = leitor.nextInt();
		
		if (qtdExtras > 80) {
		    System.out.println("Limite máximo de participantes foi atingindo, reduzindo para 80 participantes.");
		    qtdExtras = 80;
		}

		Pessoa[] participantes = new Pessoa[qtdExtras + 1];
		participantes[0] = usuario;
		for (int i = 1; i <= qtdExtras; i++) {
			participantes[i] = new Pessoa(101 + i, 100); 
		}

		System.out.println("\n Forma de Apostas");
		System.out.println("1: Escolher uma quantidade X de bilhetes");
		System.out.println("2: Apostar até o meu saldo acabar");
		System.out.print("Escolha a opção desejada: ");
		int estrategia = leitor.nextInt();

		int qtdApostas = 0;
		if (estrategia == 1) {
			System.out.print("Quantos bilhetes você quer comprar? ");
			qtdApostas = leitor.nextInt();
		} else if (estrategia == 2) {
			qtdApostas = usuario.getDinheiro() / precoAposta;
			System.out.println("Seu saldo de R$" + usuario.getDinheiro() + " permite comprar " + qtdApostas + " bilhetes.");
		} else {
			System.out.println("Opção inválida, o sistema assumirá a compra de apenas 1 bilhete.");
			qtdApostas = 1;
		}

		int limiteApostasPermitidas = 95 / (qtdExtras + 1); 
		if (qtdApostas > limiteApostasPermitidas) {
			System.out.println("Cada um poderá comprar no máximo " + limiteApostasPermitidas + " bilhetes.");
			qtdApostas = limiteApostasPermitidas;
		}

		System.out.println("\n Tipo do Bilhete");
		System.out.println("1: O computador escolhe todos os seus números");
		System.out.println("2: Você digita seus números e repete eles em todos os seus bilhetes");
		System.out.print("Escolha a opção: ");
		int tipoAposta = leitor.nextInt();

		int n1 = 0, n2 = 0, n3 = 0;
		if (tipoAposta == 2) {
			System.out.println("\nDigite o 1º número (entre 1 e 50):");
			n1 = leitor.nextInt();
			System.out.println("Digite o 2º número (entre 1 e 50):");
			n2 = leitor.nextInt();
			System.out.println("Digite o 3º número (entre 1 e 50):");
			n3 = leitor.nextInt();
		}

		for (int i = 0; i < qtdApostas; i++) {
			if (tipoAposta == 1) {
				l1.vender(usuario, idConcurso); 
			} else {
				l1.vender(usuario, idConcurso, n1, n2, n3); 
			}
		}

		if (qtdExtras > 0) {
			for (int i = 1; i <= qtdExtras; i++) {
				for (int j = 0; j < qtdApostas; j++) {
					if (participantes[i].getDinheiro() >= precoAposta) {
						l1.vender(participantes[i], idConcurso); 
					} else {
						System.out.println("O participante " + participantes[i].getId() + " ficou sem saldo e parou de apostar.");
						break;
					}
				}
			}
		}

		leitor.close(); 
		System.out.println("SORTEANDO RESULTADOS");
		l1.sorteia_resultado();

		System.out.println("\n Saldos Finais");
		for (Pessoa p : participantes) {
			System.out.println(p);
		}
	}
}