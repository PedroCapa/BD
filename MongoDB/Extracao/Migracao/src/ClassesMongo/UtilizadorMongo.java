/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesMongo;

import Classes.Utilizador;
import java.util.Set;
import com.mongodb.*;
import com.mongodb.client.*;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        Document document = new Document();
        for(Utilizador u: this.utilizadores)
            document = new Document() 
                                .append("Nif", u.getNif()) 
                                .append("Custo", u.getNome())
                                .append("Morada", u.getMorada()) 
                                .append("Nome", u.getPassword())
                                .append("Nascimento", u.getNascimento().toString())
                                .append("Saldo", u.getSaldo()) 
                                .append("Emails", u.getEmails())
                                .append("Pagamentos", u.getPagamentos()) 
                                .append("Contas", u.getContas())
                                .append("tlm", u.getTlm());
                                utilizador.insertOne(document);
    }
}
