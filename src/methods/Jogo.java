package methods;

import java.util.Random;
import java.util.Scanner;
import enums.Palavra;

public class Jogo {
    public static void executar() {
        Random palavras = new Random();
        int tentativas = 6;

        int total = Palavra.totalPalavras();
        String palavra = Palavra.fromValor(palavras.nextInt(total) + 1).toString().toLowerCase();
        String palavraGameOver = palavra;

        char[] palavraFormada = new char[palavra.length()];
        boolean temLetra = true;

        for (int i = 0; i < palavraFormada.length; i++) {
            palavraFormada[i] = '_';
        }
        String dicaInicial = new String(palavraFormada);
        Scanner tcd = new Scanner(System.in);

        System.out.println("\n*JOGO DA FORCA!*\nDigite uma letra para encontrar a palavra\nVocê tem 6 chances de errar\n"
                + dicaInicial);
        while (temLetra == true && tentativas > 0) {
            char letra = tcd.next().charAt(0);
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
            System.out.println("*********\nFim de jogo!\nA palavra era "+palavraGameOver.toUpperCase());
        }
        tcd.close();
    }
}
