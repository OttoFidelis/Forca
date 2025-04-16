package methods;

import java.util.Scanner;

public class Start {
    /*O método pede todas as variáveis necessárias para executar o código
    dicaInicial: exibe todos as underlines do começo do jogo, que mostram quantas letras a palavra possui
    tentativas: número de tentativas restantes
    temLetra: verifica se ainda restam letras a serem encontradas
    palavra: palavra que deve ser encontrada, que vai sendo substituída por " " quando o jogador encontra as letras corretas
    palavraFormada: letras da palavra que o jogador encontrou
    palavraGameOver: a palavra correta, que é exibida quando o jogador perde
    tcd: Scanner de teclado que recebe os inputs de letras
    */
    public static void start(String dicaInicial, int tentativas, boolean temLetra, String palavra,
            char[] palavraFormada, String palavraGameOver, Scanner tcd) {
        System.out.println(
                "\n*JOGO DA FORCA!*\nDigite uma letra para encontrar a palavra\nVocê tem 6 chances de errar\nVocê pode digitar mais de uma letra de uma vez, porém, você perderá uma chance para cada letra errada\n"
                        + dicaInicial);
        while (temLetra == true && tentativas > 0) {
            String letraDigitada = tcd.nextLine();
            char[] letras = new char[letraDigitada.length()]; //Esse código verifica quantas letras o usuário digitou//

            for (char letra : letras) { //O for serve para executar o código para cada letra digitada//
                letra = letraDigitada.charAt(letra); //o caracter letra recebe a letra digitada (ou uma delas)//
                letra = Character.toLowerCase(letra);
                if (palavra.indexOf(letra) != -1){  //Verifica se a letra realmente faz parte da palavra//
                    for (int i = 0; i < palavra.length(); i++) {
                        if (letra == palavra.charAt(i))
                            palavraFormada[i] = palavra.charAt(i);
                    }
                    String resultado = new String(palavraFormada); //Resultado representa o quanto da palavra sorteada o jogadot descobriu//
                    palavra = palavra.replaceAll("(?i)" + letra, " ");  //Em palavra, a letra digitada, se correta, é substituída por um espaço vazio//
                    System.out.println(resultado);
                    }
                 else {
                    tentativas--;
                    Bonequinho.montarBoneco(tentativas);  //Em caso de dúvidas, consulte a classe Bonequinho//
                    if (tentativas == 0)
                        break;
                    System.out.println("Letra incorreta! Tente novamente");
                    String resultado = new String(palavraFormada);
                    System.out.println(resultado);
                }
                for (int i = 0; i < palavra.length(); i++) { //Verifica se ainda restam letras a serem descobertas//
                    if (Character.isLetter(palavra.charAt(i))) {
                        temLetra = true;
                        break;
                    } else if (i == palavra.length() - 1) {
                        temLetra = false;
                        System.out.println("Você ganhou!!");
                        break;
                    }
                }
            }
        }
        if (tentativas == 0) {
            System.out.println("Fim de jogo!\nA palavra era " + palavraGameOver.toUpperCase() + "\n*********");
        }
        tcd.close();
    }
}
