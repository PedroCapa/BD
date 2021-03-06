package ClassesMongo;

import Classes.Utilizador;
import java.util.Set;
import com.mongodb.client.*;
import org.bson.Document;

public class UtilizadorMongo {
    private Set<Utilizador> utilizadores;
    private MongoDatabase db;

    public UtilizadorMongo(Set<Utilizador> utilizadores, MongoDatabase db){
        this.utilizadores = utilizadores;
        this.db = db;
    }

    public void insereCollection(){
        MongoCollection<Document> utilizador = this.db.getCollection("Utilizador");
        for(Utilizador u: this.utilizadores){
            Document document = new Document();
            document.append("Nif", u.getNif()) 
                    .append("Nome", u.getNome())
                    .append("Morada", u.getMorada()) 
                    .append("Password", u.getPassword())
                    .append("Nascimento", u.getNascimento().toString())
                    .append("Saldo", u.getSaldo()) 
                    .append("Emails", u.getEmails())
                    .append("Pagamentos", u.getPagamentos()) 
                    .append("Contas", u.getContas())
                    .append("tlm", u.getTlm());
            utilizador.insertOne(document);
        }
    }
}