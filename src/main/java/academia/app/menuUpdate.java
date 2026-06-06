package academia.app;

import academia.classes.*;
import academia.dao.*;

import java.util.Scanner;

public class menuUpdate {

    public void executar(Scanner scanner) {

        int opcao;

        System.out.println("\n===== MENU UPDATE =====");
        System.out.println("1 - Aluno");
        System.out.println("2 - Plano");
        System.out.println("3 - Treino");
        System.out.println("4 - Instrutor");
        System.out.println("5 - Aula");
        System.out.println("6 - Pagamento");

        opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {

            // ================= ALUNO =================
            case 1 -> {
                AlunoDAO dao = new AlunoDAO();

                System.out.print("ID do aluno: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Aluno aluno = dao.selectById(id);

                if (aluno == null) {
                    System.out.println("Aluno não encontrado.");
                    return;
                }

                System.out.println("[1] Nome");
                System.out.println("[2] CPF");
                System.out.println("[3] Data nascimento");
                System.out.println("[4] Telefone");
                System.out.println("[5] ID Treino");
                System.out.println("[6] ID Plano");

                int op = scanner.nextInt();
                scanner.nextLine();

                switch (op) {
                    case 1 -> aluno.setNome(scanner.nextLine());
                    case 2 -> aluno.setCpf(scanner.nextLine());
                    case 3 -> aluno.setData_nascimento(scanner.nextLine());
                    case 4 -> aluno.setTelefone(scanner.nextLine());
                    case 5 -> aluno.setTreino_id_treino(scanner.nextInt());
                    case 6 -> aluno.setPlano_id_plano(scanner.nextInt());
                }

                dao.updateAluno(id, aluno);
                System.out.println("Aluno atualizado!");
            }

            // ================= PLANO =================
            case 2 -> {
                PlanoDAO dao = new PlanoDAO();

                System.out.print("ID do plano: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Plano plano = dao.selectById(id);

                if (plano == null) {
                    System.out.println("Plano não encontrado.");
                    return;
                }

                System.out.println("[1] Nome");
                System.out.println("[2] Valor");
                System.out.println("[3] Duração");

                int op = scanner.nextInt();
                scanner.nextLine();

                switch (op) {
                    case 1 -> plano.setNome(scanner.nextLine());
                    case 2 -> plano.setValor(scanner.nextDouble());
                    case 3 -> plano.setDuracao(scanner.nextInt());
                }

                dao.updatePlano(id, plano);
                System.out.println("Plano atualizado!");
            }

            // ================= TREINO =================
            case 3 -> {
                TreinoDAO dao = new TreinoDAO();

                System.out.print("ID do treino: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Treino treino = dao.selectById(id);

                if (treino == null) {
                    System.out.println("Treino não encontrado.");
                    return;
                }

                System.out.println("[1] Descrição");
                System.out.println("[2] Nível");

                int op = scanner.nextInt();
                scanner.nextLine();

                switch (op) {
                    case 1 -> treino.setDescricao(scanner.nextLine());
                    case 2 -> treino.setNivel(scanner.nextLine());
                }

                dao.updateTreino(id, treino);
                System.out.println("Treino atualizado!");
            }

            // ================= INSTRUTOR =================
            case 4 -> {
                InstrutorDAO dao = new InstrutorDAO();

                System.out.print("ID do instrutor: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Instrutor i = dao.selectById(id);

                if (i == null) {
                    System.out.println("Instrutor não encontrado.");
                    return;
                }

                System.out.println("[1] Nome");
                System.out.println("[2] Especialidade");
                System.out.println("[3] Salário");

                int op = scanner.nextInt();
                scanner.nextLine();

                switch (op) {
                    case 1 -> i.setNome(scanner.nextLine());
                    case 2 -> i.setEspecialidade(scanner.nextLine());
                    case 3 -> i.setSalario(scanner.nextDouble());
                }

                dao.updateInstrutor(id, i);
                System.out.println("Instrutor atualizado!");
            }

            // ================= AULA =================
            case 5 -> {
                AulaDAO dao = new AulaDAO();

                System.out.print("ID da aula: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Aula a = dao.selectById(id);

                if (a == null) {
                    System.out.println("Aula não encontrada.");
                    return;
                }

                System.out.println("[1] Nome");
                System.out.println("[2] Horário");
                System.out.println("[3] Capacidade");
                System.out.println("[4] Instrutor ID");

                int op = scanner.nextInt();
                scanner.nextLine();

                switch (op) {
                    case 1 -> a.setNome(scanner.nextLine());
                    case 2 -> a.setHorario(scanner.nextLine());
                    case 3 -> a.setCapacidade(scanner.nextInt());
                    case 4 -> a.setInstrutor_id_instrutor(scanner.nextInt());
                }

                dao.updateAula(id, a);
                System.out.println("Aula atualizada!");
            }

            // ================= PAGAMENTO =================
            case 6 -> {
                PagamentoDAO dao = new PagamentoDAO();

                System.out.print("ID do pagamento: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                Pagamento p = dao.selectById(id);

                if (p == null) {
                    System.out.println("Pagamento não encontrado.");
                    return;
                }

                System.out.println("[1] Valor");
                System.out.println("[2] Data");
                System.out.println("[3] Pago");
                System.out.println("[4] ID Aluno");

                int op = scanner.nextInt();
                scanner.nextLine();

                switch (op) {
                    case 1 -> p.setValor(scanner.nextDouble());
                    case 2 -> p.setData_pagamento(scanner.nextLine());
                    case 3 -> p.setPago(scanner.nextLine());
                    case 4 -> p.setAluno_id_aluno(scanner.nextInt());
                }

                dao.updatePagamento(id, p);
                System.out.println("Pagamento atualizado!");
            }

            // ================= Aluno has Aula =================
            case 7 -> {

                AlunoHasAulaDAO dao = new AlunoHasAulaDAO();

                System.out.print("ID do aluno atual: ");
                int idAluno = scanner.nextInt();

                System.out.print("ID da aula atual: ");
                int idAula = scanner.nextInt();

                scanner.nextLine();

                // Busca vínculo atual
                AlunoHasAula relacao = dao.selectByIds(idAluno, idAula);

                if (relacao == null) {
                    System.out.println("Vínculo não encontrado.");
                    return;
                }

                System.out.println("O que deseja alterar?");
                System.out.println("[1] Trocar aluno");
                System.out.println("[2] Trocar aula");

                int op = scanner.nextInt();
                scanner.nextLine();

                int novoAluno = idAluno;
                int novaAula = idAula;

                switch (op) {

                    case 1 -> {
                        System.out.print("Novo ID do aluno: ");
                        novoAluno = scanner.nextInt();
                    }

                    case 2 -> {
                        System.out.print("Nova ID da aula: ");
                        novaAula = scanner.nextInt();
                    }

                    default -> {
                        System.out.println("Opção inválida.");
                        return;
                    }
                }

                dao.updateRelacao(idAluno, idAula, novoAluno, novaAula);

                System.out.println("Vínculo atualizado com sucesso!");
            }


        }
    }
}