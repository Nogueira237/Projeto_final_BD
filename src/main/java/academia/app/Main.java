package academia.app;

import academia.classes.*;
import academia.dao.*;

import java.sql.Connection;
import java.util.ArrayList;

public class Main {
    static void main(String[] args) {

        // ===== TESTE CONEXAO COM BD =====
        /*ConnectionDAO dao = new ConnectionDAO();
        Connection conexao = dao.connectToDb();

        if (conexao != null) {
            System.out.println("Conexão realizada com sucesso!");
        } else {
            System.out.println("Falha na conexão.");
        }*/

        // =========================
        // PLANO
        // =========================
        PlanoDAO planoDAO = new PlanoDAO();

        Plano plano = new Plano("Mensal2", 130, 1);
        planoDAO.insertPlano(plano);

        ArrayList<Plano> planos = planoDAO.selectPlano();
        System.out.println("PLANOS:");
        for (Plano p : planos) {
            System.out.println(
                            "ID: " + p.getId_plano() +
                            " | Nome: " + p.getNome() +
                            " | Valor: " + p.getValor() +
                            " | Duração: " + p.getDuracao()
            );
        };

        // =========================
        // TREINO
        // =========================
        TreinoDAO treinoDAO = new TreinoDAO();

        Treino treino = new Treino("Treino de explosão", "Difícil");
        treinoDAO.insertTreino(treino);

        ArrayList<Treino> treinos = treinoDAO.selectTreino();
        System.out.println("\nTREINOS:");
        for (Treino t : treinos) {
            System.out.println(
                            "ID: " + t.getId_treino() +
                            " | Descrição: " + t.getDescricao() +
                            " | Nível: " + t.getNivel()
            );
        };

        // =========================
        // INSTRUTOR
        // =========================
        InstrutorDAO instrutorDAO = new InstrutorDAO();

        Instrutor instrutor = new Instrutor("Roberto da silva", "Musculação e cardio", 3500);
        instrutorDAO.insertInstrutor(instrutor);

        ArrayList<Instrutor> instrutores = instrutorDAO.selectInstrutor();
        System.out.println("\nINSTRUTORES:");
        for (Instrutor i : instrutores) {
            System.out.println(
                            "ID: " + i.getId_instrutor() +
                            " | Nome: " + i.getNome() +
                            " | Especialidade: " + i.getEspecialidade() +
                            " | Salário: " + i.getSalario()
            );
        }

        // =========================
        // AULA
        // =========================
        AulaDAO aulaDAO = new AulaDAO();

        Aula aula = new Aula("Natação", "08:00:00", 20, 1);
        aulaDAO.insertAula(aula);

        ArrayList<Aula> aulas = aulaDAO.selectAula();
        System.out.println("\nAULAS:");
        for (Aula a : aulas) {
            System.out.println(
                            "ID: " + a.getId_aula() +
                            " | Nome: " + a.getNome() +
                            " | Horário: " + a.getHorario() +
                            " | Capacidade: " + a.getCapacidade() +
                            " | Instrutor ID: " + a.getInstrutor_id_instrutor()
            );
        }
        // =========================
        // ALUNO
        // =========================
        AlunoDAO alunoDAO = new AlunoDAO();

        Aluno aluno = new Aluno(
                "Henrique Martins",
                "111.222.333-44",
                "2003-05-14",
                "(32)99999-1111",
                1, // treino
                1  // plano
        );

        alunoDAO.insertAluno(aluno);

        ArrayList<Aluno> alunos = alunoDAO.selectAluno();
        System.out.println("\nALUNOS:");
        for (Aluno al : alunos) {
            System.out.println(
                            "ID: " + al.getId_aluno() +
                            " | Nome: " + al.getNome() +
                            " | CPF: " + al.getCpf() +
                            " | Data Nasc: " + al.getData_nascimento() +
                            " | Telefone: " + al.getTelefone() +
                            " | Treino ID: " + al.getTreino_id_treino() +
                            " | Plano ID: " + al.getPlano_id_plano()
            );
        };

        // =========================
        // PAGAMENTO
        // =========================
        PagamentoDAO pagamentoDAO = new PagamentoDAO();

        Pagamento pagamento = new Pagamento(
                130,
                "2026-06-05",
                "SIM",
                1 // aluno
        );

        pagamentoDAO.insertPagamento(pagamento);

        ArrayList<Pagamento> pagamentos = pagamentoDAO.selectPagamento();
        System.out.println("\nPAGAMENTOS:");
        for (Pagamento pg : pagamentos) {
            System.out.println(
                            "ID: " + pg.getId_pagamento() +
                            " | Valor: " + pg.getValor() +
                            " | Data: " + pg.getData_pagamento() +
                            " | Pago: " + pg.getPago() +
                            " | Aluno ID: " + pg.getAluno_id_aluno()
            );
        };

        // =========================
        // ALUNO_HAS_AULA (N:N)
        // =========================
        AlunoHasAulaDAO ahaDAO = new AlunoHasAulaDAO();

        AlunoHasAula relacao = new AlunoHasAula(4, 2);
        ahaDAO.insertAlunoHasAula(relacao);

        ArrayList<AlunoHasAula> relacoes = ahaDAO.selectAlunoHasAula();
        System.out.println("\nMATRÍCULAS:");
        for (AlunoHasAula r : relacoes) {
            System.out.println(
                            "Aluno ID: " + r.getAluno_id_aluno() +
                            " | Aula ID: " + r.getAula_id_aula()
            );
        };

        System.out.println("\n=== TESTE FINALIZADO COM SUCESSO ===");

    }

};
