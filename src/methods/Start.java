package methods;

import java.util.Scanner;

public class Start {
    public static void start(String dicaInicial, int tentativas, boolean temLetra, String palavra, char[] palavraFormada, String palavraGameOver, Scanner tcd){
        System.out.println("\n*JOGO DA FORCA!*\nDigite uma letra para encontrar a palavra\nVocê tem 6 chances de errar\n"
                + dicaInicial);
        char letra;
        while (temLetra == true && tentativas > 0) {
            letra = tcd.next().charAt(0);
            letra = Character.toLowerCase(letra);
            if (palavra.indexOf(letra) != -1) {
                for (int i = 0; i < palavra.length(); i++) {
                    if (letra == palavra.charAt(i))
                        palavraFormada[i] = palavra.charAt(i);
                }
                String resultado = new String(palavraFormada);
                palavra = palavra.replaceAll("(?i)" + letra, " ");
                System.out.println(resultado);
            } else {
                tentativas--;
                Bonequinho.montarBoneco(tentativas);
                if(tentativas ==0) break;
                System.out.println("Letra incorreta! Tente novamente");
                String resultado = new String(palavraFormada);
                System.out.println(resultado);
            }
            for (int i = 0; i < palavra.length(); i++) {
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
        if (tentativas == 0) {
            System.out.println("Fim de jogo!\nA palavra era "+palavraGameOver.toUpperCase()+"\n*********");
        }
        tcd.close();
    }
}
