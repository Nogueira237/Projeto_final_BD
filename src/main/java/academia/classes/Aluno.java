package academia.classes;

public class Aluno {
    // Atributos
    private int id_aluno;
    private String nome;
    private String cpf;
    private String data_nascimento;
    private String telefone;
    private int Treino_id_treino;
    private int Plano_id_plano;

    // Contrutor
    // COM ID
    public Aluno(int id_aluno, String nome, String cpf, String data_nascimento, String telefone, int treino_id_treino, int plano_id_plano) {

        this.id_aluno = id_aluno;
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
        this.Treino_id_treino = treino_id_treino;
        this.Plano_id_plano = plano_id_plano;
    };

    // SEM ID
    public Aluno(String nome, String cpf, String data_nascimento, String telefone, int treino_id_treino, int plano_id_plano) {
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.telefone = telefone;
        this.Treino_id_treino = treino_id_treino;
        this.Plano_id_plano = plano_id_plano;
    };

    // Getters e Setters
    public int getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(int id_aluno) {
        this.id_aluno = id_aluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getTreino_id_treino() {
        return Treino_id_treino;
    }

    public void setTreino_id_treino(int treino_id_treino) {
        Treino_id_treino = treino_id_treino;
    }

    public int getPlano_id_plano() {
        return Plano_id_plano;
    }

    public void setPlano_id_plano(int plano_id_plano) {
        Plano_id_plano = plano_id_plano;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id_aluno +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", data_nascimento='" + data_nascimento + '\'' +
                ", telefone='" + telefone + '\'' +
                ", treino=" + Treino_id_treino +
                ", plano=" + Plano_id_plano +
                '}';
    }
};
