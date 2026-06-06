package academia.classes;

public class Instrutor {

    private int id_instrutor;
    private String nome;
    private String especialidade;
    private double salario;

    public Instrutor() {}

    public Instrutor(String nome, String especialidade, double salario) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.salario = salario;
    }

    public Instrutor(int id_instrutor, String nome, String especialidade, double salario) {
        this.id_instrutor = id_instrutor;
        this.nome = nome;
        this.especialidade = especialidade;
        this.salario = salario;
    }

    public int getId_instrutor() {
        return id_instrutor;
    }

    public void setId_instrutor(int id_instrutor) {
        this.id_instrutor = id_instrutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Instrutor{" +
                "id=" + id_instrutor +
                ", nome='" + nome + '\'' +
                ", especialidade='" + especialidade + '\'' +
                ", salario=" + salario +
                '}';
    }
}