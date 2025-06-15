package hackaton;

import hackaton.model.Jurado;
import hackaton.model.Apresentacao;
import java.util.ArrayList;
import java.util.List;

public class BancaAvaliadora {
    private List<Jurado> jurados;
    private Apresentacao apresentacao;
    
    public BancaAvaliadora() {
        this.jurados = new ArrayList<>();
    }
    
    public void adicionarJurado(Jurado jurado) {
        jurados.add(jurado);
    }
    
    public boolean removerJurado(Jurado jurado) {
        return jurados.remove(jurado);
    }
    
    public List<Jurado> getJurados() { return new ArrayList<>(jurados); }
    
    public void setApresentacao(Apresentacao apresentacao) {
        this.apresentacao = apresentacao;
    }
    
    public Apresentacao getApresentacao() { return apresentacao; }
    
    public double calcularMediaNotas() {
        if (jurados.isEmpty()) return 0.0;
        
        double soma = jurados.stream()
            .filter(j -> j.getNota() != null)
            .mapToDouble(Jurado::getNota)
            .sum();
        
        long quantidadeNotas = jurados.stream()
            .filter(j -> j.getNota() != null)
            .count();
        
        return quantidadeNotas > 0 ? soma / quantidadeNotas : 0.0;
    }
    
    public int getQuantidadeJurados() { return jurados.size(); }
} 