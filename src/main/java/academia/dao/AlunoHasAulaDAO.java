package academia.dao;

import academia.classes.AlunoHasAula;

import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoHasAulaDAO extends ConnectionDAO {

    // ========== INSERT ==========
    public boolean insertAlunoHasAula(AlunoHasAula relacao) {

        connectToDb();

        String sql = "INSERT INTO Aluno_has_Aula(Aluno_id_aluno, Aula_id_aula) VALUES (?, ?)";

        try {

            pst = connection.prepareStatement(sql);

            pst.setInt(1, relacao.getAluno_id_aluno());
            pst.setInt(2, relacao.getAula_id_aula());

            pst.execute();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao matricular aluno na aula: " + e.getMessage());
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
    public boolean updateAlunoHasAula(int oldAluno, int oldAula,
                                      int newAluno, int newAula) {

        connectToDb();

        String sql = "UPDATE Aluno_has_Aula SET Aluno_id_aluno = ?, Aula_id_aula = ? " +
                "WHERE Aluno_id_aluno = ? AND Aula_id_aula = ?";

        try {

            pst = connection.prepareStatement(sql);

            pst.setInt(1, newAluno);
            pst.setInt(2, newAula);
            pst.setInt(3, oldAluno);
            pst.setInt(4, oldAula);

            pst.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao atualizar matrícula: " + e.getMessage());
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
    public boolean deleteAlunoHasAula(int idAluno, int idAula) {

        connectToDb();

        String sql = "DELETE FROM Aluno_has_Aula WHERE Aluno_id_aluno = ? AND Aula_id_aula = ?";

        try {

            pst = connection.prepareStatement(sql);

            pst.setInt(1, idAluno);
            pst.setInt(2, idAula);

            pst.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao remover matrícula: " + e.getMessage());
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
    public ArrayList<AlunoHasAula> selectAlunoHasAula() {

        ArrayList<AlunoHasAula> lista = new ArrayList<>();

        connectToDb();

        String sql = "SELECT * FROM Aluno_has_Aula";

        try {

            st = connection.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                AlunoHasAula relacao = new AlunoHasAula(
                        rs.getInt("Aluno_id_aluno"),
                        rs.getInt("Aula_id_aula")
                );

                lista.add(relacao);
            }

        } catch (SQLException e) {

            System.out.println("Erro ao buscar matrículas: " + e.getMessage());

        } finally {

            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return lista;
    };

};