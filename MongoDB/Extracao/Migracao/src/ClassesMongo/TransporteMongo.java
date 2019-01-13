package ClassesMongo;

import Classes.Transporte;
import java.util.Set;
import com.mongodb.client.*;
import org.bson.Document;

public class TransporteMongo {
    private Set<Transporte> transportes;
    private MongoDatabase db;

    public TransporteMongo(Set<Transporte> transportes, MongoDatabase db){
        this.transportes = transportes;
        this.db = db;
    }

    public void insereCollection(){
        MongoCollection<Document> transporte = this.db.getCollection("Transporte");
        for(Transporte t: this.transportes){
            Document document = new Document();
            document.append("Designacao", t.getDesignacao()) 
                    .append("Descricao", t.getDescricao()) 
                    .append("Custo", t.getCusto())
                    .append("Data", t.getData());
            transporte.insertOne(document);
        }
    }
}