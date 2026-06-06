package academia.app;

import academia.dao.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class menuSelect {

    public void executar(Scanner scanner) {

        int opcao;

        try {
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

        } catch (InputMismatchException e) {
            System.out.println("Opção inválida.");
            scanner.nextLine();
            return;
        }

        switch (opcao) {

            case 1 -> menuAluno(scanner);
            case 2 -> menuPlano(scanner);
            case 3 -> menuTreino(scanner);
            case 4 -> menuInstrutor(scanner);
            case 5 -> menuAula(scanner);
            case 6 -> menuPagamento(scanner);
            case 7 -> menuRelacao(scanner);

            default -> System.out.println("Opção inválida.");
        }
    }

    // ================= UTIL =================
    private int lerInt(Scanner scanner, String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Digite um número válido.");
                scanner.nextLine();
            }
        }
    }

    // =====================================================
    // ===================== ALUNO =========================
    // =====================================================
    private void menuAluno(Scanner scanner) {

        try {
            AlunoDAO dao = new AlunoDAO();

            System.out.println("\n1 - Buscar por ID");
            System.out.println("2 - Mostrar todos");
            System.out.println("3 - Relatório alunos + pagamentos (JOIN)");
            System.out.println("4 - Relatório alunos + aulas (JOIN)");
            System.out.println("5 - Relatório completo");

            int op = lerInt(scanner, "Escolha: ");

            switch (op) {

                case 1 -> {
                    int id = lerInt(scanner, "ID: ");
                    System.out.println(dao.selectById(id));
                }

                case 2 -> dao.selectAluno().forEach(System.out::println);

                case 3 -> dao.relatorioAlunoPagamento();

                case 4 -> dao.relatorioAlunoAula();

                case 5 -> dao.relatorioCompletoAluno();

                default -> System.out.println("Opção inválida.");
            }

        } catch (Exception e) {
            System.out.println("Erro no menu aluno: " + e.getMessage());
        }
    }

    // =====================================================
    private void menuPlano(Scanner scanner) {

        try {
            PlanoDAO dao = new PlanoDAO();

            System.out.println("\n1 - Buscar por ID");
            System.out.println("2 - Mostrar todos");

            int op = lerInt(scanner, "Escolha: ");

            if (op == 1) {
                int id = lerInt(scanner, "ID: ");
                System.out.println(dao.selectById(id));
            } else {
                dao.selectPlano().forEach(System.out::println);
            }

        } catch (Exception e) {
            System.out.println("Erro no menu plano.");
        }
    }

    // =====================================================
    private void menuTreino(Scanner scanner) {

        try {
            TreinoDAO dao = new TreinoDAO();

            System.out.println("\n1 - Buscar por ID");
            System.out.println("2 - Mostrar todos");

            int op = lerInt(scanner, "Escolha: ");

            if (op == 1) {
                int id = lerInt(scanner, "ID: ");
                System.out.println(dao.selectById(id));
            } else {
                dao.selectTreino().forEach(System.out::println);
            }

        } catch (Exception e) {
            System.out.println("Erro no menu treino.");
        }
    }

    // =====================================================
    private void menuInstrutor(Scanner scanner) {

        try {
            InstrutorDAO dao = new InstrutorDAO();

            System.out.println("\n1 - Buscar por ID");
            System.out.println("2 - Mostrar todos");

            int op = lerInt(scanner, "Escolha: ");

            if (op == 1) {
                int id = lerInt(scanner, "ID: ");
                System.out.println(dao.selectById(id));
            } else {
                dao.selectInstrutor().forEach(System.out::println);
            }

        } catch (Exception e) {
            System.out.println("Erro no menu instrutor.");
        }
    }

    // =====================================================
    private void menuAula(Scanner scanner) {

        try {
            AulaDAO dao = new AulaDAO();

            System.out.println("\n1 - Buscar por ID");
            System.out.println("2 - Mostrar todos");

            int op = lerInt(scanner, "Escolha: ");

            if (op == 1) {
                int id = lerInt(scanner, "ID: ");
                System.out.println(dao.selectById(id));
            } else {
                dao.selectAula().forEach(System.out::println);
            }

        } catch (Exception e) {
            System.out.println("Erro no menu aula.");
        }
    }

    // =====================================================
    private void menuPagamento(Scanner scanner) {

        try {
            PagamentoDAO dao = new PagamentoDAO();

            System.out.println("\n1 - Buscar por ID");
            System.out.println("2 - Mostrar todos");

            int op = lerInt(scanner, "Escolha: ");

            if (op == 1) {
                int id = lerInt(scanner, "ID: ");
                System.out.println(dao.selectById(id));
            } else {
                dao.selectPagamento().forEach(System.out::println);
            }

        } catch (Exception e) {
            System.out.println("Erro no menu pagamento.");
        }
    }

    // =====================================================
    private void menuRelacao(Scanner scanner) {

        try {
            AlunoHasAulaDAO dao = new AlunoHasAulaDAO();

            System.out.println("\n1 - Buscar por aluno + aula");
            System.out.println("2 - Mostrar todas relações");

            int op = lerInt(scanner, "Escolha: ");

            if (op == 1) {
                int aluno = lerInt(scanner, "ID aluno: ");
                int aula = lerInt(scanner, "ID aula: ");

                System.out.println(dao.selectByIds(aluno, aula));

            } else {
                dao.selectRelacoes().forEach(System.out::println);
            }

        } catch (Exception e) {
            System.out.println("Erro no menu relação.");
        }
    }
}