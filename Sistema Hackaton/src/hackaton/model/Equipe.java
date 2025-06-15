package hackaton.model;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private String nome;
    private List<Aluno> membros;
    private Projeto projeto;
    
    public Equipe(String nome) {
        this.nome = nome;
        this.membros = new ArrayList<>();
    }
    
    public void adicionarMembro(Aluno aluno) {
        membros.add(aluno);
    }
    
    public boolean removerMembro(Aluno aluno) {
        return membros.remove(aluno);
    }
    
    public List<Aluno> getMembros() { return new ArrayList<>(membros); }
    
    public void setProjeto(Projeto projeto) { 
        this.projeto = projeto; 
        projeto.setEquipe(this);
    }
    
    public Projeto getProjeto() { return projeto; }
    public String getNome() { return nome; }
    public int getQuantidadeMembros() { return membros.size(); }
    
    @Override
    public String toString() {
        return String.format("Equipe: %s (Membros: %d)", nome, membros.size());
    }
} 