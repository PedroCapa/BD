package Migracao;

import com.mongodb.*;
import com.mongodb.client.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;  

public class Migracao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
            mongoLogger.setLevel(Level.SEVERE); 
                
            MongoClient mc = new MongoClient("localhost", 27017);
            MongoDatabase db = mc.getDatabase("local");
            System.out.println("MongoDb connected");
        
            MongoCollection<Document> collection = db.getCollection("startup_log"); 
            System.out.println("Collection sampleCollection selected successfully");

            Document document = new Document("title", "MongoDB") 
                                .append("id", 1)
                                .append("description", "database") 
                                .append("likes", 100) 
                                .append("url", "http://www.tutorialspoint.com/mongodb/") 
                                .append("by", "tutorials point");  
                                collection.insertOne(document); 
                                System.out.println("Document inserted successfully");
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }    
}
