package hackaton.model;

public class Aluno {
    private String nome;
    private String matricula;
    private String email;
    private String curso;
    private int periodo;
    
    public Aluno(String nome, String matricula, String curso, String email, int periodo) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
        this.email = email;
        this.periodo = periodo;
    }
    
    // Getters
    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
    public String getCurso() { return curso; }
    public String getEmail() { return email; }
    public int getPeriodo() { return periodo; }
    
    @Override
    public String toString() {
        return String.format("Aluno{nome='%s', curso='%s', periodo=%d}", nome, curso, periodo);
    }
} 