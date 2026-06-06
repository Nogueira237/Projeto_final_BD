package academia.dao;

import academia.classes.Pagamento;

import java.sql.SQLException;
import java.util.ArrayList;

public class PagamentoDAO extends ConnectionDAO {

    // ========== INSERT ==========
    public boolean insertPagamento(Pagamento pagamento) {

        connectToDb();

        String sql = "INSERT INTO Pagamento(valor, data_pagamento, pago, Aluno_id_aluno) VALUES (?, ?, ?, ?)";

        try {

            pst = connection.prepareStatement(sql);

            pst.setDouble(1, pagamento.getValor());
            pst.setString(2, pagamento.getData_pagamento());
            pst.setString(3, pagamento.getPago());
            pst.setInt(4, pagamento.getAluno_id_aluno());

            pst.execute();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao inserir pagamento: " + e.getMessage());
            return false;

        } finally {

            try {
                if (pst != null) pst.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    };

    // ========== UPDATE ==========
    public boolean updatePagamento(int id, Pagamento pagamento) {

        connectToDb();

        String sql = "UPDATE Pagamento SET valor = ?, data_pagamento = ?, pago = ?, Aluno_id_aluno = ? WHERE id_pagamento = ?";

        try {

            pst = connection.prepareStatement(sql);

            pst.setDouble(1, pagamento.getValor());
            pst.setString(2, pagamento.getData_pagamento());
            pst.setString(3, pagamento.getPago());
            pst.setInt(4, pagamento.getAluno_id_aluno());
            pst.setInt(5, id);

            pst.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao atualizar pagamento: " + e.getMessage());
            return false;

        } finally {

            try {
                if (pst != null) pst.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    };

    // ========== DELETE ==========
    public boolean deletePagamento(int id) {

        connectToDb();

        String sql = "DELETE FROM Pagamento WHERE id_pagamento = ?";

        try {

            pst = connection.prepareStatement(sql);

            pst.setInt(1, id);

            pst.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao remover pagamento: " + e.getMessage());
            return false;

        } finally {

            try {
                if (pst != null) pst.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    };

    // ========== SELECT ==========
    public ArrayList<Pagamento> selectPagamento() {

        ArrayList<Pagamento> pagamentos = new ArrayList<>();

        connectToDb();

        String sql = "SELECT * FROM Pagamento";

        try {

            st = connection.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                Pagamento pagamento = new Pagamento(
                        rs.getInt("id_pagamento"),
                        rs.getDouble("valor"),
                        rs.getString("data_pagamento"),
                        rs.getString("pago"),
                        rs.getInt("Aluno_id_aluno")
                );

                pagamentos.add(pagamento);
            }

        } catch (SQLException e) {

            System.out.println("Erro ao buscar pagamentos: " + e.getMessage());

        } finally {

            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return pagamentos;
    };

    public Pagamento selectById(int id) {

        connectToDb();

        String sql = "SELECT * FROM Pagamento WHERE id_pagamento = ?";

        try {

            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);

            rs = pst.executeQuery();

            if (rs.next()) {

                return new Pagamento(
                        rs.getInt("id_pagamento"),
                        rs.getDouble("valor"),
                        rs.getString("data_pagamento"),
                        rs.getString("pago"),
                        rs.getInt("Aluno_id_aluno")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar pagamento por ID: " + e.getMessage());

        } finally {

            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return null;
    }

};