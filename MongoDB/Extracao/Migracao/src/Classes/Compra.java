package Classes;

import java.util.Objects;

public class Compra {

    private int id;
    private float preco;
    private int quantidade;
    private int cart;
    private int prod;

    public Compra(int id, float preco, int quantidade, int cart, int prod) {
        this.id = id;
        this.preco = preco;
        this.quantidade = quantidade;
        this.cart = cart;
        this.prod = prod;
    }

    public Compra(){
        this.id = 0;
        this.preco = 0;
        this.quantidade = 0;
        this.cart = 0;
        this.prod = 0;  
    }

    public Compra(Compra umaCompra){
        this.id = umaCompra.getId();
        this.preco = umaCompra.getPreco();
        this.quantidade = umaCompra.getQuantidade();
        this.cart = umaCompra.getCart();
        this.prod = umaCompra.getProd();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getCart() {
        return cart;
    }

    public void setCart(int cart) {
        this.cart = cart;
    }

    public int getProd() {
        return prod;
    }

    public void setProd(int prod) {
        this.prod = prod;
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
        Compra
         other = (Compra) obj;
        return (this.id == other.getId() && this.preco == other.getPreco() && this.quantidade == other.getQuantidade() && 
                this.cart == other.getCart() && this.prod == other.getProd());
    }

    public Compra clone(){
        return new Compra (this);
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", preco=" + preco + ", quantidade=" + quantidade +  ", carrinho=" + cart + ", produto=" + prod + '}' + '\n';
    }
}