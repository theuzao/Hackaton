package hackaton.model;

import java.time.LocalDateTime;
import hackaton.BancaAvaliadora;

public class Apresentacao {
    private Projeto projeto;
    private BancaAvaliadora banca;
    private LocalDateTime dataHora;
    private int duracaoMinutos;
    
    public Apresentacao(Projeto projeto, LocalDateTime dataHora, int duracaoMinutos) {
        this.projeto = projeto;
        this.dataHora = dataHora;
        this.duracaoMinutos = duracaoMinutos;
    }
    
    public void setProjeto(Projeto projeto) { this.projeto = projeto; }
    public Projeto getProjeto() { return projeto; }
    
    public void setBanca(BancaAvaliadora banca) { 
        this.banca = banca; 
        banca.setApresentacao(this);
    }
    
    public BancaAvaliadora getBanca() { return banca; }
    public LocalDateTime getDataHora() { return dataHora; }
    public int getDuracaoMinutos() { return duracaoMinutos; }
    
    public double calcularNotaFinal() {
        return banca != null ? banca.calcularMediaNotas() : 0.0;
    }
} 