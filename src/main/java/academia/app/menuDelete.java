package academia.app;

import academia.dao.*;

import java.util.Scanner;

public class menuDelete {

    public void executar(Scanner scanner) {

        int opcao;

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

        switch (opcao) {

            // ================= ALUNO =================
            case 1 -> {
                AlunoDAO dao = new AlunoDAO();

                System.out.print("ID do aluno: ");
                int id = scanner.nextInt();

                if (dao.deleteAluno(id)) {
                    System.out.println("Aluno removido com sucesso!");
                } else {
                    System.out.println("Erro ao remover aluno.");
                }
            }

            // ================= PLANO =================
            case 2 -> {
                PlanoDAO dao = new PlanoDAO();

                System.out.print("ID do plano: ");
                int id = scanner.nextInt();

                if (dao.deletePlano(id)) {
                    System.out.println("Plano removido com sucesso!");
                } else {
                    System.out.println("Erro ao remover plano.");
                }
            }

            // ================= TREINO =================
            case 3 -> {
                TreinoDAO dao = new TreinoDAO();

                System.out.print("ID do treino: ");
                int id = scanner.nextInt();

                if (dao.deleteTreino(id)) {
                    System.out.println("Treino removido com sucesso!");
                } else {
                    System.out.println("Erro ao remover treino.");
                }
            }

            // ================= INSTRUTOR =================
            case 4 -> {
                InstrutorDAO dao = new InstrutorDAO();

                System.out.print("ID do instrutor: ");
                int id = scanner.nextInt();

                if (dao.deleteInstrutor(id)) {
                    System.out.println("Instrutor removido com sucesso!");
                } else {
                    System.out.println("Erro ao remover instrutor.");
                }
            }

            // ================= AULA =================
            case 5 -> {
                AulaDAO dao = new AulaDAO();

                System.out.print("ID da aula: ");
                int id = scanner.nextInt();

                if (dao.deleteAula(id)) {
                    System.out.println("Aula removida com sucesso!");
                } else {
                    System.out.println("Erro ao remover aula.");
                }
            }

            // ================= PAGAMENTO =================
            case 6 -> {
                PagamentoDAO dao = new PagamentoDAO();

                System.out.print("ID do pagamento: ");
                int id = scanner.nextInt();

                if (dao.deletePagamento(id)) {
                    System.out.println("Pagamento removido com sucesso!");
                } else {
                    System.out.println("Erro ao remover pagamento.");
                }
            }

            // ================= RELAÇÃO (N:N) =================
            case 7 -> {
                AlunoHasAulaDAO dao = new AlunoHasAulaDAO();

                System.out.print("ID aluno: ");
                int idAluno = scanner.nextInt();

                System.out.print("ID aula: ");
                int idAula = scanner.nextInt();

                if (dao.deleteRelacao(idAluno, idAula)) {
                    System.out.println("Vínculo removido com sucesso!");
                } else {
                    System.out.println("Erro ao remover vínculo.");
                }
            }

            default -> System.out.println("Opção inválida.");
        }
    }
}