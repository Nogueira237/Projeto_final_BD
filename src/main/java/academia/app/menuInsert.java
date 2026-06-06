package academia.app;

import academia.classes.*;
import academia.dao.*;

import java.util.Scanner;

public class menuInsert {

    public void executar(Scanner scanner) {

        int opcaoTabela;

        PlanoDAO planoDAO = new PlanoDAO();
        TreinoDAO treinoDAO = new TreinoDAO();
        AlunoDAO alunoDAO = new AlunoDAO();
        PagamentoDAO pagamentoDAO = new PagamentoDAO();

        do {
            System.out.println("\n===== MENU INSERT =====");
            System.out.println("1 - Aluno");
            System.out.println("2 - Plano");
            System.out.println("3 - Treino");
            System.out.println("4 - Pagamento");
            System.out.println("0 - Sair");

            opcaoTabela = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoTabela) {

                case 1 -> inserirAluno(scanner, alunoDAO, planoDAO, treinoDAO);

                case 2 -> inserirPlano(scanner, planoDAO);

                case 3 -> inserirTreino(scanner, treinoDAO);

                case 4 -> inserirPagamento(scanner, pagamentoDAO);

            }

        } while (opcaoTabela != 0);
    }

    // ================= ALUNO =================
    private void inserirAluno(Scanner scanner, AlunoDAO alunoDAO,
                              PlanoDAO planoDAO, TreinoDAO treinoDAO) {

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("CPF (11 dígitos): ");
        String cpf = scanner.nextLine();

        System.out.print("Data nascimento (YYYY-MM-DD): ");
        String data = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("ID Treino: ");
        int idTreino = scanner.nextInt();

        System.out.print("ID Plano: ");
        int idPlano = scanner.nextInt();
        scanner.nextLine();

        // (opcional) valida existência no banco
        Treino treino = treinoDAO.selectById(idTreino);
        Plano plano = planoDAO.selectById(idPlano);

        if (treino == null || plano == null) {
            System.out.println("Treino ou Plano inválido!");
            return;
        }

        Aluno aluno = new Aluno(
                nome,
                cpf,
                data,
                telefone,
                idTreino,
                idPlano
        );

        if (alunoDAO.insertAluno(aluno)) {
            System.out.println("Aluno cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar aluno.");
        }
    }

    // ================= AlunoHasAula =================
    private void inserirAlunoHasAula(Scanner scanner) {

        System.out.print("ID aluno: ");
        int idAluno = scanner.nextInt();

        System.out.print("ID aula: ");
        int idAula = scanner.nextInt();
        scanner.nextLine();

        AlunoHasAula relacao = new AlunoHasAula(idAluno, idAula);

        AlunoHasAulaDAO dao = new AlunoHasAulaDAO();

        if (dao.insertAlunoHasAula(relacao)) {
            System.out.println("Matrícula criada!");
        } else {
            System.out.println("Erro ao matricular.");
        }
    }

    // ================= AULA =================
    private void inserirAula(Scanner scanner, AulaDAO aulaDAO) {

        System.out.print("Nome da aula: ");
        String nome = scanner.nextLine();

        System.out.print("Horário (HH:mm:ss): ");
        String horario = scanner.nextLine();

        int capacidade = -1;
        while (capacidade <= 0) {
            try {
                System.out.print("Capacidade: ");
                capacidade = Integer.parseInt(scanner.nextLine());

                if (capacidade <= 0) {
                    System.out.println("Capacidade deve ser maior que zero.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }

        System.out.print("ID do instrutor: ");
        int idInstrutor = Integer.parseInt(scanner.nextLine());

        // cria objeto Aula baseado no seu banco
        Aula aula = new Aula(nome, horario, capacidade, idInstrutor);

        if (aulaDAO.insertAula(aula)) {
            System.out.println("Aula cadastrada com sucesso!");
        } else {
            System.out.println("Erro ao cadastrar aula.");
        }
    }
    // ================= Instrutor =================
    private void inserirInstrutor(Scanner scanner) {

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Especialidade: ");
        String esp = scanner.nextLine();

        System.out.print("Salário: ");
        double salario = scanner.nextDouble();
        scanner.nextLine();

        Instrutor instrutor = new Instrutor(nome, esp, salario);

        InstrutorDAO dao = new InstrutorDAO();

        if (dao.insertInstrutor(instrutor)) {
            System.out.println("Instrutor cadastrado!");
        } else {
            System.out.println("Erro ao cadastrar instrutor.");
        }
    }

    // ================= PAGAMENTO =================
    private void inserirPagamento(Scanner scanner, PagamentoDAO pagamentoDAO) {

        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Data (YYYY-MM-DD): ");
        String data = scanner.nextLine();

        System.out.print("Pago (SIM/NAO): ");
        String pago = scanner.nextLine();

        System.out.print("ID do aluno: ");
        int idAluno = scanner.nextInt();
        scanner.nextLine();

        Pagamento pagamento = new Pagamento(valor, data, pago, idAluno);

        if (pagamentoDAO.insertPagamento(pagamento)) {
            System.out.println("Pagamento cadastrado!");
        } else {
            System.out.println("Erro ao cadastrar pagamento.");
        }
    }

    // ================= PLANO =================
    private void inserirPlano(Scanner scanner, PlanoDAO planoDAO) {

        System.out.print("Nome do plano: ");
        String nome = scanner.nextLine();

        System.out.print("Valor: ");
        double valor = scanner.nextDouble();

        System.out.print("Duração (meses): ");
        int duracao = scanner.nextInt();
        scanner.nextLine();

        Plano plano = new Plano(nome, valor, duracao);

        if (planoDAO.insertPlano(plano)) {
            System.out.println("Plano cadastrado!");
        } else {
            System.out.println("Erro ao cadastrar plano.");
        }
    }

    // ================= TREINO =================
    private void inserirTreino(Scanner scanner, TreinoDAO treinoDAO) {

        System.out.print("Descrição do treino: ");
        String descricao = scanner.nextLine();

        System.out.print("Nível (Fácil/Médio/Difícil): ");
        String nivel = scanner.nextLine();

        Treino treino = new Treino(descricao, nivel);

        if (treinoDAO.insertTreino(treino)) {
            System.out.println("Treino cadastrado!");
        } else {
            System.out.println("Erro ao cadastrar treino.");
        }
    }


}