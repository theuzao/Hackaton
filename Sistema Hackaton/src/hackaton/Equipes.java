package hackaton;

import hackaton.model.Equipe;
import java.util.ArrayList;
import java.util.List;

public class Equipes {
    private static Equipes instance;
    private List<Equipe> equipes;
    
    private Equipes() {
        this.equipes = new ArrayList<>();
    }
    
    public static Equipes getInstance() {
        if (instance == null) {
            instance = new Equipes();
        }
        return instance;
    }
    
    public void adicionarEquipe(Equipe equipe) {
        equipes.add(equipe);
    }
    
    public boolean removerEquipe(Equipe equipe) {
        return equipes.remove(equipe);
    }
    
    public Equipe buscarEquipePorNome(String nome) {
        return equipes.stream()
            .filter(e -> e.getNome().equalsIgnoreCase(nome))
            .findFirst()
            .orElse(null);
    }
    
    public List<Equipe> getEquipes() { return new ArrayList<>(equipes); }
    public int getQuantidadeEquipes() { return equipes.size(); }
    
    public void listarEquipes() {
        equipes.forEach(System.out::println);
    }
} 