package Migracao;

import Classes.Transformacao;
import ClassesDAO.*;
import com.mongodb.*;
import com.mongodb.client.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

public class Migracao {

    public static void main(String[] args) {
        try {

            String userName = args[0];
            String pass = args[1];

            Transformacao t = new Transformacao();

            // Vai buscar à base dados MySql
            CarrinhoDAO carDAO = new CarrinhoDAO(userName, pass);
            CompraDAO comDAO = new CompraDAO(userName, pass);
            MetodosPagamentoDAO mpDAO = new MetodosPagamentoDAO(userName, pass);
            ProdutoDAO proDAO = new ProdutoDAO(userName, pass);
            TransporteDAO traDAO = new TransporteDAO(userName, pass);
            UtilizadorDAO userDAO = new UtilizadorDAO(userName, pass);

            t.getThemAll(carDAO, comDAO, mpDAO, proDAO, traDAO, userDAO);

            System.out.println(t.getCarrinhos());
            System.out.println(t.getUtilizadores());
    
            /*
            compras.forEach((compra) -> {System.out.println(compra);});
            pagamentos.forEach((pag) -> {System.out.println(pag);});
            produtos.forEach((prod) -> {System.out.println(prod);});
            transportes.forEach((trans) -> {System.out.println(trans);});
            utilizadores.forEach((users) -> {System.out.println(users);});
            */

            // Mongo SHARE
            /*
            Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
            mongoLogger.setLevel(Level.SEVERE); 
                
            MongoClient mc = new MongoClient("localhost", 27017);
            MongoDatabase db = mc.getDatabase("Mercado");
            System.out.println("Conectado ao MongoDB");

            MongoCollection<Document> carrinho = db.getCollection("Carrinho"); 
            System.out.println("Tenho um carrinho."); 
            MongoCollection<Document> produto = db.getCollection("Produto"); 
            System.out.println("Tenho um produto."); 
            MongoCollection<Document> transporte = db.getCollection("Transporte"); 
            System.out.println("Tenho um transporte.");
            MongoCollection<Document> compra = db.getCollection("Compra"); 
            System.out.println("Tenho uma compra."); 
            MongoCollection<Document> utilizador = db.getCollection("Utilizador"); 
            System.out.println("Tenho um utilizador.");
            MongoCollection<Document> metodos = db.getCollection("Metodos_Pagamento"); 
            System.out.println("Tenho metodos de pagamento.");

            Document document = new Document("title", "MongoDB") 
                                .append("id", 1)
                                .append("description", "database") 
                                .append("likes", 100) 
                                .append("url", "http://www.tutorialspoint.com/mongodb/") 
                                .append("by", "tutorials point");  
                                carrinho.insertOne(document); 
                                System.out.println("Document inserted successfully");
            */
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}