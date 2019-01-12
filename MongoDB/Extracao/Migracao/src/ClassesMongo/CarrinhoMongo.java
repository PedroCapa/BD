package ClassesMongo;

import Classes.Carrinho;
import java.util.Set;
import com.mongodb.client.*;
import org.bson.Document;

public class CarrinhoMongo {
    private Set<Carrinho> carrinho;
    private MongoDatabase db;

    public CarrinhoMongo(Set<Carrinho> carrinho, MongoDatabase db) {
        this.carrinho = carrinho;
        this.db = db;
    }

    public void insereCollection() {
        MongoCollection<Document> carrinhos = this.db.getCollection("Carrinho");

        for(Carrinho c : this.carrinho){
            Document document = new Document();
            document.append("Id", c.getId())
                    .append("Data", c.getData())
                    .append("Nif", c.getNif()) 
                    .append("idTransporte", c.getIdTransporte())
                    .append("Compras", c.getCompras());
            carrinhos.insertOne(document);
        }
    }
}