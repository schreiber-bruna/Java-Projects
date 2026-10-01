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
        int linhaChegada = totalLinhas / 2;

        if (voltas < 5) {
            if (linhaAtual < linhaMeioMatrix - 1) {
                return Move.DOWN;
            }
            if (linhaAtual == linhaMeioMatrix - 1) {
                voltas++;
                return Move.DOWN; 
            }
            //Se acabou de cruzar a linha e ainda faltam voltas, dá um passo para CIMA para poder cruzar novamente
            if (linhaAtual == linhaMeioMatrix) {
                return Move.UP;
            }
        } else {
            // Já completou 5 voltas, vai direto para a linha de chegada
            if (colunaAtual < 2) return Move.RIGHT;
            if (colunaAtual > 2) return Move.LEFT;
            
            if (linhaAtual < linhaChegada) return Move.DOWN;
            if (linhaAtual > linhaChegada) return Move.UP;
            return Move.STOP;
        }
        
        return Move.STOP;
    }
}
