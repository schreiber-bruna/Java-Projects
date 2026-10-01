
import java.util.Random;

public class Loteria {
    private int[][] concursos = new int[10][2];
    private int[] precos = new int[10];
    private int totalConcursos = 0;

    private Concurso[] apostas = new Concurso[100];
    private int totalApostas = 0;

    private double arrecadado = 0;

    public void cria_concurso(int id, int limiteMaximo, int preco) {
        concursos[totalConcursos][0] = id;
        concursos[totalConcursos][1] = limiteMaximo;
        precos[totalConcursos] = preco;
        totalConcursos++;
    }

    private int buscarIndiceConcurso(int id) {
        for (int i = 0; i < totalConcursos; i++) {
            if (concursos[i][0] == id) {
                return i;
            }
        }
        return -1;
    }

    public void vender(Pessoa p, int concursoId, int... numerosEscolhidos) {
        int indice = buscarIndiceConcurso(concursoId);
        if (indice == -1) {
            System.out.println("Concurso inválido.");
            return;
        }

        int limite = concursos[indice][1];
        double valorAposta = precos[indice];

        int[] numeros = new int[3];
        if (numerosEscolhidos.length == 0) {
            Random rand = new Random();
            for (int i = 0; i < 3; i++) {
                numeros[i] = rand.nextInt(limite) + 1;
            }
        } else if (numerosEscolhidos.length == 3) {
            numeros = numerosEscolhidos;
        } else {
            System.out.println("Você deve escolher exatamente 3 números.");
            return;
        }

        if (p.debitar(valorAposta)) {
            apostas[totalApostas++] = new Concurso(p, concursoId, numeros);
            arrecadado += valorAposta;
            System.out.println("Aposta realizada no concurso " + concursoId + " por R$" + valorAposta);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void vender(Pessoa p) {
        if (totalConcursos > 0) {
            int concursoId = concursos[0][0];
            vender(p, concursoId);
        }
    }

    public void sorteia_resultado() {
        Random rand = new Random();

        for (int i = 0; i < totalConcursos; i++) {
            int concursoId = concursos[i][0];
            int limite = concursos[i][1];

            int[] sorteados = new int[3];
            for (int j = 0; j < 3; j++) {
                sorteados[j] = rand.nextInt(limite) + 1;
            }

            System.out.println("\nResultado do concurso " + concursoId + ": " +
                sorteados[0] + ", " + sorteados[1] + ", " + sorteados[2]);

            int ganhadores = 0;
            for (int k = 0; k < totalApostas; k++) {
                Concurso a = apostas[k];
                if (a.getConcurso() == concursoId && a.acertos(sorteados) == 3) {
                    ganhadores++;
                }
            }

            if (ganhadores > 0) {
                double premio = (arrecadado * 0.7) / ganhadores;
                for (int k = 0; k < totalApostas; k++) {
                    Concurso a = apostas[k];
                    if (a.getConcurso() == concursoId && a.acertos(sorteados) == 3) {
                        a.getPessoa().creditar(premio);
                        System.out.println("Pessoa " + a.getPessoa().getId() + " ganhou R$" + premio);
                    }
                }
            } else {
                System.out.println("Sem ganhadores neste concurso.");
            }
        }
    }
}
