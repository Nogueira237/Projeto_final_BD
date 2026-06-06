package academia.app;

import academia.classes.*;
import academia.dao.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class menuInsert {

    public void executar(Scanner scanner) {

        int opcaoTabela;

        PlanoDAO planoDAO = new PlanoDAO();
        TreinoDAO treinoDAO = new TreinoDAO();
        AlunoDAO alunoDAO = new AlunoDAO();
        PagamentoDAO pagamentoDAO = new PagamentoDAO();
        InstrutorDAO instrutorDAO = new InstrutorDAO();
        AulaDAO aulaDAO = new AulaDAO();

        do {
            try {
                System.out.println("\n===== MENU INSERT =====");
                System.out.println("1 - Aluno");
                System.out.println("2 - Plano");
                System.out.println("3 - Treino");
                System.out.println("4 - Pagamento");
                System.out.println("5 - Instrutor");
                System.out.println("6 - Aula");
                System.out.println("7 - Aluno_has_Aula");
                System.out.println("0 - Sair");

                opcaoTabela = scanner.nextInt();
                scanner.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Digite uma opção válida.");
                scanner.nextLine();
                opcaoTabela = -1;
                continue;
            }

            switch (opcaoTabela) {

                case 1 -> inserirAluno(scanner, alunoDAO, planoDAO, treinoDAO);
                case 2 -> inserirPlano(scanner, planoDAO);
                case 3 -> inserirTreino(scanner, treinoDAO);
                case 4 -> inserirPagamento(scanner, pagamentoDAO);
                case 5 -> inserirInstrutor(scanner, instrutorDAO);
                case 6 -> inserirAula(scanner, aulaDAO);
                case 7 -> inserirAlunoHasAula(scanner);
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcaoTabela != 0);
    }

    // ================= UTIL =================
    private int lerInt(Scanner scanner, String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }

    private double lerDouble(Scanner scanner, String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número decimal válido.");
            }
        }
    }

    private int lerIntPositivo(Scanner scanner, String msg) {
        while (true) {
            int v = lerInt(scanner, msg);
            if (v > 0) return v;
            System.out.println("Valor deve ser maior que zero.");
        }
    }

    private double lerDoublePositivo(Scanner scanner, String msg) {
        while (true) {
            double v = lerDouble(scanner, msg);
            if (v > 0) return v;
            System.out.println("Valor deve ser maior que zero.");
        }
    }

    // ================= VALIDAÇÕES NOVAS =================

    private String lerNome(Scanner scanner) {
        while (true) {
            System.out.print("Nome: ");
            String nome = scanner.nextLine().trim();

            if (nome.matches("[A-Za-zÀ-ÿ ]+")) {
                return nome;
            }

            System.out.println("Nome inválido. Use apenas letras e espaços.");
        }
    }

    private String lerTelefone(Scanner scanner) {
        while (true) {
            System.out.print("Telefone ((DD)91111-1111 ou (DD)1111-1111): ");
            String tel = scanner.nextLine().trim();

            if (tel.matches("\\(\\d{2}\\)\\d{4,5}-\\d{4}")) {
                return tel;
            }

            System.out.println("Telefone inválido.");
        }
    }

    private String lerCPF(Scanner scanner) {
        while (true) {
            System.out.print("CPF (11 dígitos): ");
            String cpf = scanner.nextLine().trim();

            if (cpf.matches("\\d{11}")) return cpf;

            System.out.println("CPF inválido.");
        }
    }

    private String lerData(Scanner scanner) {
        while (true) {
            System.out.print("Data (YYYY-MM-DD): ");
            String data = scanner.nextLine().trim();

            if (data.matches("\\d{4}-\\d{2}-\\d{2}")) return data;

            System.out.println("Data inválida.");
        }
    }

    private String lerSIMNAO(Scanner scanner, String msg) {
        while (true) {
            System.out.print(msg);
            String v = scanner.nextLine().trim().toUpperCase();

            if (v.equals("SIM") || v.equals("NAO")) return v;

            System.out.println("Digite SIM ou NAO.");
        }
    }

    // ================= ALUNO =================
    private void inserirAluno(Scanner scanner, AlunoDAO alunoDAO,
                              PlanoDAO planoDAO, TreinoDAO treinoDAO) {

        try {
            String nome = lerNome(scanner);
            String cpf = lerCPF(scanner);
            String data = lerData(scanner);
            String telefone = lerTelefone(scanner);

            int idTreino = lerIntPositivo(scanner, "ID Treino: ");
            int idPlano = lerIntPositivo(scanner, "ID Plano: ");

            if (treinoDAO.selectById(idTreino) == null ||
                    planoDAO.selectById(idPlano) == null) {
                System.out.println("Treino ou Plano não existe.");
                return;
            }

            Aluno aluno = new Aluno(nome, cpf, data, telefone, idTreino, idPlano);

            System.out.println(alunoDAO.insertAluno(aluno)
                    ? "Aluno cadastrado!"
                    : "Erro ao cadastrar aluno.");

        } catch (Exception e) {
            System.out.println("Erro ao inserir aluno.");
        }
    }

    // ================= PLANO =================
    private void inserirPlano(Scanner scanner, PlanoDAO planoDAO) {

        try {
            String nome = lerNome(scanner);
            double valor = lerDoublePositivo(scanner, "Valor: ");
            int duracao = lerIntPositivo(scanner, "Duração: ");

            Plano plano = new Plano(nome, valor, duracao);

            System.out.println(planoDAO.insertPlano(plano)
                    ? "Plano cadastrado!"
                    : "Erro ao cadastrar plano.");

        } catch (Exception e) {
            System.out.println("Erro ao inserir plano.");
        }
    }

    // ================= TREINO =================
    private void inserirTreino(Scanner scanner, TreinoDAO treinoDAO) {

        try {
            String descricao = lerNome(scanner);
            String nivel = lerNome(scanner);

            Treino treino = new Treino(descricao, nivel);

            System.out.println(treinoDAO.insertTreino(treino)
                    ? "Treino cadastrado!"
                    : "Erro ao cadastrar treino.");

        } catch (Exception e) {
            System.out.println("Erro ao inserir treino.");
        }
    }

    // ================= PAGAMENTO =================
    private void inserirPagamento(Scanner scanner, PagamentoDAO pagamentoDAO) {

        try {
            double valor = lerDoublePositivo(scanner, "Valor: ");
            String data = lerData(scanner);
            String pago = lerSIMNAO(scanner, "Pago (SIM/NAO): ");
            int idAluno = lerIntPositivo(scanner, "ID aluno: ");

            Pagamento pagamento = new Pagamento(valor, data, pago, idAluno);

            System.out.println(pagamentoDAO.insertPagamento(pagamento)
                    ? "Pagamento cadastrado!"
                    : "Erro ao cadastrar pagamento.");

        } catch (Exception e) {
            System.out.println("Erro ao inserir pagamento.");
        }
    }

    // ================= INSTRUTOR =================
    private void inserirInstrutor(Scanner scanner, InstrutorDAO dao) {

        try {
            String nome = lerNome(scanner);
            String esp = lerNome(scanner);
            double salario = lerDoublePositivo(scanner, "Salário: ");

            Instrutor i = new Instrutor(nome, esp, salario);

            System.out.println(dao.insertInstrutor(i)
                    ? "Instrutor cadastrado!"
                    : "Erro ao cadastrar instrutor.");

        } catch (Exception e) {
            System.out.println("Erro ao inserir instrutor.");
        }
    }

    // ================= AULA =================
    private void inserirAula(Scanner scanner, AulaDAO dao) {

        try {
            String nome = lerNome(scanner);
            String horario = scanner.nextLine();

            int capacidade;
            while (true) {
                try {
                    capacidade = Integer.parseInt(scanner.nextLine());
                    if (capacidade > 0) break;
                    System.out.println("Capacidade deve ser maior que zero.");
                } catch (NumberFormatException e) {
                    System.out.println("Digite um número válido.");
                }
            }

            int idInstrutor = lerIntPositivo(scanner, "ID instrutor: ");

            Aula aula = new Aula(nome, horario, capacidade, idInstrutor);

            System.out.println(dao.insertAula(aula)
                    ? "Aula cadastrada!"
                    : "Erro ao cadastrar aula.");

        } catch (Exception e) {
            System.out.println("Erro ao inserir aula.");
        }
    }

    // ================= RELAÇÃO =================
    private void inserirAlunoHasAula(Scanner scanner) {

        try {
            int idAluno = lerIntPositivo(scanner, "ID aluno: ");
            int idAula = lerIntPositivo(scanner, "ID aula: ");

            AlunoHasAula relacao = new AlunoHasAula(idAluno, idAula);

            AlunoHasAulaDAO dao = new AlunoHasAulaDAO();

            System.out.println(dao.insertAlunoHasAula(relacao)
                    ? "Matrícula criada!"
                    : "Erro ao matricular.");

        } catch (Exception e) {
            System.out.println("Erro ao criar relação aluno-aula.");
        }
    }
}