
import ClassesDAO.*;
import Classes.*;
import java.util.Collection;

public class Main {
    
    public static void main(String [] args){
        
        String userName = args[0];
        String pass = args[1];
        
        Transformacao t = new Transformacao();
        
        CarrinhoDAO carDAO = new CarrinhoDAO(userName, pass);
        /*
        CompraDAO comDAO = new CompraDAO(userName, pass);
        MetodosPagamentoDAO mpDAO = new MetodosPagamentoDAO(userName, pass);
        ProdutoDAO proDAO = new ProdutoDAO(userName, pass);
        TransporteDAO traDAO = new TransporteDAO(userName, pass);
        UtilizadorDAO userDAO = new UtilizadorDAO(userName, pass);
        
        Collection<Carrinho> carrinhos = carDAO.values();
        Collection<Compra> compras = comDAO.values();
        Collection<MetodosPagamento> pagamentos = mpDAO.values();
        Collection<Produto> produtos = proDAO.values();
        Collection<Transporte> transportes = traDAO.values();
        Collection<Utilizador> utilizadores = userDAO.values();
        carrinhos.forEach((car) -> {System.out.println(car);});
        compras.forEach((compra) -> {System.out.println(compra);});
        pagamentos.forEach((pag) -> {System.out.println(pag);});
        produtos.forEach((prod) -> {System.out.println(prod);});
        transportes.forEach((trans) -> {System.out.println(trans);});
        utilizadores.forEach((users) -> {System.out.println(users);});
    */
    }
}