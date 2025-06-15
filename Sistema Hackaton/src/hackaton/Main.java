package hackaton;

import hackaton.model.*;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE HACKATHON UNIVERSITÁRIO ===\n");
        
        // Obter instâncias dos singletons
        Equipes gerenciadorEquipes = Equipes.getInstance();
        Apresentacoes gerenciadorApresentacoes = Apresentacoes.getInstance();
        
        // Criar primeira equipe com 5 alunos
        Equipe equipe1 = new Equipe("Nets");
        equipe1.adicionarMembro(new Aluno("Kevin Durant", "2021001", "Eng. Software", "durant@nets.com", 6));
        equipe1.adicionarMembro(new Aluno("James Harden", "2021002", "Ciência da Computação", "harden@nets.com", 5));
        equipe1.adicionarMembro(new Aluno("Kyrie Irving", "2021003", "Eng. Software", "irving@nets.com", 6));
        equipe1.adicionarMembro(new Aluno("Blake Griffin", "2021004", "Sistemas de Informação", "griffin@nets.com", 4));
        equipe1.adicionarMembro(new Aluno("Joe Harris", "2021005", "Eng. Software", "harris@nets.com", 7));
        
        // Criar segunda equipe com 5 alunos
        Equipe equipe2 = new Equipe("Bucks");
        equipe2.adicionarMembro(new Aluno("Giannis Antetokounmpo", "2021006", "Ciência da Computação", "giannis@bucks.com", 5));
        equipe2.adicionarMembro(new Aluno("Khris Middleton", "2021007", "Eng. Software", "middleton@bucks.com", 6));
        equipe2.adicionarMembro(new Aluno("Jrue Holiday", "2021008", "Sistemas de Informação", "holiday@bucks.com", 4));
        equipe2.adicionarMembro(new Aluno("Brook Lopez", "2021009", "Eng. Software", "lopez@bucks.com", 5));
        equipe2.adicionarMembro(new Aluno("Bobby Portis", "2021010", "Ciência da Computação", "portis@bucks.com", 6));
        
        // Adicionar equipes ao gerenciador
        gerenciadorEquipes.adicionarEquipe(equipe1);
        gerenciadorEquipes.adicionarEquipe(equipe2);
        
        // Criar projetos diferentes para cada equipe
        Projeto projeto1 = new Projeto(
            "FocusFlow",
            "Aplicativo de produtividade com técnicas de Pomodoro e gamificação",
            "React Native, Firebase, Node.js, MongoDB, Redux"
        );
        
        Projeto projeto2 = new Projeto(
            "AprendeAI",
            "Plataforma de aprendizado adaptativo com inteligência artificial",
            "Python, TensorFlow, React, FastAPI, PostgreSQL"
        );
        
        // Associar projetos às equipes
        equipe1.setProjeto(projeto1);
        equipe2.setProjeto(projeto2);
        
        // Criar e configurar apresentações com bancas
        configurarApresentacaoCompleta(projeto1, gerenciadorApresentacoes, 
            new double[]{9.0, 8.5, 8.0, 9.5});
        configurarApresentacaoCompleta(projeto2, gerenciadorApresentacoes, 
            new double[]{6.0, 6.5, 5.5, 6.0});
        
        exibirResultados(gerenciadorEquipes, gerenciadorApresentacoes);
    }
    
    private static void configurarApresentacaoCompleta(Projeto projeto, Apresentacoes gerenciador, double[] notas) {
        Apresentacao apresentacao = new Apresentacao(projeto, LocalDateTime.now().plusDays(1), 15);
        projeto.setApresentacao(apresentacao);
        
        // Criar banca 
        BancaAvaliadora banca = new BancaAvaliadora();
        String[] nomesJurados = {"Prof. Michael Jordan", "Dr. Magic Johnson", "Prof. Larry Bird", "Dr. Hakeem Olajuwon"};
        String[] especialidades = {"Engenharia de Software", "Sistemas Distribuídos", "IoT e Sustentabilidade", "Desenvolvimento Mobile"};
        String[] instituicoes = {"PUC Minas", "UFMG", "CEFET-MG", "PUC Minas"};
        
        for (int i = 0; i < 4; i++) {
            Jurado jurado = new Jurado(nomesJurados[i], especialidades[i], instituicoes[i]);
            jurado.avaliar(notas[i]);
            banca.adicionarJurado(jurado);
        }
        
        apresentacao.setBanca(banca);
        gerenciador.adicionarApresentacao(apresentacao);
    }
    
    private static void exibirResultados(Equipes gerenciadorEquipes, Apresentacoes gerenciadorApresentacoes) {
        System.out.println("\nEQUIPES CADASTRADAS:");
        gerenciadorEquipes.listarEquipes();
        
        System.out.println("\nPROJETOS E SUAS NOTAS:");
        gerenciadorApresentacoes.getApresentacoes().forEach(ap -> {
            Projeto p = ap.getProjeto();
            System.out.printf("• %s - Nota Final: %.2f\n", p.getTitulo(), p.getNotaFinal());
        });
        
        // Listar projetos aprovados (nota >= 7) usando Stream
        System.out.println("\nPROJETOS APROVADOS (Nota ≥ 7.0):");
        List<Projeto> projetosAprovados = gerenciadorApresentacoes.listarProjetosAprovados(7.0);
        
        if (projetosAprovados.isEmpty()) {
            System.out.println("Nenhum projeto foi aprovado com nota >= 7.0");
        } else {
            projetosAprovados.forEach(p -> 
                System.out.printf("• %s (Equipe: %s) - Nota: %.2f\n", 
                    p.getTitulo(), 
                    p.getEquipe().getNome(), 
                    p.getNotaFinal())
            );
        }
    }
} 