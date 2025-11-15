package Model;

import java.time.LocalDate;
import java.util.Objects;


public class Pedido extends Base{
    private String numero;
    private LocalDate fecha;
    private String clienteNombre;
    private double total;
    private Estados estado;
    private Envio envio;

    // Constructores con metodos SUPER() 
 public Pedido(String numero, LocalDate fecha, String clienteNombre, double total, 
              Estados estado, Envio envio, long id, boolean eliminado) {
    super(id, eliminado);
    this.numero = numero;
    this.fecha = fecha;
    this.clienteNombre = clienteNombre;
    this.total = total;
    this.estado = estado;
    this.envio = envio;
}
    public Pedido(){
        super();
    }  // Constructor vacio.

    // Metodos get y set.
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public Envio getEnvio() {
        return envio;
    }

    public void setEnvio(Envio envio) {
        this.envio = envio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.numero);
        hash = 71 * hash + Objects.hashCode(this.fecha);
        hash = 71 * hash + Objects.hashCode(this.clienteNombre);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.total) ^ (Double.doubleToLongBits(this.total) >>> 32));
        hash = 71 * hash + Objects.hashCode(this.estado);
        hash = 71 * hash + Objects.hashCode(this.envio);
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
        final Pedido other = (Pedido) obj;
        if (Double.doubleToLongBits(this.total) != Double.doubleToLongBits(other.total)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.clienteNombre, other.clienteNombre)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        return Objects.equals(this.envio, other.envio);
    }

    @Override
    public String toString() {
        return "Pedido{" + "numero=" + numero + ", fecha=" + fecha + ", clienteNombre=" + clienteNombre + ", total=" + total + ", estado=" + estado + ", envio=" + envio + '}';
    }
}