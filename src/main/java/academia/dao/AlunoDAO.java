package academia.dao;

import academia.classes.Aluno;

import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoDAO extends ConnectionDAO{

    // ========== INSERT ==========
    public boolean insertAluno(Aluno aluno) {

        connectToDb();

        String sql = "INSERT INTO Aluno(nome, cpf, data_nascimento, telefone, Treino_id_treino, Plano_id_plano) VALUES (?, ?, ?, ?, ?, ?)";

        try {

            pst = connection.prepareStatement(sql);

            pst.setString(1, aluno.getNome());
            pst.setString(2, aluno.getCpf());
            pst.setString(3, aluno.getData_nascimento());
            pst.setString(4, aluno.getTelefone());
            pst.setInt(5, aluno.getTreino_id_treino());
            pst.setInt(6, aluno.getPlano_id_plano());

            pst.execute();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao inserir aluno: " + e.getMessage());
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
    public boolean updateAluno(int id, Aluno aluno) {

        connectToDb();

        String sql = "UPDATE Aluno SET nome = ?, cpf = ?, data_nascimento = ?, telefone = ?, Treino_id_treino = ?, Plano_id_plano = ? WHERE id_aluno = ?";

        try {

            pst = connection.prepareStatement(sql);

            pst.setString(1, aluno.getNome());
            pst.setString(2, aluno.getCpf());
            pst.setString(3, aluno.getData_nascimento());
            pst.setString(4, aluno.getTelefone());
            pst.setInt(5, aluno.getTreino_id_treino());
            pst.setInt(6, aluno.getPlano_id_plano());
            pst.setInt(7, id);

            pst.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao atualizar aluno: " + e.getMessage());
            return false;
        }
    };
    // ========== DELETE ==========
    public boolean deleteAluno(int id) {

        connectToDb();

        String sql = "DELETE FROM Aluno WHERE id_aluno = ?";

        try {

            pst = connection.prepareStatement(sql);

            pst.setInt(1, id);

            pst.execute();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao remover aluno: " + e.getMessage());
            return false;
        }
    };

    // ========== SELECT ==========
    public ArrayList<Aluno> selectAluno() {

        ArrayList<Aluno> alunos = new ArrayList<>();

        connectToDb();

        String sql = "SELECT * FROM Aluno";

        try {

            st = connection.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {

                Aluno aluno = new Aluno(
                        rs.getInt("id_aluno"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("data_nascimento"),
                        rs.getString("telefone"),
                        rs.getInt("Treino_id_treino"),
                        rs.getInt("Plano_id_plano")
                );

                alunos.add(aluno);
            }

        } catch (SQLException e) {

            System.out.println("Erro ao buscar alunos: " + e.getMessage());

        } finally {

            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return alunos;
    };

};
