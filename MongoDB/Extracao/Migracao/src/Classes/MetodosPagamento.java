package Classes;

import java.util.Objects;

public class MetodosPagamento {

	private String id;
	private String designacao;

	public MetodosPagamento(){
		id = "";
		designacao = "";
	}

	public MetodosPagamento(String id, String designacao){
		this.id = id;
		this.designacao = designacao;
	}

	public MetodosPagamento(MetodosPagamento umMetodo){
        this.id = umMetodo.getId();
        this.designacao = umMetodo.getDesignacao();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesignacao() {
    	return designacao;
    }

    public void setDesignacao(String designacao){
    	this.designacao = designacao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.designacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) 
            return false;
        MetodosPagamento
         other = (MetodosPagamento) obj;
        return (this.id.equals(other.getId()) && this.designacao.equals(other.getDesignacao()));
    }
    
    public MetodosPagamento clone(){
        return new MetodosPagamento (this);
    }

    @Override
    public String toString() {
        return "Método de Pagamento{" + "id=" + id + ", designacao=" + designacao + '}' + '\n';
    }

}