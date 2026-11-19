import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/** Testes autônomos do console, sem dependências externas (Java 21). */
public final class DuplicateNamesAppTest {
    private static int testes = 0;

    private static String executar(String entrada) {
        InputStream entradaOriginal = System.in;
        PrintStream saidaOriginal = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            System.setIn(new ByteArrayInputStream(entrada.getBytes(StandardCharsets.UTF_8)));
            System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
            DuplicateNamesApp.main(new String[0]);
            return buffer.toString(StandardCharsets.UTF_8);
        } finally {
            System.setIn(entradaOriginal);
            System.setOut(saidaOriginal);
        }
    }

    private static void contem(String nome, String entrada, String esperado) {
        String saida = executar(entrada);
        if (!saida.contains(esperado)) {
            throw new AssertionError(nome + " — esperado trecho: " + esperado + "\nSaída:\n" + saida);
        }
        testes++;
        System.out.println("OK: " + nome);
    }

    private static void ocorrencias(String nome, String entrada, String trecho, int esperado) {
        String saida = executar(entrada);
        int encontrado = 0;
        for (int inicio = 0; (inicio = saida.indexOf(trecho, inicio)) != -1; inicio += trecho.length()) {
            encontrado++;
        }
        if (encontrado != esperado) {
            throw new AssertionError(nome + " — esperado " + esperado + " ocorrências de " + trecho
                    + "; recebidas " + encontrado + "\nSaída:\n" + saida);
        }
        testes++;
        System.out.println("OK: " + nome);
    }

    public static void main(String[] args) {
        String exemplo = "Ana\nBruno\nana\nCarlos\nFIM\nbruno\njoão\nsair\n";
        contem("exemplo do professor e ordem alfabética", exemplo, "[Ana, Bruno, Carlos]");
        ocorrencias("pesquisa repetida positiva/negativa", exemplo, "Nome encontrado.", 1);
        contem("pesquisa inexistente", exemplo, "Nome não encontrado.");
        contem("deduplicação case-insensitive", "zÉlia\nZÉLIA\nMARIA\nmaria\nfim\nsair\n", "[MARIA, zÉlia]");
        contem("nomes não ordenados de entrada", "Zoe\nAna\nBia\nfim\nsair\n", "[Ana, Bia, Zoe]");
        contem("espaços nas extremidades", "  Ana  \nana\nfim\n ANA \nsair\n", "[Ana]");
        ocorrencias("busca com espaços é positiva", "  Ana  \nana\nfim\n ANA \nsair\n", "Nome encontrado.", 1);
        contem("entrada vazia", "fim\nsair\n", "Nomes cadastrados:\n[]");
        contem("linha em branco ignorada", "\nAna\n  \nfim\nsair\n", "[Ana]");
        contem("fim ignorando caixa e espaços", "Ana\n Fim \nAna\nsair\n", "[Ana]");
        contem("sair ignorando caixa e espaços", "Ana\nfim\n SaIr \n", "Pesquisar nomes (digite 'sair' para encerrar):");
        ocorrencias("mais de uma busca", "Ana\nBia\nfim\nana\nbia\nZoe\nsair\n",
                "Nome encontrado.", 2);
        ocorrencias("busca negativa múltipla", "Ana\nfim\nZoe\nBia\nsair\n",
                "Nome não encontrado.", 2);
        contem("fim de arquivo sem sentinela", "Ana\nBia\n", "[Ana, Bia]");
        System.out.println("TESTES_OK: " + testes + " cenários validados");
    }
}
