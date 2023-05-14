<h1 align="center">
<img src="https://cdn-icons-png.flaticon.com/512/4099/4099307.png" width="200px">
<p>Ascension ♣♥♠♦⚔</p>
</h1>

## 🏆 Objetivo

Este projeto da disciplina de **Estrutura de Dados I** tem como objetivo desenvolver um jogo estilo RPG de cartas de baralho **Ascension** em Java, com a finalidade de trabalhar diferentes estruturas de dados e conceitos de programação orientada a objetos. O jogo será implementado utilizando a biblioteca JavaFX para criar uma interface gráfica do usuário (GUI) interativa, e diferentes estruturas de dados serão utilizadas para gerenciar o baralho.

## ✅ Checklist

- [X] Vetor/Matriz -> Em todas estruturas de dados e no array de Jogadores em Mesa.java
- [X] Arquivo texto/binário -> Sistema de cadastro e login
- [X] Generic -> Em todas estruturas de dados (MyStack, Fila, MyArrayList, etc)
- [X] Pilha -> Para os baralhos de carta, em Baralho.java
- [X] Fila -> Para o ataque de todos os monstros, em Mesa.java na função de AtaqueTodosMonstros()
- [X] Lista encadeada -> Para as cartas nas maos dos jogadores e monstros, em MaoJogador e MaoMonstro
- [X] Busca linear/binária -> Para exibição dos jogadores, em Mesa.java na função de exibirJogadores()
- [X] Ordenação -> Para exibição dos heróis restantes, em Game.java ao final do método main

## 👨🏾‍💻 Participantes
- Brenno Kevyn Maia de Souza
- Davi Rabelo Clemente
- João Vitor Fernandes de Sales
- Luiz Ryan Borges da Costa
- Vinicius Feliciano Alves do Nascimento

## 🛠 Tecnologias e Ferramentas
- [Java](https://www.oracle.com/br/java/technologies/downloads/)
```bash
# Versão do java instalado
C:\Users\Usuário>java --version
java 11.0.17 2022-10-18 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.17+10-LTS-269)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.17+10-LTS-269, mixed mode)
```
- [Eclipse](https://www.eclipse.org/downloads/)
- [JavaFx](https://openjfx.io/)
- [Scene Builder](https://gluonhq.com/products/scene-builder/)

## ✏ Descrição:
<p>O jogo foi originalmente projetado para ser jogado por dois a quatro jogadores, mas na aplicação que estamos desenvolvendo, será possível jogar apenas em dois (ou "duo"). Sendo assim, os jogadores serão apenas um. Se um ganhar, o outro também ganha.<br></p>

### **Baralho de Monstros:**
- 1 - Separar as cartas reais (2, 3, 4, 5, 6, 7, 8, 9, 10, Valete, Dama e Rei. Com excessão dos Ás).
- 2 - Dividir os Valetes, as Damas e os Reis em cartas separadas.
- 3 - Realizar o embaralhamento das cartas de forma aleatoria. Por Exemplo: 1 Rei + 3 cartas de numero + 1 Dama + 3 cartas de numero + 1 Valete + 3 cartas de numero + 1 Rei (até acabar todas as cartas).

### ***Baralho de Heróis:*** 
- 1 - Dessa vez os Ás fazem parte do baralho. 
- 2 - Dividimos entre 4 classes separadas por naipes (Símbolos).<br>
    Naipe de Paus ♣: representa a classe dos Guerreiros. ⚔<br>
    Naipe de Copas ♥: representa a classe dos Paladinos. 🗡<br>
    Naipe de Espadas ♠: representa a classe dos Assassinos. 🔪<br>
    Naipe de Outros ♦: representa a classe dos Magos. ✨<br>
- 3 - Cada jogador deve escolher uma classe (Guerreiros, Paladinos, Assassinos ou Magos). Porém, como o jogo sera realizado em modo solo, então vamos escolher duas classes (exemplo: Guerreiros e Assassinos).
- 4 - O Naipe que sobrar de cor oposta pode ser usado para representar os pontos de vida de cada Herói. Como escolhemos os Guerreiros e os Paladinos, então os naipes de Magos vão ser utilizados como pontos de vida dos Guerreiros e o naipe de Assassinos será utilizado como ponto de vida dos Paladinos.
### **Descrição dos Turnos:**
- **Primeira Fase:**<br>
  Sacamos 3 cartas do baralho de monstros e sacamos 3 cartas para cada herói. O jogador inicia com 13 pontos de vida, simbolizados cada um por cada carta do baralho de vida. Conforme os heróis forem sendo derrotados, suas cartas serão enviadas ao cemitério (baralho de descarte). O mesmo vale para as cartas de vida.
- **Segunda Fase:**<br>
    Realizamos os ataques do herói (fazemos um ataque referente a cada herói utilizado. No nosso caso são dois ataques). Agora escolhemos uma carta ou de Guerreiros ou de Paladinos e, se o numero for maior, podemos derrotar qualquer um dos monstros que tenha nivel menor.<br>
    Se o valor for o mesmo do monstro, então nossa carta é descartada e o monstro é derrotado.
- **Terceira Fase:**<br>
    É realizado o ataque dos monstros. Cada monstro realiza um ataque referente a cor dele. Por exemplo, a carta de cor vermelha pode atacar uma carta de cor vermelha.<br>
    Caso a cor for a mesma, então devemos decidir quem vai atacar quem. Cada monstro realiza um único ataque por turno e um herói pode bloquear um ataque.
    Exemplo: um monstro de nível 2 pode ser bloqueado por uma carta de Ás que o valor é maior, ou se não quiser perder o Ás que é a melhor carta, então podemos receber esse ataque.<br>
    Cada ataque de mostro de número, o herói perde um ponto de vida, que é uma carta sacada do baralho. Se for bloqueado, então a carta do herói impede que a vida do jogador seja atingida.<br>
    São sacadas mais cartas do baralho de monstros, mas não pode passar de 3 cartas.
    No baralho de herois é sacado cartas até completar 3 de cada (por exemplo, 3 Guerreiros e 3 Paladinos).
 
### **Hablidades de cada classe de heróis:**
- ⚔ **Guerreiro:** Unica classe de todas que pode usar cartas de vidas para também atacar.
- 🗡 **Paladinos:** Habilidade de cura. Cada vez que derrota um inimigo ele tem a opção de curar todas as cartas de feridas.
- 🔪 **Assassinos:** Habilidade especial de assassinar. Escolhe duas cartas para poder derrotar qualquer inimigo com qualquer posição e valor, incluindo na área de não bloqueáveis.
- ✨ **Magos:** Pode atacar duas vezes na rodada dos heróis. Existe uma regra específica, sendo que uma das cartas vai atingir os monstros da linha principal e a outra só pode atingir os mostros da linha de não bloqueáveis.<br>  
Na medida que o jogo vai progredindo, vamos acumulando cartas de feridas e elas vão fazer parte do baralho de heróis.
