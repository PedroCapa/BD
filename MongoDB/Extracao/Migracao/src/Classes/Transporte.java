package Classes;
import java.time.LocalDateTime;

public class Transporte {
    private String designacao;
    private String descricao;
    private float custo;
    private LocalDateTime data;

    public Transporte() {
        this.designacao = "";
        this.descricao = "";
        this.custo = 0;
        this.data = LocalDateTime.now();
    }

    public Transporte(String designacao, String descricao, float custo, LocalDateTime data) {
        this.designacao = designacao;
        this.descricao = descricao;
        this.custo = custo;
        this.data = data;
    }

    public Transporte(Transporte t) {
        this.designacao = t.getDesignacao();
        this.descricao = t.getDescricao();
        this.custo = t.getCusto();
        this.data = t.getData();
    }

    public String getDesignacao() {
        return this.designacao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public float getCusto() {
        return this.custo;
    }

    public LocalDateTime getData() {
        return this.data;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
    public Transporte clone() {
        return new Transporte(this);
    }

    public String toString() {
        return "Designacao:" + this.designacao + "\nDescricao: " + this.descricao +
               "\nCusto: " + this.custo + "\nData: " + this.data;
    }
}