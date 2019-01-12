package Classes;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

public class Utilizador {

    private int nif;
    private String morada, nome, password;
    private LocalDate nascimento;
    private float saldo;
    private List<String> emails, pagamentos, contas;
    private List<Integer> tlm;

    public Utilizador() {
        nif = 0;
        saldo = 0;
        morada = nome = "";
        emails = new ArrayList<>();
        pagamentos = new ArrayList<>();
        tlm = new ArrayList<>();
    }

    public Utilizador(int nif, String morada, String nome, String password, LocalDate nascimento, float saldo, List<String> emails, List<String> pagamentos, List<String> contas, List<Integer> tlm) {
        this.nif = nif;
        this.morada = morada;
        this.nome = nome;
        this.password = password;
        this.nascimento = nascimento;
        this.saldo = saldo;
        this.emails = emails;
        this.pagamentos = pagamentos;
        this.contas = contas;
        this.tlm = tlm;
    }

    public List<String> getContas() {
        return contas;
    }

    public String getPassword() {
        return password;
    }

    public int getNif() {
        return nif;
    }

    public String getMorada() {
        return morada;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public float getSaldo() {
        return saldo;
    }

    public List<String> getEmails() {
        return emails;
    }

    public List<String> getPagamentos() {
        return pagamentos;
    }

    public List<Integer> getTlm() {
        return tlm;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setContas(List<String> contas) {
        this.contas = contas;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public void setPagamentos(List<String> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public void setTlm(List<Integer> tlm) {
        this.tlm = tlm;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.nif;
        hash = 71 * hash + Objects.hashCode(this.morada);
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + Objects.hashCode(this.password);
        hash = 71 * hash + Objects.hashCode(this.nascimento);
        hash = 71 * hash + Float.floatToIntBits(this.saldo);
        hash = 71 * hash + Objects.hashCode(this.emails);
        hash = 71 * hash + Objects.hashCode(this.pagamentos);
        hash = 71 * hash + Objects.hashCode(this.contas);
        hash = 71 * hash + Objects.hashCode(this.tlm);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Utilizador other = (Utilizador) obj;
        if (this.nif != other.nif) {
            return false;
        }
        if (Float.floatToIntBits(this.saldo) != Float.floatToIntBits(other.saldo)) {
            return false;
        }
        if (!Objects.equals(this.morada, other.morada)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.nascimento, other.nascimento)) {
            return false;
        }
        if (!Objects.equals(this.emails, other.emails)) {
            return false;
        }
        if (!Objects.equals(this.pagamentos, other.pagamentos)) {
            return false;
        }
        if (!Objects.equals(this.contas, other.contas)) {
            return false;
        }
        if (!Objects.equals(this.tlm, other.tlm)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Utilizador{" + "nif=" + nif + ", morada=" + morada + ", nome=" + nome + ", password=" + password + ", nascimento=" + nascimento + ", saldo=" + saldo + ", emails=" + emails + ", pagamentos=" + pagamentos + ", contas=" + contas + ", tlm=" + tlm + '}' + '\n';
    }
}
