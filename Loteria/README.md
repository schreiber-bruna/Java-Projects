Um simulador de loteria desenvolvido em Java. O sistema permite gerenciar o saldo financeiro do usuário, fazer diferentes tipos de apostas e realizar sorteios com distribuição de prêmios de forma automatizada via terminal.

Funcionalidades Principais:
  Menu Interativo: Interface via console, utilizando `Scanner`, onde o usuário configura toda a simulação passo a passo.
  Gestão de Carteira: Controle de saldo em tempo real. O sistema calcula automaticamente quantos bilhetes podem ser comprados e barra compras caso o dinheiro acabe.
  Outros Participante: O usuário pode adicionar $N$ participantes extras controlados pelo computador. Cada participante recebe um saldo inicial independente e tenta realizar a mesma quantidade de apostas do usuário, interrompendo as compras se o próprio saldo estourar.
  O Jogo:
    Compra de uma quantidade exata de bilhetes ($X$ vezes).
    Opção de apostar continuamente até o saldo zerar.
  Tipos de Bilhetes:
    Opção 1: O computador gera os 3 números da aposta de forma aleatória.
    Opção 2: O usuário digita seus 3 números, que são aplicados em todos os bilhetes comprados.
    Trava: Implementação de uma trava que divide o limite máximo de bilhetes do sistema pelo número de jogadores ativos, impedindo exceções de estouro de array (`IndexOutOfBounds`).

Estrutura do Projeto:
 `Main.java`: Controla o fluxo, a captação de dados do teclado e as regras de espelhamento dos bots.
 `Loteria.java`: Classe responsável pela regra de negócios. Registra concursos, vende as apostas, sorteia os números vencedores e dá o prêmio calculado aos ganhadores.
 `Concurso.java`: Cria o bilhete físico da aposta, realciona uma `Pessoa` aos números apostados e possui o algoritmo que cruza os dados para contabilizar os acertos.
 `Pessoa.java`: Representa a entidade do jogador, protege os atributos de `id` e `saldoPessoa` através de encapsulamento.


 Como Executar:
   Certifique-se de ter o Java Development Kit (JDK) instalado.
   Clone o repositório ou baixe os arquivos fonte.
   No terminal, navegue até a pasta do projeto e compile os arquivos:
     bash
       javac *.java
    Execute a aplicação iniciando pela classe Main: java Main
