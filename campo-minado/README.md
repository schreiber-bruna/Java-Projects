Este projeto é uma implementação do jogo Campo Minado, desenvolvida na linguagem Java com recurso à biblioteca gráfica Swing para a construção da interface de utilizador.

O que o código faz:

  Inicializa uma janela principal de 500x600 píxeis que contém o jogo e um painel de controlo inferior.
  
  Constrói e apresenta um tabuleiro jogável estruturado numa grelha de 8 por 8 células.
  
  Gera e distribui de forma aleatória exatamente 10 minas ao longo do tabuleiro.
  
  Processa os cliques do utilizador em cada célula, que atua como um botão independente através do registo das suas próprias coordenadas de linha e coluna.
  
  Calcula e exibe o número exato de minas adjacentes quando o utilizador clica numa célula segura.
  
  Termina a partida imediatamente se uma mina for detonada pelo utilizador, marcando a célula com um "X" num fundo vermelho, desativando o tabuleiro inteiro e mostrando uma mensagem de "Game Over".
  
  Fornece um botão "Mostrar Minas" que permite ao jogador revelar ou ocultar a localização de todas as minas ativas no tabuleiro a qualquer momento.
  
  Apresenta um botão de "Ajuda" que invoca uma janela informativa com as regras e instruções do jogo.
  
  Garante a inicialização da interface gráfica de forma correta e segura através das rotinas do Swing.
