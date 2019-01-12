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

public class MetodosPagamentoDAO {

	private Connection conn;

	public MetodosPagamentoDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost/configurafacil?" + "user=LFCC&password=55luis14&useSSL=false";
            this.conn = DriverManager.getConnection(connectionUrl);
        }
        catch(ClassNotFoundException | SQLException exc){}
	}

    public Collection<MetodosPagamento> values(){
        Collection<MetodosPagamento> metodosPagamento = new HashSet<>();
        Set<String> keys = keySet();
        for(String s: keys){
            MetodosPagamento mp = this.get(s);
            metodosPagamento.add(mp);
        }
        return metodosPagamento;
    }
    
    public Set<String> keySet() {
        try{
            Set<String> ids = new HashSet<>();
            Statement st = conn.createStatement();
            String str = "Select id From MetodosPagamento";
            ResultSet res = st.executeQuery(str);
            while(res.next()){
                ids.add(res.getString("id"));
            }
            return ids;
        }
        catch(SQLException exc){throw new NullPointerException(exc.getMessage());}
    }

	public MetodosPagamento get(Object key) {
        try {
            MetodosPagamento metodosPagamento = null;
            Statement stm = conn.createStatement();
            String sql = "SELECT * FROM MetodosPagamento WHERE id='"+(String)key+"'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()){
                metodosPagamento = new MetodosPagamento();
                metodosPagamento.setId(rs.getString("id"));
                metodosPagamento.setDesignacao(rs.getString("Designacao"));
            }
            return metodosPagamento;
        }
        catch (NumberFormatException | SQLException e) {throw new NullPointerException(e.getMessage());}
    }


}