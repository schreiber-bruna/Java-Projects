package Entities;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Tabuleiro extends JPanel {
    private int linhas, colunas, totalMinas;
    private Celula[][] celulas;
    private boolean[][] minas;
    private boolean jogoEncerrado = false;

    public Tabuleiro(int linhas, int colunas, int totalMinas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.totalMinas = totalMinas;
        this.celulas = new Celula[linhas][colunas];
        this.minas = new boolean[linhas][colunas];

        setLayout(new GridLayout(linhas, colunas));
        inicializarCelulas();
        gerarMinas();
    }

    private void inicializarCelulas() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                Celula celula = new Celula(i, j);

                celula.addActionListener(e -> {
                    if (jogoEncerrado) return;

                    int linha = celula.getLinha();
                    int coluna = celula.getColuna();

                    if (minas[linha][coluna]) {
                        celula.setText("X");
                        celula.setBackground(Color.RED);
                        celula.setEnabled(false);
                        encerrarJogo();
                    } else {
                        int minasVizinho = contarMinasAoRedor(linha, coluna);
                        celula.setText(String.valueOf(minasVizinho));
                        celula.setEnabled(false);
                    }
                });

                celulas[i][j] = celula;
                add(celula);
            }
        }
    }

    private void gerarMinas() {
        Random rand = new Random();
        int colocadas = 0;
        while (colocadas < totalMinas) {
            int linha = rand.nextInt(linhas);
            int coluna = rand.nextInt(colunas);
            if (!minas[linha][coluna]) {
                minas[linha][coluna] = true;
                colocadas++;
            }
        }
    }

    private int contarMinasAoRedor(int linha, int coluna) {
        int contador = 0;
        for (int i = linha - 1; i <= linha + 1; i++) {
            for (int j = coluna - 1; j <= coluna + 1; j++) {
                if (i >= 0 && i < linhas && j >= 0 && j < colunas && minas[i][j]) {
                    contador++;
                }
            }
        }
        return contador;
    }

    public void mostrarMinas(boolean mostrar) {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (!celulas[i][j].isEnabled()) continue;

                if (mostrar && minas[i][j]) {
                    celulas[i][j].setText("X");
                    celulas[i][j].setForeground(Color.RED);
                } else {
                    celulas[i][j].setText("");
                    celulas[i][j].setForeground(Color.BLACK);
                }
            }
        }
    }

    private void encerrarJogo() {
        jogoEncerrado = true;
        mostrarMinas(true);
        desabilitarTodasCelulas();
        JOptionPane.showMessageDialog(this, "Você perdeu!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
    }

    private void desabilitarTodasCelulas() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                celulas[i][j].setEnabled(false);
            }
        }
    }
}
