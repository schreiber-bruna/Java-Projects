Simulador de Corrida de Robô

Este projeto implementa uma simulação de navegação autônoma onde um robô se movimenta dentro de uma matriz com o objetivo de completar uma corrida e atingir uma linha de chegada estipulada.

O que o sistema executa

  Inicializa um ambiente de grade com dimensões de 10x10 e posiciona um robô no seu interior.

  A Matrix contabiliza uma volta sempre que um item se move para a direção inferior (DOWN), cruzando a linha central enquanto se encontra na metade esquerda da grade.

  O robô utiliza um algoritmo de navegação focado em completar 5 voltas no circuito utilizando o menor número de movimentos possível.

  Para otimizar a trajetória, o robô desce diretamente até a linha central do ambiente e oscila sua posição para cima e para baixo repetidamente.

  Essa oscilação permite engatilhar o contador de voltas da matriz rapidamente, evitando que o robô tenha que percorrer todo o perímetro do mapa.

  Imediatamente após registrar as 5 voltas, o robô calcula a rota lateral mais curta para parar na coordenada exata da linha de chegada (localizada na linha central, coluna 2).

  Ao atingir o objetivo, o robô emite o comando de parada (STOP).

  Durante toda a execução, o programa imprime no console cada passo do robô, detalhando a direção escolhida (UP, DOWN, LEFT, RIGHT) e a coordenada exata alcançada a cada turno, finalizando com uma mensagem de chegada.

Estrutura do Código:
  'Principal.java': É a classe executável do programa, ela cria o mapa 10x10, insere o robô e mantém um laço de repetição que processa e imprime os movimentos até a corrida acabar.

  'Matrix.java': Gerencia o ambiente, os limites das bordas, as posições atuais dos itens através de uma classe ItemPos e a regra que define o que constitui uma volta no circuito.

  'Robot.java': Herda as características base de um item, gerenciando automaticamente o contador de voltas e retornando as direções necessárias para realizar o trajeto longo e finalizar a prova.

  'Item.java': Classe abstrata que estabelece a estrutura dos elementos do mapa, garantindo que cada um receba um identificador único (id), variáveis de posição e uma conexão com a matriz onde estão inseridos.

  'Move.java': Uma enumeração que restringe e define as opções de movimento disponíveis no sistema (STOP, UP, DOWN, LEFT, RIGHT).

  
