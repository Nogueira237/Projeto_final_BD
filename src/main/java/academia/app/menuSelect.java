package academia.app;

import academia.dao.*;

import java.util.Scanner;

public class menuSelect {

    public void executar(Scanner scanner) {

        int opcao;

        System.out.println("\n===== MENU SELECT =====");
        System.out.println("1 - Aluno");
        System.out.println("2 - Plano");
        System.out.println("3 - Treino");
        System.out.println("4 - Instrutor");
        System.out.println("5 - Aula");
        System.out.println("6 - Pagamento");
        System.out.println("7 - Aluno_has_Aula");

        opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {

            // ================= ALUNO (ESPECIAL) =================
            case 1 -> menuAluno(scanner);

            // ================= PLANO =================
            case 2 -> menuPlano(scanner);

            // ================= TREINO =================
            case 3 -> menuTreino(scanner);

            // ================= INSTRUTOR =================
            case 4 -> menuInstrutor(scanner);

            // ================= AULA =================
            case 5 -> menuAula(scanner);

            // ================= PAGAMENTO =================
            case 6 -> menuPagamento(scanner);

            // ================= RELAÇÃO =================
            case 7 -> menuRelacao(scanner);

            default -> System.out.println("Opção inválida.");
        }
    }

    // =====================================================
    // ===================== ALUNO =========================
    // =====================================================
    private void menuAluno(Scanner scanner) {

        AlunoDAO dao = new AlunoDAO();

        System.out.println("\n1 - Buscar por ID");
        System.out.println("2 - Mostrar todos");
        System.out.println("3 - Relatório alunos + pagamentos (JOIN)");
        System.out.println("4 - Relatório alunos + aulas (JOIN)");
        System.out.println("5 - Relatório completo (Aluno + Pagamento + Plano)");

        int op = scanner.nextInt();
        scanner.nextLine();

        switch (op) {

            case 1 -> {
                System.out.print("ID: ");
                int id = scanner.nextInt();
                System.out.println(dao.selectById(id));
            }

            case 2 -> {
                dao.selectAluno().forEach(System.out::println);
            }

            case 3 -> {
                dao.relatorioAlunoPagamento();
            }

            case 4 -> {
                dao.relatorioAlunoAula();
            }

            case 5 -> {
                dao.relatorioCompletoAluno();
            }
        }
    }

    // =====================================================
    private void menuPlano(Scanner scanner) {

        PlanoDAO dao = new PlanoDAO();

        System.out.println("\n1 - Buscar por ID");
        System.out.println("2 - Mostrar todos");

        int op = scanner.nextInt();

        if (op == 1) {
            System.out.print("ID: ");
            System.out.println(dao.selectById(scanner.nextInt()));
        } else {
            dao.selectPlano().forEach(System.out::println);
        }
    }

    // =====================================================
    private void menuTreino(Scanner scanner) {

        TreinoDAO dao = new TreinoDAO();

        System.out.println("\n1 - Buscar por ID");
        System.out.println("2 - Mostrar todos");

        int op = scanner.nextInt();

        if (op == 1) {
            System.out.print("ID: ");
            System.out.println(dao.selectById(scanner.nextInt()));
        } else {
            dao.selectTreino().forEach(System.out::println);
        }
    }

    // =====================================================
    private void menuInstrutor(Scanner scanner) {

        InstrutorDAO dao = new InstrutorDAO();

        System.out.println("\n1 - Buscar por ID");
        System.out.println("2 - Mostrar todos");

        int op = scanner.nextInt();

        if (op == 1) {
            System.out.print("ID: ");
            System.out.println(dao.selectById(scanner.nextInt()));
        } else {
            dao.selectInstrutor().forEach(System.out::println);
        }
    }

    // =====================================================
    private void menuAula(Scanner scanner) {

        AulaDAO dao = new AulaDAO();

        System.out.println("\n1 - Buscar por ID");
        System.out.println("2 - Mostrar todos");

        int op = scanner.nextInt();

        if (op == 1) {
            System.out.print("ID: ");
            System.out.println(dao.selectById(scanner.nextInt()));
        } else {
            dao.selectAula().forEach(System.out::println);
        }
    }

    // =====================================================
    private void menuPagamento(Scanner scanner) {

        PagamentoDAO dao = new PagamentoDAO();

        System.out.println("\n1 - Buscar por ID");
        System.out.println("2 - Mostrar todos");

        int op = scanner.nextInt();

        if (op == 1) {
            System.out.print("ID: ");
            System.out.println(dao.selectById(scanner.nextInt()));
        } else {
            dao.selectPagamento().forEach(System.out::println);
        }
    }

    // =====================================================
    private void menuRelacao(Scanner scanner) {

        AlunoHasAulaDAO dao = new AlunoHasAulaDAO();

        System.out.println("\n1 - Buscar por aluno + aula");
        System.out.println("2 - Mostrar todas relações");

        int op = scanner.nextInt();

        if (op == 1) {

            System.out.print("ID aluno: ");
            int aluno = scanner.nextInt();

            System.out.print("ID aula: ");
            int aula = scanner.nextInt();

            System.out.println(dao.selectByIds(aluno, aula));

        } else {
            dao.selectRelacoes().forEach(System.out::println);
        }
    }
}