package ClassesMongo;

public class CarrinhoMongo {
	private Set<Carrinho> carrinho;
	private MongoDatabase db;

	public CarrinhoMongo(Carrinho carrinho, MongoDatabase db) {
		this.carrinho = carrinho;
		this.db = db;
	} 

	public void makeDocuments() {
		
	}
	
}