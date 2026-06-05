package academia.classes;

public class Aula {
    // Atributos
    private int id_aula;
    private String nome;
    private String horario;
    private int capacidade;
    private int Instrutor_id_instrutor;

    // Contrutor
    public Aula(int id_aula, String nome, String horario, int capacidade, int instrutor_id_instrutor) {

        this.id_aula = id_aula;
        this.nome = nome;
        this.horario = horario;
        this.capacidade = capacidade;
        this.Instrutor_id_instrutor = instrutor_id_instrutor;
    }

    public Aula(String nome, String horario, int capacidade, int instrutor_id_instrutor) {
        this.nome = nome;
        this.horario = horario;
        this.capacidade = capacidade;
        this.Instrutor_id_instrutor = instrutor_id_instrutor;
    };

    // Getters e Setters
    public int getId_aula() {
        return id_aula;
    }

    public void setId_aula(int id_aula) {
        this.id_aula = id_aula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getInstrutor_id_instrutor() {
        return Instrutor_id_instrutor;
    }

    public void setInstrutor_id_instrutor(int instrutor_id_instrutor) {
        Instrutor_id_instrutor = instrutor_id_instrutor;
    }
};