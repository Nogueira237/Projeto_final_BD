package academia.app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu implements Runnable{

    @Override
    public void run(){

        Scanner scanner = new Scanner(System.in);
        int opcao = -1;     // valor aleatorio para inicializar a variavel
        int opcaoTabela = -1;
        int opcaoPlano = -1;
        int opcaoPagamento = -1;
        int opcaoAtualizacao = -1;


        do {
            // PRIMEIRO MOSTRA AS OPCOES
            System.out.println("Qual operação você deseja realizar? [digite o número da opção selecionada]");
            System.out.println("Finalizar [0]");
            System.out.println("Nova inserção [1]");
            System.out.println("Atualização [2]");
            System.out.println("Deletar [3]");
            System.out.println("Mostrar dados [4]");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Erro! A opção escolhida é invalida: " + e.getMessage());
                scanner.nextLine(); // descarta o valor inválido
                continue;
            }
            ;

            menuInsert menuInsert = new menuInsert();
            menuUpdate menuUpdate = new menuUpdate();
            menuDelete menuDelete = new menuDelete();
            menuSelect menuSelect = new menuSelect();

            switch (opcao) {
                case 1:     // Insere dados
                    menuInsert.executar(scanner);
                    break;

                case 2:     // Atualiza dados
                    menuUpdate.executar(scanner);
                    break;

                case 3:
                    menuDelete.executar(scanner);
                    break;

                case 4:
                    menuSelect.executar(scanner);
                    break;

                default:
                    if(opcao != 0)System.out.println("Opção inválida.");
                    break;
            }
            ;

        } while (opcao != 0);

    };

};
