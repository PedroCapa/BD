package Classes;

import ClassesDAO.*;
import java.util.Set;
import java.util.HashSet;

public class Transformacao {

    private Set<Carrinho> carrinhos;
    private Set<Compra> compras;
    private Set<MetodosPagamento> metodos;
    private Set<Produto> produtos;
    private Set<Transporte> transportes;
    private Set<Utilizador> utilizadores;

    public Transformacao() {
        this.carrinhos = new HashSet<>();
        this.compras = new HashSet<>();
        this.metodos = new HashSet<>();
        this.produtos = new HashSet<>();
        this.transportes = new HashSet<>();
        this.utilizadores = new HashSet<>();
    }

    public Set<Carrinho> getCarrinhos() {
        return new HashSet<>(carrinhos);
    }

    public void setCarrinhos(Set<Carrinho> carrinhos) {
        this.carrinhos = new HashSet<>(carrinhos);
    }

    public Set<Compra> getCompras() {
        return new HashSet<>(compras);
    }

    public void setCompras(Set<Compra> compras) {
        this.compras = new HashSet<>(compras);
    }

    public Set<MetodosPagamento> getMetodos() {
        return new HashSet<>(metodos);
    }

    public void setMetodos(Set<MetodosPagamento> metodos) {
        this.metodos = new HashSet<>(metodos);
    }

    public Set<Produto> getProdutos() {
        return new HashSet<>(produtos);
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = new HashSet<>(produtos);
    }

    public Set<Transporte> getTransportes() {
        return new HashSet<>(transportes);
    }

    public void setTransportes(Set<Transporte> transportes) {
        this.transportes = new HashSet<>(transportes);
    }

    public Set<Utilizador> getUtilizadores() {
        return new HashSet<>(utilizadores);
    }

    public void setUtilizadores(Set<Utilizador> utilizadores) {
        this.utilizadores = new HashSet<>(utilizadores);
    }

    public void getThemAll(CarrinhoDAO carrinho, CompraDAO compra, MetodosPagamentoDAO metodos, ProdutoDAO produtos, TransporteDAO transporte, UtilizadorDAO utilizadores){
        this.carrinhos = (Set<Carrinho>) carrinho.values();
        this.compras = (Set<Compra>) compra.values();
        this.metodos = (Set<MetodosPagamento>) metodos.values();
        this.produtos = (Set<Produto>)produtos.values();
        this.transportes = (Set<Transporte>)transporte.values();
        this.utilizadores = (Set<Utilizador>)utilizadores.values();
    }
}
