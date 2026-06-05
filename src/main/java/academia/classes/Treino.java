package academia.classes;

public class Treino {
    // Atributos
    private int id_treino;
    private String descricao;
    private String nivel;

    // Contrutor
    // (com ID)
    public Treino(int id_treino, String descricao, String nivel) {
        this.id_treino = id_treino;
        this.descricao = descricao;
        this.nivel = nivel;
    }
    // sem ID
    public Treino(String descricao, String nivel){
        this.descricao = descricao;
        this.nivel = nivel;
    };

    // Getters e Setters
    public int getId_treino() {
        return id_treino;
    }

    public void setId_treino(int id_treino) {
        this.id_treino = id_treino;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
};
