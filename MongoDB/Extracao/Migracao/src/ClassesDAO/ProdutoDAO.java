package ClassesDAO;

import Classes.Produto;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO {
    private Connection conn;
    
    public ProdutoDAO(String userName, String pass){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost/mercado?" + "user="+userName+"&password="+pass+"&useSSL=false";
            this.conn = DriverManager.getConnection(connectionUrl);
        }
        catch(ClassNotFoundException | SQLException exc){}
    }
    
    public Set<Map.Entry<String,Produto>> entrySet() {
        throw new NullPointerException("public Set<Map.Entry<String,Carro>> entrySet() not implemented!");
    }
    
    public Collection<Produto> values(){
        Collection<Produto> produtos = new HashSet<>();
        Set<String> keys = this.keySet();
        for(String str: keys){
            Produto car = this.get(str);
            produtos.add(car);
        }
        return produtos;
    }
    
    public Set<String> keySet() {
        try{
            Set<String> ids = new HashSet<>();
            Statement st = conn.createStatement();
            String str = "Select id From Produto";
            ResultSet res = st.executeQuery(str);
            while(res.next()){
                ids.add(res.getString("id"));
            }
            return ids;
        }
        catch(SQLException exc){throw new NullPointerException(exc.getMessage());}
    }
    
    public void clear(){
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("Delete From Compra");
            stm.executeUpdate("DELETE FROM Produto");
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    public void putAll(Map<? extends String,? extends Produto> t) {
        throw new NullPointerException("Not implemented!");
    }
    
    public Produto remove(Object key) {
        try {
            String chave = (String)key;
            Produto car = this.get(chave);
            String s = "Delete From Compra Where Prod='"+chave+"'";
            Statement st = this.conn.createStatement();
            int j = st.executeUpdate(s);
            Statement stm = conn.createStatement();
            String sql = "DELETE FROM Produto Where id='"+chave+"'";
            int i  = stm.executeUpdate(sql);
            return car;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    public Produto put(int key, Produto value) {
        try {
            Statement stm = conn.createStatement();
            String sql = "INSERT INTO Produto (Designacao, Descricao, Preco, Categoria, NIF, Quantidade) VALUES ";
            sql += "("+value.getDesignacao()+",";
            sql += "'" + value.getDescricao()+"', "+value.getPreco()+", '"+value.getCategoria()+"','"+value.getNif()+"', '"+value.getQuantidade() + "')";
            int i  = stm.executeUpdate(sql);
            return new Produto(value);
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    public Produto get(Object key) {
        try {
            Produto produto = null;
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Produto WHERE id='"+key+"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()){
                produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDesignacao(rs.getString("Designacao"));
                produto.setPreco(rs.getFloat("Preco"));
                produto.setDescricao(rs.getString("Descricao"));
                produto.setCategoria(rs.getString("Categoria"));
                produto.setNif(rs.getInt("NIF"));
                produto.setQuantidade(rs.getInt("Quantidade"));
            }
            return produto;
        }
        catch (NumberFormatException | SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    public boolean containsKey(Object key){
        try{    
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Produto WHERE id='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        }
        catch(SQLException exc){throw new NullPointerException(exc.getMessage());}
    }
    
    public boolean containsValue(Object value) {
        throw new NullPointerException("public boolean containsValue(Object value) not implemented!");
    }
    
    public boolean isEmpty(){
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT id FROM Produto";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        } catch (SQLException exc) {throw new NullPointerException(exc.getMessage());}
    }
    
    public int size() {
        try {
            int i = 0;
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT id FROM Produto");
            for (;rs.next();i++);
            return i;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }
    
    public void update(Produto produto){
        try {
            int id = produto.getId();
            int quantidade = produto.getQuantidade();
            String sql = "Update Carro Set Estado="+quantidade+" Where id='"+id+"'";
            Statement stm = conn.createStatement();
        } catch (SQLException ex) {throw new NullPointerException(ex.getMessage());}
    }
    
    public void updateAll(List<Produto> produtos){
        for(Produto c: produtos){
            this.update(c);
        }
    }
}
