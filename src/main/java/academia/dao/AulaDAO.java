package academia.dao;

import academia.classes.Aula;

import java.sql.SQLException;
import java.util.ArrayList;

public class AulaDAO extends ConnectionDAO {

    // ========== INSERT ==========]
    public boolean insertAula(Aula aula) {

        connectToDb();

        String sql = "INSERT INTO Aula(nome, horario, capacidade, Instrutor_id_instrutor) VALUES (?, ?, ?, ?)";

        try {

            pst = connection.prepareStatement(sql);

            pst.setString(1, aula.getNome());
            pst.setString(2, aula.getHorario());
            pst.setInt(3, aula.getCapacidade());
            pst.setInt(4, aula.getInstrutor_id_instrutor());

            pst.execute();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao inserir aula: " + e.getMessage());
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
    public boolean updateAula(int id, Aula aula) {

        connectToDb();

        String sql = "UPDATE Aula SET nome = ?, horario = ?, capacidade = ?, Instrutor_id_instrutor = ? WHERE id_aula = ?";

        try {

            pst = connection.prepareStatement(sql);

            pst.setString(1, aula.getNome());
            pst.setString(2, aula.getHorario());
            pst.setInt(3, aula.getCapacidade());
            pst.setInt(4, aula.getInstrutor_id_instrutor());
            pst.setInt(5, id);

            pst.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao atualizar aula: " + e.getMessage());
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
    public boolean deleteAula(int id) {

        connectToDb();

        String sql = "DELETE FROM Aula WHERE id_aula = ?";

        try {

            pst = connection.prepareStatement(sql);

            pst.setInt(1, id);

            pst.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao remover aula: " + e.getMessage());
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
    public ArrayList<Aula> selectAula() {

        ArrayList<Aula> aulas = new ArrayList<>();

        connectToDb();

        String sql = "SELECT * FROM Aula";

        try {

            st = connection.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                Aula aula = new Aula(
                        rs.getInt("id_aula"),
                        rs.getString("nome"),
                        rs.getString("horario"),
                        rs.getInt("capacidade"),
                        rs.getInt("Instrutor_id_instrutor")
                );

                aulas.add(aula);
            }

        } catch (SQLException e) {

            System.out.println("Erro ao buscar aulas: " + e.getMessage());

        } finally {

            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return aulas;
    };

    public Aula selectById(int id) {

        connectToDb();

        String sql = "SELECT * FROM Aula WHERE id_aula = ?";

        try {

            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);

            rs = pst.executeQuery();

            if (rs.next()) {

                return new Aula(
                        rs.getInt("id_aula"),
                        rs.getString("nome"),
                        rs.getString("horario"),
                        rs.getInt("capacidade"),
                        rs.getInt("Instrutor_id_instrutor")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar aula por ID: " + e.getMessage());

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
