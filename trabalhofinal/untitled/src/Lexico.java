import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Lexico {
    public static HashMap<Character, List<String>> mapaAlfabetico = new HashMap<>();
    public static void carregaPalavras() {
        String caminho = "br-sem-acentos.csv";
        //.txt transformado em .csv usando Ctrl+F no Notepad++
        //Considerando que é um jogo baseado em velocidade de tipagem, desconsiderar acentos parece uma boa ideia

        //String para armazenar cada linha lida do arquivo
        String linha = "";
        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(caminho));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            try {
                if ((linha = br.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            String[] values = linha.split(","); //Separa por vírgulas por ser .csv

            if (linha.length() > 0) {
                char primeiraletra = linha.toUpperCase().charAt(0); //Armazena letras iniciais como maiúsculas

                if (!mapaAlfabetico.containsKey(primeiraletra))    //Verifica se a chave já existe no mapa, se não existir, cria uma nova lista para a chave
                {
                    mapaAlfabetico.put(primeiraletra, new ArrayList<>());
                }

                //Adiciona os valores à lista associada à chave
                mapaAlfabetico.get(primeiraletra).add(Arrays.toString(values));
            }
        }
    }
    public static char letraSorteada;
    public static void sortearLetraAleatoria() {
        //Obtem as letras do mapaAlfabetico numa lista
        List<Character> chaves = new ArrayList<>(Lexico.mapaAlfabetico.keySet());

        //Escolhe as letras aleatoriamente
        Random random = new Random();
        int indice = random.nextInt(chaves.size());
        letraSorteada = chaves.get(indice);
    }
    public static char getLetraSorteada() {
        return letraSorteada;
    }
}



