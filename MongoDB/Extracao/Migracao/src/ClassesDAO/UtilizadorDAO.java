package ClassesDAO;

import Classes.Utilizador;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class UtilizadorDAO implements Map<Integer, Utilizador>{

    private Connection conn;

    public UtilizadorDAO(String userName, String pass){
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
    public Utilizador get(Object key) {
        try {
            Utilizador u = null;
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM Utilizador WHERE NIF='"+Integer.toString((Integer)key)+"'";
            String telemoveis = "Select * From Telemovel Where NIF='"+Integer.toString((Integer)key)+"'";
            String emails = "Select * From Email Where NIF='"+Integer.toString((Integer)key)+"'";
            String pagamentos = "Select * From Utilizador_MetodosPagamento Where NIF='"+Integer.toString((Integer)key)+"'";
            ResultSet rs = stm.executeQuery(sql);
            List<Integer> t = new ArrayList<>();
            List<String> e = new ArrayList<>();
            List<String> p = new ArrayList<>();
            List<String> c = new ArrayList<>();
            if (rs.next()){
                u = new Utilizador();
                u.setNif(rs.getInt("NIF"));
                u.setMorada(rs.getString("Morada"));
                u.setNome(rs.getString("Nome"));
                u.setSaldo(rs.getFloat("Saldo"));
                u.setPassword(rs.getString("password"));
                Object o = rs.getObject("DataNascimento");
                String s = o.toString();
                LocalDate data = LocalDate.parse(s);
                u.setNascimento(data);
                ResultSet r = stm.executeQuery(telemoveis);
                while(r.next()){
                    t.add(r.getInt("Numero"));
                }
                u.setTlm(t);
                ResultSet res = stm.executeQuery(emails);
                while(res.next()){
                    e.add(res.getString("nome"));
                }
                u.setEmails(e);
                ResultSet rSet = stm.executeQuery(pagamentos);
                while(rSet.next()){
                    p.add(rSet.getString("metodo"));
                    c.add(rSet.getString("NumConta"));
                }
                u.setPagamentos(p);
                u.setContas(c);
            }
            return u;
        }
        catch (NumberFormatException | SQLException e) {throw new NullPointerException(e.getMessage());}
    }

    @Override
    public Utilizador put(Integer k, Utilizador v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilizador remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Utilizador> map) {
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
            String str = "Select NIF From Utilizador";
            ResultSet res = st.executeQuery(str);
            while(res.next()){
                ids.add(res.getInt("NIF"));
            }
            return ids;
        }
        catch(SQLException exc){throw new NullPointerException(exc.getMessage());}
    }

    @Override
    public Collection<Utilizador> values() {
        Collection<Utilizador> utilizadores;
        utilizadores = new HashSet<>();
        Set<Integer> keys = keySet();
        for(Integer i: keys){
            Utilizador user = this.get(i);
            utilizadores.add(user);
        }
        return utilizadores;
    }

    @Override
    public Set<Entry<Integer, Utilizador>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}