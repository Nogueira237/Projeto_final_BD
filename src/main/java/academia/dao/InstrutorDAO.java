package academia.dao;

import academia.classes.Instrutor;

import java.sql.SQLException;
import java.util.ArrayList;

public class InstrutorDAO extends ConnectionDAO {

    // ========== INSERT ==========
    public boolean insertInstrutor(Instrutor instrutor) {

        connectToDb();

        String sql = "INSERT INTO Instrutor(nome, especialidade, salario) VALUES (?, ?, ?)";

        try {

            pst = connection.prepareStatement(sql);

            pst.setString(1, instrutor.getNome());
            pst.setString(2, instrutor.getEspecialidade());
            pst.setDouble(3, instrutor.getSalario());

            pst.execute();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao inserir instrutor: " + e.getMessage());
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
    public boolean updateInstrutor(int id, Instrutor instrutor) {

        connectToDb();

        String sql = "UPDATE Instrutor SET nome = ?, especialidade = ?, salario = ? WHERE id_instrutor = ?";

        try {

            pst = connection.prepareStatement(sql);

            pst.setString(1, instrutor.getNome());
            pst.setString(2, instrutor.getEspecialidade());
            pst.setDouble(3, instrutor.getSalario());
            pst.setInt(4, id);

            pst.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao atualizar instrutor: " + e.getMessage());
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
    public boolean deleteInstrutor(int id) {

        connectToDb();

        String sql = "DELETE FROM Instrutor WHERE id_instrutor = ?";

        try {

            pst = connection.prepareStatement(sql);

            pst.setInt(1, id);

            pst.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao remover instrutor: " + e.getMessage());
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
    public ArrayList<Instrutor> selectInstrutor() {

        ArrayList<Instrutor> instrutores = new ArrayList<>();

        connectToDb();

        String sql = "SELECT * FROM Instrutor";

        try {

            st = connection.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                Instrutor instrutor = new Instrutor(
                        rs.getInt("id_instrutor"),
                        rs.getString("nome"),
                        rs.getString("especialidade"),
                        rs.getDouble("salario")
                );

                instrutores.add(instrutor);
            }

        } catch (SQLException e) {

            System.out.println("Erro ao buscar instrutores: " + e.getMessage());

        } finally {

            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return instrutores;
    };

};