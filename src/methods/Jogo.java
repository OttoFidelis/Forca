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

        Inicio.start(dicaInicial, tentativas, temLetra, palavra, palavraFormada, palavraGameOver, tcd);
    }
}
