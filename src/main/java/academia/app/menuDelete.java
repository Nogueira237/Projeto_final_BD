package academia.app;

import academia.dao.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class menuDelete {

    public void executar(Scanner scanner) {

        int opcao;

        try {
            System.out.println("\n===== MENU DELETE =====");
            System.out.println("1 - Aluno");
            System.out.println("2 - Plano");
            System.out.println("3 - Treino");
            System.out.println("4 - Instrutor");
            System.out.println("5 - Aula");
            System.out.println("6 - Pagamento");
            System.out.println("7 - AlunoHasAula");

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

                    System.out.print("ID do aluno: ");
                    int id = scanner.nextInt();

                    System.out.println(dao.deleteAluno(id)
                            ? "Aluno removido com sucesso!"
                            : "Erro ao remover aluno.");

                } catch (InputMismatchException e) {
                    System.out.println("ID inválido.");
                    scanner.nextLine();
                }
            }

            // ================= PLANO =================
            case 2 -> {
                try {
                    PlanoDAO dao = new PlanoDAO();

                    System.out.print("ID do plano: ");
                    int id = scanner.nextInt();

                    System.out.println(dao.deletePlano(id)
                            ? "Plano removido com sucesso!"
                            : "Erro ao remover plano.");

                } catch (InputMismatchException e) {
                    System.out.println("ID inválido.");
                    scanner.nextLine();
                }
            }

            // ================= TREINO =================
            case 3 -> {
                try {
                    TreinoDAO dao = new TreinoDAO();

                    System.out.print("ID do treino: ");
                    int id = scanner.nextInt();

                    System.out.println(dao.deleteTreino(id)
                            ? "Treino removido com sucesso!"
                            : "Erro ao remover treino.");

                } catch (InputMismatchException e) {
                    System.out.println("ID inválido.");
                    scanner.nextLine();
                }
            }

            // ================= INSTRUTOR =================
            case 4 -> {
                try {
                    InstrutorDAO dao = new InstrutorDAO();

                    System.out.print("ID do instrutor: ");
                    int id = scanner.nextInt();

                    System.out.println(dao.deleteInstrutor(id)
                            ? "Instrutor removido com sucesso!"
                            : "Erro ao remover instrutor.");

                } catch (InputMismatchException e) {
                    System.out.println("ID inválido.");
                    scanner.nextLine();
                }
            }

            // ================= AULA =================
            case 5 -> {
                try {
                    AulaDAO dao = new AulaDAO();

                    System.out.print("ID da aula: ");
                    int id = scanner.nextInt();

                    System.out.println(dao.deleteAula(id)
                            ? "Aula removida com sucesso!"
                            : "Erro ao remover aula.");

                } catch (InputMismatchException e) {
                    System.out.println("ID inválido.");
                    scanner.nextLine();
                }
            }

            // ================= PAGAMENTO =================
            case 6 -> {
                try {
                    PagamentoDAO dao = new PagamentoDAO();

                    System.out.print("ID do pagamento: ");
                    int id = scanner.nextInt();

                    System.out.println(dao.deletePagamento(id)
                            ? "Pagamento removido com sucesso!"
                            : "Erro ao remover pagamento.");

                } catch (InputMismatchException e) {
                    System.out.println("ID inválido.");
                    scanner.nextLine();
                }
            }

            // ================= RELAÇÃO =================
            case 7 -> {
                try {
                    AlunoHasAulaDAO dao = new AlunoHasAulaDAO();

                    System.out.print("ID aluno: ");
                    int idAluno = scanner.nextInt();

                    System.out.print("ID aula: ");
                    int idAula = scanner.nextInt();

                    System.out.println(dao.deleteRelacao(idAluno, idAula)
                            ? "Vínculo removido com sucesso!"
                            : "Erro ao remover vínculo.");

                } catch (InputMismatchException e) {
                    System.out.println("IDs inválidos.");
                    scanner.nextLine();
                }
            }

            default -> System.out.println("Opção inválida.");
        }
    }
}