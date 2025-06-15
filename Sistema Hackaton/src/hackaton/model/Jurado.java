package hackaton.model;

public class Jurado {
    private String nome;
    private String especialidade;
    private String instituicao;
    private Double nota;
    
    public Jurado(String nome, String especialidade, String instituicao) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.instituicao = instituicao;
    }
    
    public String getNome() { return nome; }
    public String getEspecialidade() { return especialidade; }
    public String getInstituicao() { return instituicao; }
    public Double getNota() { return nota; }
    
    public void setNota(double nota) {
        this.nota = nota;
    }
    
    public void avaliar(double nota) {
        setNota(nota);
    }
} 