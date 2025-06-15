package hackaton;

import hackaton.model.Apresentacao;
import hackaton.model.Projeto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Apresentacoes {
    private static Apresentacoes instance;
    private List<Apresentacao> apresentacoes;
    
    private Apresentacoes() {
        this.apresentacoes = new ArrayList<>();
    }
    
    public static Apresentacoes getInstance() {
        if (instance == null) {
            instance = new Apresentacoes();
        }
        return instance;
    }
    
    public void adicionarApresentacao(Apresentacao apresentacao) {
        apresentacoes.add(apresentacao);
    }
    
    public boolean removerApresentacao(Apresentacao apresentacao) {
        return apresentacoes.remove(apresentacao);
    }
    
    public Apresentacao buscarApresentacaoPorProjeto(Projeto projeto) {
        return apresentacoes.stream()
            .filter(a -> a.getProjeto().equals(projeto))
            .findFirst()
            .orElse(null);
    }
    
    public List<Apresentacao> getApresentacoes() { return new ArrayList<>(apresentacoes); }
    public int getQuantidadeApresentacoes() { return apresentacoes.size(); }
    
    public List<Projeto> listarProjetosAprovados(double notaMinima) {
        return apresentacoes.stream()
            .map(Apresentacao::getProjeto)
            .filter(p -> p.getNotaFinal() >= notaMinima)
            .collect(Collectors.toList());
    }
} 