package Classes;

public class Produto {
    private int id;
    private String designacao;
    private String descricao;
    private float preco;
    private String categoria;
    private int nif;
    private int quantidade;

    public Produto(int id, String designacao, String descricao, float preco, String categoria, int nif, int quantidade) {
        this.id = id;
        this.designacao = designacao;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.nif = nif;
        this.quantidade = quantidade;
    }

    public Produto() {
        this.id = 0;
        this.designacao = "";
        this.descricao = "";
        this.preco = 0;
        this.categoria = "";
        this.nif = 0;
        this.quantidade = 0;
    }
    
    public Produto(Produto umProduto){
        this.id = umProduto.getId();
        this.designacao = umProduto.getDesignacao();
        this.descricao = umProduto.getDescricao();
        this.preco = umProduto.getPreco();
        this.categoria = umProduto.getCategoria();
        this.nif = umProduto.getNif();
        this.quantidade = umProduto.getQuantidade();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) 
            return false;
        Produto other = (Produto) obj;
        return (this.id == other.getId() && this.preco == other.getPreco() && this.nif == other.getNif() && 
                this.quantidade == other.getQuantidade() && this.designacao.equals(other.getDesignacao()) && 
                this.descricao.equals(other.getDescricao()) && this.categoria.equals(other.getCategoria()));
    }
    
    public Produto clone(){
        return new Produto (this);
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", designacao=" + designacao + ", descricao=" + descricao + ", preco=" + preco + 
               ", categoria=" + categoria + ", nif=" + nif + ", quantidade=" + quantidade + '}';
    }
}
