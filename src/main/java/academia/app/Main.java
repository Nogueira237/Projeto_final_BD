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

        Menu menu = new Menu();
        Thread threadMenu = new Thread(menu);
        threadMenu.start();

    }

};
