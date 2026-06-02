import java.util.Set;
import java.util.TreeSet;

public class CadastroNomes {

    private Set<String> nomes;

    public CadastroNomes() {
        nomes = new TreeSet<>();
    }

    public void adicionarNome(String nome) {
        nomes.add(nome.toLowerCase());
    }

    public boolean pesquisarNome(String nome) {
        return nomes.contains(nome.toLowerCase());
    }

    public Set<String> getNomes() {
        return nomes;
    }
}