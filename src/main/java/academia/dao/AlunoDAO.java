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

    public Aluno selectById(int id) {

        connectToDb();

        String sql = "SELECT * FROM Aluno WHERE id_aluno = ?";

        try {

            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);

            rs = pst.executeQuery();

            if (rs.next()) {

                return new Aluno(
                        rs.getInt("id_aluno"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("data_nascimento"),
                        rs.getString("telefone"),
                        rs.getInt("Treino_id_treino"),
                        rs.getInt("Plano_id_plano")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar aluno por ID: " + e.getMessage());

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

    public void relatorioAlunoPagamento() {

        connectToDb();

        String sql = """
        SELECT 
            a.id_aluno,
            a.nome,
            a.cpf,
            p.valor,
            p.data_pagamento,
            p.pago
        FROM Aluno a
        INNER JOIN Pagamento p ON a.id_aluno = p.Aluno_id_aluno
    """;

        try {

            st = connection.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                System.out.println(
                        "Aluno: " + rs.getString("nome") +
                                " | CPF: " + rs.getString("cpf") +
                                " | Valor: " + rs.getDouble("valor") +
                                " | Data: " + rs.getString("data_pagamento") +
                                " | Pago: " + rs.getString("pago")
                );
            }

        } catch (Exception e) {
            System.out.println("Erro no relatório aluno + pagamento: " + e.getMessage());

        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void relatorioAlunoAula() {

        connectToDb();

        String sql = """
        SELECT 
            a.nome AS aluno,
            au.nome AS aula,
            au.horario,
            au.capacidade
        FROM Aluno a
        INNER JOIN Aluno_has_Aula aa ON a.id_aluno = aa.Aluno_id_aluno
        INNER JOIN Aula au ON au.id_aula = aa.Aula_id_aula
    """;

        try {

            st = connection.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                System.out.println(
                        "Aluno: " + rs.getString("aluno") +
                                " | Aula: " + rs.getString("aula") +
                                " | Horário: " + rs.getString("horario") +
                                " | Capacidade: " + rs.getInt("capacidade")
                );
            }

        } catch (Exception e) {
            System.out.println("Erro no relatório aluno + aula: " + e.getMessage());

        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void relatorioCompletoAluno() {

        connectToDb();

        String sql = """
        SELECT 
            a.nome AS aluno,
            a.cpf,
            a.data_nascimento,
            pl.nome AS plano,
            pl.valor AS valor_plano,
            p.valor AS valor_pago,
            p.data_pagamento,
            p.pago
        FROM Aluno a
        INNER JOIN Plano pl ON a.Plano_id_plano = pl.id_plano
        INNER JOIN Pagamento p ON a.id_aluno = p.Aluno_id_aluno
    """;

        try {

            st = connection.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                System.out.println(
                        "Aluno: " + rs.getString("aluno") +
                                " | CPF: " + rs.getString("cpf") +
                                " | Nasc: " + rs.getString("data_nascimento") +
                                " | Plano: " + rs.getString("plano") +
                                " | Valor Plano: " + rs.getDouble("valor_plano") +
                                " | Pago: " + rs.getDouble("valor_pago") +
                                " | Data: " + rs.getString("data_pagamento") +
                                " | Status: " + rs.getString("pago")
                );
            }

        } catch (Exception e) {
            System.out.println("Erro no relatório completo: " + e.getMessage());

        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }



};
