package ClassesDAO;

import Classes.*;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CompraDAO {

    private Connection conn;

    public CompraDAO(String userName, String pass){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost/mercado?" + "user="+userName+"&password="+pass+"&useSSL=false";
            this.conn = DriverManager.getConnection(connectionUrl);
        }
        catch(ClassNotFoundException | SQLException exc){}
    }

    public Set<Entry<Integer, Utilizador>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Collection<Compra> values(){
        Collection<Compra> compras = new HashSet<>();
        Set<Integer> keys = keySet();
        for(Integer i: keys){
            Compra com = this.get(i);
            compras.add(com);
        }
        return compras;
    }

    public Set<Integer> keySet() {
        try{
            Set<Integer> ids = new HashSet<>();
            Statement st = conn.createStatement();
            String str = "Select id From Compra";
            ResultSet res = st.executeQuery(str);
            while(res.next()){
                ids.add(Integer.valueOf(res.getString("id")));
            }
            return ids;
        }
        catch(SQLException exc){throw new NullPointerException(exc.getMessage());}
    }

    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Compra put(int key, Compra value) {
        try {
            Statement stm = conn.createStatement();
            String sql = "INSERT INTO Compra (id, preco, quantidade, cart, prod) VALUES ";
            sql += "("+value.getId()+",";
            sql += "'" +value.getPreco()+",'"+value.getQuantidade()+"','"+value.getCart()+"','"+value.getProd()+"', '" + "')";
            int i  = stm.executeUpdate(sql);
            return new Compra(value);
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }

    public Compra get(Object key) {
        try {
            Compra compra = null;
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Compra WHERE id='"+key+"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()){
                compra = new Compra();
                compra.setId(rs.getInt("id"));
                compra.setPreco(rs.getFloat("Preco"));
                compra.setQuantidade(rs.getInt("Quantidade"));
                compra.setCart(Integer.valueOf(rs.getString("Cart")));
                compra.setProd(Integer.valueOf(rs.getString("Prod")));
            }
            return compra;
        }
        catch (NumberFormatException | SQLException e) {throw new NullPointerException(e.getMessage());}
    }

    public boolean containsKey(Object key){
        try{    
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Compra WHERE id='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        }
        catch(SQLException exc){throw new NullPointerException(exc.getMessage());}
    }
    public boolean isEmpty(){
        try {
            Statement stm = conn.createStatement();
            String sql = "SELECT id FROM Compra";
            ResultSet rs = stm.executeQuery(sql);
            return rs.next();
        } catch (SQLException exc) {throw new NullPointerException(exc.getMessage());}
    }

    public int size() {
        try {
            int i = 0;
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT id FROM Compra");
            for (;rs.next();i++);
            return i;
        }
        catch (SQLException e) {throw new NullPointerException(e.getMessage());}
    }

    public void getCompra(Carrinho carrinho){
        try {
            int idCarrinho = carrinho.getId();
            String sql = "Select Id From Compra Where Cart="+idCarrinho;
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            List<Integer> idCompras = new ArrayList<>();
            while(res.next()){
                idCompras.add(res.getInt("Id"));
            }
            carrinho.setCompras(idCompras);
        } catch (SQLException ex) {}
    }
}