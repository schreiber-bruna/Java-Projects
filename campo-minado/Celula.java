package Entities;

import javax.swing.*;

public class Celula extends JButton{
	private final int linha;
	private final int coluna;
	public Celula (int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	public int getLinha() {
		return linha;
	}
	public int getColuna() {
		return coluna;
	}

}
