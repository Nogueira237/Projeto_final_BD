package academia.app;

import academia.classes.*;
import academia.dao.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class menuUpdate {

    private int lerInt(Scanner scanner, String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erro: digite um número válido.");
                scanner.nextLine();
            }
        }
    }

    private double lerDouble(Scanner scanner, String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Erro: digite um número decimal válido.");
                scanner.nextLine();
            }
        }
    }

    private String lerString(Scanner scanner, String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    public void executar(Scanner scanner) {

        int opcao;

        try {
            System.out.println("\n===== MENU UPDATE =====");
            System.out.println("1 - Aluno");
            System.out.println("2 - Plano");
            System.out.println("3 - Treino");
            System.out.println("4 - Instrutor");
            System.out.println("5 - Aula");
            System.out.println("6 - Pagamento");
            System.out.println("7 - Aluno_has_Aula");

            opcao = scanner.nextInt();
            scanner.nextLine();

        } catch (InputMismatchException e) {
            System.out.println("Opção inválida.");
            scanner.nextLine();
            return;
        }

        switch (opcao) {

            // ================= ALUNO =================
            case 1 -> {
                try {
                    AlunoDAO dao = new AlunoDAO();

                    int id = lerInt(scanner, "ID do aluno: ");

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

                    int op = lerInt(scanner, "Escolha: ");

                    switch (op) {
                        case 1 -> aluno.setNome(lerString(scanner, "Novo nome: "));
                        case 2 -> aluno.setCpf(lerString(scanner, "Novo CPF: "));
                        case 3 -> aluno.setData_nascimento(lerString(scanner, "Nova data: "));
                        case 4 -> aluno.setTelefone(lerString(scanner, "Novo telefone: "));
                        case 5 -> aluno.setTreino_id_treino(lerInt(scanner, "Novo ID treino: "));
                        case 6 -> aluno.setPlano_id_plano(lerInt(scanner, "Novo ID plano: "));
                        default -> {
                            System.out.println("Opção inválida.");
                            return;
                        }
                    }

                    dao.updateAluno(id, aluno);
                    System.out.println("Aluno atualizado!");

                } catch (Exception e) {
                    System.out.println("Erro ao atualizar aluno: " + e.getMessage());
                }
            }

            // ================= PLANO =================
            case 2 -> {
                try {
                    PlanoDAO dao = new PlanoDAO();

                    int id = lerInt(scanner, "ID do plano: ");

                    Plano plano = dao.selectById(id);
                    if (plano == null) {
                        System.out.println("Plano não encontrado.");
                        return;
                    }

                    System.out.println("[1] Nome");
                    System.out.println("[2] Valor");
                    System.out.println("[3] Duração");

                    int op = lerInt(scanner, "Escolha: ");

                    switch (op) {
                        case 1 -> plano.setNome(lerString(scanner, "Novo nome: "));
                        case 2 -> plano.setValor(lerDouble(scanner, "Novo valor: "));
                        case 3 -> plano.setDuracao(lerInt(scanner, "Nova duração: "));
                        default -> {
                            System.out.println("Opção inválida.");
                            return;
                        }
                    }

                    dao.updatePlano(id, plano);
                    System.out.println("Plano atualizado!");

                } catch (Exception e) {
                    System.out.println("Erro ao atualizar plano: " + e.getMessage());
                }
            }

            // ================= TREINO =================
            case 3 -> {
                try {
                    TreinoDAO dao = new TreinoDAO();

                    int id = lerInt(scanner, "ID do treino: ");

                    Treino treino = dao.selectById(id);
                    if (treino == null) {
                        System.out.println("Treino não encontrado.");
                        return;
                    }

                    System.out.println("[1] Descrição");
                    System.out.println("[2] Nível");

                    int op = lerInt(scanner, "Escolha: ");

                    switch (op) {
                        case 1 -> treino.setDescricao(lerString(scanner, "Nova descrição: "));
                        case 2 -> treino.setNivel(lerString(scanner, "Novo nível: "));
                        default -> {
                            System.out.println("Opção inválida.");
                            return;
                        }
                    }

                    dao.updateTreino(id, treino);
                    System.out.println("Treino atualizado!");

                } catch (Exception e) {
                    System.out.println("Erro ao atualizar treino: " + e.getMessage());
                }
            }

            // ================= INSTRUTOR =================
            case 4 -> {
                try {
                    InstrutorDAO dao = new InstrutorDAO();

                    int id = lerInt(scanner, "ID do instrutor: ");

                    Instrutor i = dao.selectById(id);
                    if (i == null) {
                        System.out.println("Instrutor não encontrado.");
                        return;
                    }

                    System.out.println("[1] Nome");
                    System.out.println("[2] Especialidade");
                    System.out.println("[3] Salário");

                    int op = lerInt(scanner, "Escolha: ");

                    switch (op) {
                        case 1 -> i.setNome(lerString(scanner, "Novo nome: "));
                        case 2 -> i.setEspecialidade(lerString(scanner, "Nova especialidade: "));
                        case 3 -> i.setSalario(lerDouble(scanner, "Novo salário: "));
                        default -> {
                            System.out.println("Opção inválida.");
                            return;
                        }
                    }

                    dao.updateInstrutor(id, i);
                    System.out.println("Instrutor atualizado!");

                } catch (Exception e) {
                    System.out.println("Erro ao atualizar instrutor: " + e.getMessage());
                }
            }

            // ================= AULA =================
            case 5 -> {
                try {
                    AulaDAO dao = new AulaDAO();

                    int id = lerInt(scanner, "ID da aula: ");

                    Aula a = dao.selectById(id);
                    if (a == null) {
                        System.out.println("Aula não encontrada.");
                        return;
                    }

                    System.out.println("[1] Nome");
                    System.out.println("[2] Horário");
                    System.out.println("[3] Capacidade");
                    System.out.println("[4] Instrutor ID");

                    int op = lerInt(scanner, "Escolha: ");

                    switch (op) {
                        case 1 -> a.setNome(lerString(scanner, "Novo nome: "));
                        case 2 -> a.setHorario(lerString(scanner, "Novo horário: "));
                        case 3 -> a.setCapacidade(lerInt(scanner, "Nova capacidade: "));
                        case 4 -> a.setInstrutor_id_instrutor(lerInt(scanner, "Novo instrutor ID: "));
                        default -> {
                            System.out.println("Opção inválida.");
                            return;
                        }
                    }

                    dao.updateAula(id, a);
                    System.out.println("Aula atualizada!");

                } catch (Exception e) {
                    System.out.println("Erro ao atualizar aula: " + e.getMessage());
                }
            }

            // ================= PAGAMENTO =================
            case 6 -> {
                try {
                    PagamentoDAO dao = new PagamentoDAO();

                    int id = lerInt(scanner, "ID do pagamento: ");

                    Pagamento p = dao.selectById(id);
                    if (p == null) {
                        System.out.println("Pagamento não encontrado.");
                        return;
                    }

                    System.out.println("[1] Valor");
                    System.out.println("[2] Data");
                    System.out.println("[3] Pago");
                    System.out.println("[4] ID Aluno");

                    int op = lerInt(scanner, "Escolha: ");

                    switch (op) {
                        case 1 -> p.setValor(lerDouble(scanner, "Novo valor: "));
                        case 2 -> p.setData_pagamento(lerString(scanner, "Nova data: "));
                        case 3 -> p.setPago(lerString(scanner, "Pago (sim/não): "));
                        case 4 -> p.setAluno_id_aluno(lerInt(scanner, "Novo ID aluno: "));
                        default -> {
                            System.out.println("Opção inválida.");
                            return;
                        }
                    }

                    dao.updatePagamento(id, p);
                    System.out.println("Pagamento atualizado!");

                } catch (Exception e) {
                    System.out.println("Erro ao atualizar pagamento: " + e.getMessage());
                }
            }

            // ================= RELAÇÃO =================
            case 7 -> {
                try {
                    AlunoHasAulaDAO dao = new AlunoHasAulaDAO();

                    int idAluno = lerInt(scanner, "ID do aluno atual: ");
                    int idAula = lerInt(scanner, "ID da aula atual: ");

                    AlunoHasAula relacao = dao.selectByIds(idAluno, idAula);

                    if (relacao == null) {
                        System.out.println("Vínculo não encontrado.");
                        return;
                    }

                    System.out.println("[1] Trocar aluno");
                    System.out.println("[2] Trocar aula");

                    int op = lerInt(scanner, "Escolha: ");

                    int novoAluno = idAluno;
                    int novaAula = idAula;

                    switch (op) {
                        case 1 -> novoAluno = lerInt(scanner, "Novo ID aluno: ");
                        case 2 -> novaAula = lerInt(scanner, "Nova ID aula: ");
                        default -> {
                            System.out.println("Opção inválida.");
                            return;
                        }
                    }

                    dao.updateRelacao(idAluno, idAula, novoAluno, novaAula);
                    System.out.println("Vínculo atualizado!");

                } catch (Exception e) {
                    System.out.println("Erro ao atualizar relação: " + e.getMessage());
                }
            }
        }
    }
}