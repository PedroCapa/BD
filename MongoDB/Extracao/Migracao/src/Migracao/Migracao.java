package Migracao;

import com.mongodb.*;
import com.mongodb.client.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;

public class Migracao {

    public static void main(String[] args) {
        try {
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
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }    
}
