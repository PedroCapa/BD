package ClassesMongo;

import Classes.MetodosPagamento;
import java.util.Set;
import com.mongodb.client.*;
import org.bson.Document;

public class MetodosPagamentoMongo {
    private Set<MetodosPagamento> metodosdePagamento;
    private MongoDatabase db;

    public MetodosPagamentoMongo(Set<MetodosPagamento> metodosdePagamento, MongoDatabase db) {
        this.metodosdePagamento = metodosdePagamento;
        this.db = db;
    }

    public void insereCollection() {
        MongoCollection<Document> metodos = this.db.getCollection("MetodosPagamento");

        for(MetodosPagamento m : this.metodosdePagamento){
            Document document = new Document();
            document.append("Id", m.getId())
                    .append("Designacao", m.getDesignacao());
            metodos.insertOne(document);
        }
    }
}