import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;

public class Receita {
    private String nome;
    private String tipo;
    private LocalDate data;
    private double valor;
    public Receita(String nome, String tipo, LocalDate data, double valor){
        this.nome = nome;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
