package Entities;

import java.awt.*;
import javax.swing.*;

public class JogoCampoMinado extends JFrame{
	private final int LINHAS = 8;
    private final int COLUNAS = 8;
    private final int TOTAL_MINAS = 10;
	private Tabuleiro tabuleiro;
	private JButton mostrarMinas;
    private boolean mostrandoMinas = false;

    public JogoCampoMinado() {
        setTitle("Campo Minado");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        tabuleiro = new Tabuleiro(LINHAS, COLUNAS, TOTAL_MINAS);

        JPanel painelBotoes = new JPanel(new FlowLayout());

        mostrarMinas = new JButton("Mostrar Minas");
        mostrarMinas.addActionListener(e -> {
            mostrandoMinas = !mostrandoMinas;
            tabuleiro.mostrarMinas(mostrandoMinas);

            if (mostrandoMinas) {
                mostrarMinas.setText("Ocultar Minas");
            } else {
                mostrarMinas.setText("Mostrar Minas");
            }
        });

        JButton ajuda = new JButton("Ajuda");
        ajuda.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Jogo Campo Minado:\n\n" +
                    "- Clique nas células para revelar.\n" +
                    "- Evite as minas (X vermelha).\n" +
                    "- O botão 'Mostrar Minas' revela ou oculta todas as minas.",
                    "Ajuda", JOptionPane.INFORMATION_MESSAGE);
        });

        painelBotoes.add(mostrarMinas);
        painelBotoes.add(ajuda);

        add(tabuleiro, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        setVisible(true);
    }

}


