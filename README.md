# Ascencion
## Objetivo
O objetivo deste projeto da disciplina Estrutura de Dados I é desenvolver um jogo estilo RPG de cartas de baralho Ascension, com a finalidade de trabalhar as diferentes estruturas de dados na linguagem de programação Java

## Participantes
Brenno Kevyn Maia de Souza
Davi Rabelo Clemente
João Vitor Fernandes de Sales
Luiz Ryan Borges da Costa
Vinicius Feliciano Alves do Nascimento

## Descrição:
Ele foi feito para ser jogado de dois a 4 jogadores, entretanto na aplicação sera feita uma abordagem de jogo solo. Sera necessario dois baralhos de cartas comuns
Baralho de Monstros: 
  1 - Separar as cartas reais(2, 3, 4, 5, 6, 7, 8, 9, 10, Valete, Dama e Rei. Com excessão dos Ás)
  2 - Dividir os Valetes, as Damas e Reis em cartas separadas
  3 - Realizar o embaralhamento das cartas de forma aleatoria. Exemplo: 1 Rei + 3 cartas de numero + 1 Dama + 3 cartas de numero + 1 Valete + 3 cartas de numero + 1 Rei (até acabar todas as cartas)
Baralho de Herois: 
  1 - Dessa vez os Ás fazem parte do baralho. 
  2 - Dividimos entre 4 classes separadas por naipes(simbolos)
    Naipe de Paus ♣: representa a classe dos Guerreiros
    Naipe de Copas ♥: representa a classe dos Paladinos
    Naipe de Espadas ♠: representa a classe dos Assassinos
    Naipe de Outros ♦: representa a classe dos Magos
  3 - Cada jogador deve escolher uma classe (Guerreiros, Paladinos, Assassinos ou Magos). Porém, como o jogo sera realizado em modo solo, então vamos escolher duas classes (exemplo: Guerreiros e Assassinos)
  4 - O Naipe que sobrar de cor oposta pode ser usado para representar os pontos de vida de cada Heroi. Como escolhemos os Guerreiros e os Assassinos, então os naipes de copas vão ser utilizados como pontos de vida dos Guerreiros e o outro naipe sera utilizado como ponto de vida dos Assassinos
Descrição dos Turnos:
  Fase número 01:
    1 - sacamos 4 cartas do baralho de monstro
  sacamos 3 cartas para cada heroi
    posso descartar uma carta para cada heroi para fortalecer (descatar cartas de menor valor e coloca na pilha de descarte a esquerda)
    fase 1 encerrada
  2 fase:
    realizamos os ataques do heroi (realizo um ataque referente a cada heroi utilizado. no caso são dois ataques)
      escolhe uma carta ou de guerreiros ou de assassinos (se o numero for maior voce pode derrotar qualquer um dos monstros que tenha nivel menor)
      se o naipe for o mesmo do monstro (simbolo) então sua carta é descartada e o monstro é derrotado (tem a opção de curar as feridas do baralho(usar cartas de vida) ou voce pode tirar uma carta que foi eliminada do seu jogo (essa carta sua que foi eliminada vai para eliminada do monstro) ao eliminar as cartas de menor nipe o seu baralho vai ficando cada vez mais forte
      
  3 Fase:
    é realizado o ataque dos monstros. Cada monstro realiza um ataque referente a cor dele. exemplo carta de cor vermelha pode atacar uma carta de cor vermelha.
    Caso a cor for a mesma, então devemos decidir quem irar atacar quem. cada monstro realiza um unico ataque por turno. um heroi pode bloquear o ataque 
    exemplo: um monstro de nivel 2 pode ser bloqueddo por um A que é maior, ou se não quiser perder o A que é a melhor carta, entõa posso receber esse ataque.
    cada ataque de mostro de numero eu perco um ponto de vida que é uma carta sacada do baralho
    se for bloqueado, então a carta do heroi é descartada e o monstro vai para uma segunda linha de cartas(linha de monstros não bloqueaveis (só é possivel bloquear um monstro uma vez)
    turno dos monstros finalizado
  
  É sacado mais cartas do baralho de monstros (mais não pode passar de 4 cartas. Conta com cartas não bloqueaveis)
  No baralho de herois é sacado cartas até completar 6 (3 guerreiros e 3 assassinos)
 
Hablidades de cada classe de guerreiros:
  guerreiro: unica classe de todas que pode usar cartas de vidas para tambem atacar
  paladinos: habilidade de cura. cada vez que derrota um inimigo ele tem a opção de curar todas as cartas de ferida
  assassinos: habilidade especial de assassinar. escolhe duas cartas para poder derrotar qualquer inimigo com qualquer posição e valor. inclusive na area de não bloqueaveis
  magos: pode atacar duas vezes na hodada dos herois. existe uma regra especifica, sendo que uma das cartas vai atingir os monstros da linha principal e a outra só pode atingir os mostros da linha de não bloqueaveis
  
  na medida que o jogo vai acontecendo vamos acumulando cartas de feridas e elas vão fazer parte do baralho de herois
