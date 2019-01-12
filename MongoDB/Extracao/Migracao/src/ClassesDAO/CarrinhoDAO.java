/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;
import Classes.Carrinho;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 *
 * @author Luis
 */
public class CarrinhoDAO implements Map<Integer, Carrinho>{
    
    private Connection conn;
    
    public CarrinhoDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost/configurafacil?" + "user=LFCC&password=55luis14&useSSL=false";
            this.conn = DriverManager.getConnection(connectionUrl);
        }
        catch(ClassNotFoundException | SQLException exc){}
    }    
    
    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsKey(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsValue(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Carrinho get(Object key) {
        
        try {
            Carrinho carrinho = null;
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Carrinho WHERE Id='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()){
                carrinho = new Carrinho();
                carrinho.setId(rs.getInt("Id"));
                carrinho.setNif(rs.getLong("NIF"));
                carrinho.setIdTransporte(rs.getInt("trans"));
                Object o = rs.getObject("data");
                String s = o.toString();
                LocalDate data = LocalDate.parse(s);
                carrinho.setData(data);
                
            }
            return carrinho;
        }
        catch (NumberFormatException | SQLException e) {throw new NullPointerException(e.getMessage());}
    }

    @Override
    public Carrinho put(Integer k, Carrinho v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Carrinho remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Carrinho> map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Integer> keySet() {
        try{
            Set<Integer> ids = new HashSet<>();
            Statement st = conn.createStatement();
            String str = "Select Id From Carrinho";
            ResultSet res = st.executeQuery(str);
            while(res.next()){
                ids.add(res.getInt("Id"));
            }
            return ids;
        }
        catch(SQLException exc){throw new NullPointerException(exc.getMessage());}
    }

    @Override
    public Collection<Carrinho> values() {
        Collection<Carrinho> carrinhos = new HashSet<>();
        Set<Integer> keys = this.keySet();
        for(int i: keys){
            Carrinho car = this.get(i);
            carrinhos.add(car);
        }
        return carrinhos;
    }

    @Override
    public Set<Entry<Integer, Carrinho>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
