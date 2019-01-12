package Migracao;

import Classes.*;
import ClassesDAO.*;
import ClassesMongo.*;
import com.mongodb.*;
import com.mongodb.client.*;
import java.util.Set;
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

            // Mongo SHARE
            Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
            mongoLogger.setLevel(Level.SEVERE); 
                
            MongoClient mc = new MongoClient("localhost", 27017);
            MongoDatabase db = mc.getDatabase("Mercado");
            System.out.println("Conectado ao MongoDB");

            ProdutoMongo pm = new ProdutoMongo((Set<Produto>)proDAO.values(), mc.getDatabase("Mercado"));
            pm.insereCollection();
            TransporteMongo tm = new TransporteMongo((Set<Transporte>)traDAO.values(), mc.getDatabase("Mercado"));
            tm.insereCollection();
            UtilizadorMongo um = new UtilizadorMongo((Set<Utilizador>)userDAO.values(), mc.getDatabase("Mercado"));
            um.insereCollection();
            
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}