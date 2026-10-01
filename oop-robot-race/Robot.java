package Corrida;

public class Robot extends Item {
    private int voltas = 0;

    public Robot() {
    }

    @Override
    public Move move() {
        // O GPS do enunciado utiliza os métodos da classe Matrix para obter as coordenadas
        int linhaAtual = mat1.get_line(this.id);
        int colunaAtual = mat1.get_column(this.id);
        int totalLinhas = mat1.getQttyLines();
        
        // Cálculos baseados na lógica da Matrix e no PDF
        int linhaMeioMatrix = 1 + (totalLinhas - 1) / 2;
        int linhaChegada = totalLinhas / 2; // A divisão inteira em Java equivale à função piso (floor)

        if (voltas < 5) {
            // 1. Desce pela coluna 1 até a linha imediatamente anterior ao gatilho da volta
            if (linhaAtual < linhaMeioMatrix - 1) {
                return Move.DOWN;
            }
            
            // 2. Dá o passo para BAIXO que cruza a linha e contabiliza a volta na Matrix
            if (linhaAtual == linhaMeioMatrix - 1) {
                voltas++;
                return Move.DOWN; 
            }
            
            // 3. Se acabou de cruzar a linha e ainda faltam voltas, dá um passo para CIMA para poder cruzar novamente
            if (linhaAtual == linhaMeioMatrix) {
                return Move.UP;
            }
        } else {
            // 4. Já completou 5 voltas, vai direto para a linha de chegada estipulada
            if (colunaAtual < 2) return Move.RIGHT;
            if (colunaAtual > 2) return Move.LEFT;
            
            if (linhaAtual < linhaChegada) return Move.DOWN;
            if (linhaAtual > linhaChegada) return Move.UP;
            
            // Se chegou na exata posição da linha de chegada, o robô finaliza seu trajeto
            return Move.STOP;
        }
        
        return Move.STOP;
    }
}