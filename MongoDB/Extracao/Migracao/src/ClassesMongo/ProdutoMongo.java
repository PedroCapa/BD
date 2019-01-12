package ClassesMongo;

import Classes.Produto;
import java.util.Set;
import com.mongodb.client.*;
import org.bson.Document;

public class ProdutoMongo {
    private Set<Produto> produtos;
    private MongoDatabase db;

    public ProdutoMongo(Set<Produto> produtos, MongoDatabase db){
        this.produtos = produtos;
        this.db = db;
    }

    public void insereCollection(){
        MongoCollection<Document> produto = this.db.getCollection("Produto");
        
        for(Produto p: this.produtos){
            Document document = new Document();
            document.append("Id", p.getId())
                    .append("Designacao", p.getDesignacao()) 
                    .append("Descricao", p.getDescricao()) 
                    .append("Preco", p.getPreco())
                    .append("Categoria", p.getCategoria())
                    .append("Nif", p.getNif())
                    .append("Quantidade", p.getQuantidade());  
            produto.insertOne(document);
        }
    }
}