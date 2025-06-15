package hackaton.model;

public class Projeto {
    private String titulo;
    private String descricao;
    private String tecnologias;
    private Equipe equipe;
    private Apresentacao apresentacao;
    
    public Projeto(String titulo, String descricao, String tecnologias) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.tecnologias = tecnologias;
    }
    
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public String getTecnologias() { return tecnologias; }
    
    public void setEquipe(Equipe equipe) { this.equipe = equipe; }
    public Equipe getEquipe() { return equipe; }
    
    public void setApresentacao(Apresentacao apresentacao) { 
        this.apresentacao = apresentacao; 
    }
    
    public Apresentacao getApresentacao() { return apresentacao; }
    
    public double getNotaFinal() {
        return apresentacao != null ? apresentacao.calcularNotaFinal() : 0.0;
    }
    
    @Override
    public String toString() {
        return String.format("Projeto: %s (Nota: %.2f)", titulo, getNotaFinal());
    }
} 