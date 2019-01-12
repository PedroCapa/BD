package Classes;
import java.time.LocalDate;


public class Carrinho {
    private int id;
    private LocalDate data;
    private long nif;
    private String idTransporte;

    public Carrinho() {
        this.id = 0;
        this.data = LocalDate.now();
        this.nif = 0;
        this.idTransporte = "";
    }

    public Carrinho(int id, LocalDate data, long nif, String idTransporte) {
        this.id = id;
        this.data = data;
        this.nif = nif;
        this.idTransporte = idTransporte;
    }

    public Carrinho(Carrinho c) {
        this.id = c.getId();
        this.data = c.getData();
        this.nif = c.getNif();
        this.idTransporte = c.getIdTransporte();
    }

    public int getId() {
        return this.id;
    }

    public LocalDate getData() {
        return this.data;
    }

    public long getNif() {
        return this.nif;
    }

    public String getIdTransporte() {
        return this.idTransporte;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
 
    public void setNif(long nif) {
        this.nif = nif;
    }

    public void setIdTransporte(String idTransporte) {
        this.idTransporte = idTransporte;
    }

    public Carrinho clone() {
        return new Carrinho(this);
    }

    public String toString() {
        return "\n\nId:" + this.id + "\nData: " + this.data +
               "\nNif: " + this.nif + "\nIdTransporte:" + this.idTransporte;
    }
}