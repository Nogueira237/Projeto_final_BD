package academia.dao;

import academia.classes.Treino;

import java.sql.SQLException;
import java.util.ArrayList;

public class TreinoDAO extends ConnectionDAO {

    // ========== INSERT ==========
    public boolean insertTreino(Treino treino) {

        connectToDb();

        String sql = "INSERT INTO Treino(descricao, nivel) VALUES (?, ?)";

        try {

            pst = connection.prepareStatement(sql);

            pst.setString(1, treino.getDescricao());
            pst.setString(2, treino.getNivel());

            pst.execute();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao inserir treino: " + e.getMessage());
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
    public boolean updateTreino(int id, Treino treino) {

        connectToDb();

        String sql = "UPDATE Treino SET descricao = ?, nivel = ? WHERE id_treino = ?";

        try {

            pst = connection.prepareStatement(sql);

            pst.setString(1, treino.getDescricao());
            pst.setString(2, treino.getNivel());
            pst.setInt(3, id);

            pst.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao atualizar treino: " + e.getMessage());
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
    public boolean deleteTreino(int id) {

        connectToDb();

        String sql = "DELETE FROM Treino WHERE id_treino = ?";

        try {

            pst = connection.prepareStatement(sql);

            pst.setInt(1, id);

            pst.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao remover treino: " + e.getMessage());
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
    public ArrayList<Treino> selectTreino() {

        ArrayList<Treino> treinos = new ArrayList<>();

        connectToDb();

        String sql = "SELECT * FROM Treino";

        try {

            st = connection.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                Treino treino = new Treino(
                        rs.getInt("id_treino"),
                        rs.getString("descricao"),
                        rs.getString("nivel")
                );

                treinos.add(treino);
            }

        } catch (SQLException e) {

            System.out.println("Erro ao buscar treinos: " + e.getMessage());

        } finally {

            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return treinos;
    };

};