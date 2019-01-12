package ClassesMongo;

import Classes.Carrinho;
import com.mongodb.client.MongoDatabase;
import java.util.Set;

public class CarrinhoMongo {
	private Set<Carrinho> carrinho;
	private MongoDatabase db;

	public CarrinhoMongo(Set<Carrinho> carrinho, MongoDatabase db) {
		this.carrinho = carrinho;
		this.db = db;
	} 

	public void makeDocuments() {
		
	}
	
}