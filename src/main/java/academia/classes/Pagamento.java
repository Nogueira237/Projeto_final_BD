package academia.classes;

public class Pagamento {
    // Atributos
    private int id_pagamento;
    private double valor;
    private String data_pagamento;
    private String pago;
    private int Aluno_id_aluno;

    // Contrutor
    public Pagamento(int id_pagamento, double valor, String data_pagamento, String pago, int aluno_id_aluno) {
        this.id_pagamento = id_pagamento;   // COM ID
        this.valor = valor;
        this.data_pagamento = data_pagamento;
        this.pago = pago;
        this.Aluno_id_aluno = aluno_id_aluno;
    }

    public Pagamento(double valor, String data_pagamento, String pago, int aluno_id_aluno) {
        this.valor = valor;
        this.data_pagamento = data_pagamento;
        this.pago = pago;
        this.Aluno_id_aluno = aluno_id_aluno;
    };

    // Getters e Setters
    public int getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(String data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public int getAluno_id_aluno() {
        return Aluno_id_aluno;
    }

    public void setAluno_id_aluno(int aluno_id_aluno) {
        Aluno_id_aluno = aluno_id_aluno;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "id=" + id_pagamento +
                ", valor=" + valor +
                ", data='" + data_pagamento + '\'' +
                ", pago='" + pago + '\'' +
                ", alunoId=" + Aluno_id_aluno +
                '}';
    }
};
