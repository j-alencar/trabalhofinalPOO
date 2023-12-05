import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciadorJogo{
    public static void promptPartida() throws InterruptedException {
        System.out.println("Bem-vindo ao trabalho final de POO-I: 'Quantas Palavras?' !!!");
        Thread.sleep(3000);
        System.out.println("O jogo começará em 5 segundos! Digite o máximo de palavras com a letra inicial sorteada que conseguir.");
        System.out.println("Pronto?");
        Thread.sleep(5000);
    }
    public static void jogarPartida() throws InterruptedException {
        Lexico.sortearLetraAleatoria();
        System.out.println("Letra sorteada: " + Lexico.getLetraSorteada());
        System.out.println("Digite!");
        Thread.sleep(500);

        long tempo = System.currentTimeMillis();               //Timer, 15 segundos
        long tempofim = tempo + 15000;

        ArrayList<String> palavrasJogador = new ArrayList<>(); //Lista de inputs do jogador, para verificação
        Scanner leitor = new Scanner(System.in);

        while (System.currentTimeMillis() < tempofim) {

            String inputJogador = leitor.nextLine();
            //Verifica se o input do jogador é válido para a letra sorteada
            if (inputJogador.length() >= 4 &&
                    inputJogador.toUpperCase().charAt(0) == Lexico.letraSorteada &&
                    validarInput(inputJogador, Lexico.getLetraSorteada()) == true &&
                    !palavrasJogador.contains(inputJogador)) {
                System.out.println("✔ Boa!");
                palavrasJogador.add(inputJogador);
            }
            else if (palavrasJogador.contains(inputJogador)) {
                System.out.println("✘ Entrada repetida!");
            }
            else if (inputJogador.equals("/quit")) {
                System.out.println("Até mais!");
                System.exit(0);
            }
            else {
                System.out.println("✘ Entrada inválida!");
            }
        }
        System.out.println("O tempo acabou! Você digitou um total de " + palavrasJogador.size() + " palavras válidas. Elas foram:");
        System.out.println(palavrasJogador);
    }

    //Método para validar se a entrada do jogador é válida
    public static boolean validarInput(String input, char letraSorteada) {
        //Obtém a lista associada à letra sorteada do mapaAlfabetico
        List<String> palavrasMapa = Lexico.mapaAlfabetico.get(letraSorteada);

        if (palavrasMapa != null) {
            for (String palavra : palavrasMapa) {
                //Obtém as palavras da lista e remove os colchetes
                String palavraIterada = palavra.substring(1, palavra.length() - 1);
                //Verifica se a palavra na lista é igual a entrada do jogador
                if (palavraIterada.equals(input)) {
                    return true;
                }
            }
        }
        return false;
    }
}
