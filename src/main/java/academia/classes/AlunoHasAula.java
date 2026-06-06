package academia.classes;

public class AlunoHasAula {
    // Atributos
    private int Aluno_id_aluno;
    private int Aula_id_aula;

    // Contrutor
    public AlunoHasAula(int aluno_id_aluno, int aula_id_aula) {
        this.Aluno_id_aluno = aluno_id_aluno;
        this.Aula_id_aula = aula_id_aula;
    };

    // Getters e Setters
    public int getAluno_id_aluno() {
        return Aluno_id_aluno;
    }

    public void setAluno_id_aluno(int aluno_id_aluno) {
        Aluno_id_aluno = aluno_id_aluno;
    }

    public int getAula_id_aula() {
        return Aula_id_aula;
    }

    public void setAula_id_aula(int aula_id_aula) {
        Aula_id_aula = aula_id_aula;
    }

    @Override
    public String toString() {
        return "AlunoHasAula{" +
                "alunoId=" + Aluno_id_aluno +
                ", aulaId=" + Aula_id_aula +
                '}';
    }
};
