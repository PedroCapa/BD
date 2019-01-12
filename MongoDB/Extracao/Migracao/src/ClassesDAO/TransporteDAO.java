/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;
import Classes.Transporte;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 *
 * @author Luis
 */
public class TransporteDAO implements Map<String, Transporte>{

    private Connection conn;    
    public TransporteDAO(String userName, String pass){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost/mercado?" + "user="+userName+"&password="+pass+"&useSSL=false";
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
    public Transporte get(Object key) {
        try {
            Transporte transporte = null;
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Transporte WHERE Designacao='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()){
                transporte = new Transporte();
                transporte.setDesignacao(rs.getString("Designacao"));
                transporte.setDescricao(rs.getString("Descricao"));
                transporte.setCusto(rs.getFloat("Custo"));
                transporte.setData(rs.getInt("TempoEstimado"));
            }
            return transporte;
        }
        catch (NumberFormatException | SQLException e) {throw new NullPointerException(e.getMessage());}
    }

    @Override
    public Transporte put(String k, Transporte v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Transporte remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<String> keySet() {
        try{
            Set<String> ids = new HashSet<>();
            Statement st = conn.createStatement();
            String str = "Select Designacao From Transporte";
            ResultSet res = st.executeQuery(str);
            while(res.next()){
                ids.add(res.getString("Designacao"));
            }
            return ids;
        }
        catch(SQLException exc){throw new NullPointerException(exc.getMessage());}
    }

    @Override
    public Collection<Transporte> values() {
        Collection<Transporte> transportes = new HashSet<>();
        Set<String> keys = this.keySet();
        for(String str: keys){
            Transporte t = this.get(str);
            transportes.add(t);
        }
        return transportes;
    }

    @Override
    public Set<Entry<String, Transporte>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends String, ? extends Transporte> map) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
