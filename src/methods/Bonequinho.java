package methods;

public class Bonequinho {
    public static void montarBoneco(int tentativas){
        switch (tentativas) {
            case 5:
            System.out.println("*********\n---\n  |\n  0\n*********");
                break;
            
            case 4:
            System.out.println("*********\n---\n  |\n  0\n  |\n*********");
                break;

            case 3:
            System.out.println("*********\n---\n  |\n \\0\n  |\n*********");
                break;

            case 2:
            System.out.println("*********\n---\n  |\n \\0/\n  |\n*********");
                break;
            case 1:
            System.out.println("*********\n---\n  |\n \\0/\n  |\n   \\\n*********");
                break;
            case 0:
            System.out.println("*********\n---\n  |\n \\0/\n  |\n / \\\n*********");
                break;

        }
    }
    
}
