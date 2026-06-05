package academia.classes;

public class Plano {
    // Atributos
    private int id_plano;
    private String nome;
    private double valor;
    private int duracao;

    // Contrutor
    public Plano(int id_plano, String nome, double valor, int duracao) {
        this.id_plano = id_plano;
        this.nome = nome;
        this.valor = valor;
        this.duracao = duracao;
    };

    public Plano(String nome, double valor, int duracao){
        this.nome = nome;
        this.valor = valor;
        this.duracao = duracao;
    };

    // Getters e Setters
    public int getId_plano() {
        return id_plano;
    }

    public void setId_plano(int id_plano) {
        this.id_plano = id_plano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

};
