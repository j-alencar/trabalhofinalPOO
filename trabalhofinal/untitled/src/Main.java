public class Main {
    public static void main(String[] args) throws InterruptedException {
        Lexico.carregaPalavras();
        GerenciadorJogo.promptPartida();
        GerenciadorJogo.jogarPartida();
    }
}