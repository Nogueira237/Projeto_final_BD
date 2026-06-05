package academia.dao;

import academia.classes.Plano;

import java.sql.SQLException;
import java.util.ArrayList;

public class PlanoDAO extends ConnectionDAO{

    // ========== INSERT ==========
    public boolean insertPlano(Plano plano) {

        connectToDb();

        String sql = "INSERT INTO Plano(nome, valor, duracao) VALUES (?, ?, ?)";

        try {

            pst = connection.prepareStatement(sql);

            pst.setString(1, plano.getNome());
            pst.setDouble(2, plano.getValor());
            pst.setInt(3, plano.getDuracao());

            pst.execute();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao inserir plano: " + e.getMessage());
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
    public boolean updatePlano(int id, Plano plano) {

        connectToDb();

        String sql = "UPDATE Plano SET nome = ?, valor = ?, duracao = ? WHERE id_plano = ?";

        try {

            pst = connection.prepareStatement(sql);

            pst.setString(1, plano.getNome());
            pst.setDouble(2, plano.getValor());
            pst.setInt(3, plano.getDuracao());
            pst.setInt(4, id);

            pst.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao atualizar plano: " + e.getMessage());
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
    public boolean deletePlano(int id) {

        connectToDb();

        String sql = "DELETE FROM Plano WHERE id_plano = ?";

        try {

            pst = connection.prepareStatement(sql);

            pst.setInt(1, id);

            pst.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao remover plano: " + e.getMessage());
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
    public ArrayList<Plano> selectPlano() {

        ArrayList<Plano> planos = new ArrayList<>();

        connectToDb();

        String sql = "SELECT * FROM Plano";

        try {

            st = connection.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                Plano plano = new Plano(
                        rs.getInt("id_plano"),
                        rs.getString("nome"),
                        rs.getDouble("valor"),
                        rs.getInt("duracao")
                );

                planos.add(plano);
            }

        } catch (SQLException e) {

            System.out.println("Erro ao buscar planos: " + e.getMessage());

        } finally {

            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return planos;
    };

};
