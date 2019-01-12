package ClassesMongo;

import Classes.Compra;
import java.util.Set;
import com.mongodb.client.*;
import org.bson.Document;

public class CompraMongo {
    private Set<Compra> compra;
    private MongoDatabase db;

    public CompraMongo(Set<Compra> compra, MongoDatabase db) {
        this.compra = compra;
        this.db = db;
    } 

    public void insereCollection() {
        MongoCollection<Document> compras = this.db.getCollection("Compra");

        for(Compra c : this.compra){
            Document document = new Document();
            document.append("Id", c.getId())
                    .append("Preco", c.getPreco())
                    .append("Quantidade", c.getQuantidade()) 
                    .append("idProduto", c.getProd());
            compras.insertOne(document);
        }
    }
}