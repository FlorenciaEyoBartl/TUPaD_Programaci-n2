
package Model;
import java.time.LocalDate;
import java.util.Objects;

public class Envio extends Base{
    private String tracking;
    private Empresas empresa;
    private Tipos tipo;
    private double costo;
    private LocalDate fechaDespacho;
    private LocalDate fechaEstimada;
    private EstadosEnvios estadoEnvio;
                        
    
    // Constructores con metodos SUPER()
    public Envio(long id, boolean eliminado, String tracking, Empresas empresa, Tipos tipo, double costo, LocalDate fehcaDespacho, LocalDate fechaEstimada, EstadosEnvios estadoEnvio) {
        super(id, eliminado);
        this.tracking = tracking;
        this.empresa = empresa;
        this.tipo = tipo;
        this.costo = costo;
        this.fechaDespacho = fehcaDespacho;
        this.fechaEstimada = fechaEstimada;
        this.estadoEnvio = estadoEnvio;
    }

    public Envio() {
        super();
    }// Constructor vacio.

    
    
    public String getTracking() {
        return tracking;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public Empresas getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }

    public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public LocalDate getFechaDespacho() {
        return fechaDespacho;
    }

    public void setFechaDespacho(LocalDate fehcaDespacho) {
        this.fechaDespacho = fehcaDespacho;
    }

    public LocalDate getFechaEstimada() {
        return fechaEstimada;
    }

    public void setFechaEstimada(LocalDate fechaEstimada) {
        this.fechaEstimada = fechaEstimada;
    }

    public EstadosEnvios getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(EstadosEnvios estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.tracking);
        hash = 59 * hash + Objects.hashCode(this.empresa);
        hash = 59 * hash + Objects.hashCode(this.tipo);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.costo) ^ (Double.doubleToLongBits(this.costo) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.fechaDespacho);
        hash = 59 * hash + Objects.hashCode(this.fechaEstimada);
        hash = 59 * hash + Objects.hashCode(this.estadoEnvio);
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
        final Envio other = (Envio) obj;
        if (Double.doubleToLongBits(this.costo) != Double.doubleToLongBits(other.costo)) {
            return false;
        }
        if (!Objects.equals(this.tracking, other.tracking)) {
            return false;
        }
        if (this.empresa != other.empresa) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        if (!Objects.equals(this.fechaDespacho, other.fechaDespacho)) {
            return false;
        }
        if (!Objects.equals(this.fechaEstimada, other.fechaEstimada)) {
            return false;
        }
        return this.estadoEnvio == other.estadoEnvio;
    }

    @Override
    public String toString() {
        return "Envio{" + "tracking=" + tracking + ", empresa=" + empresa + ", tipo=" + tipo + ", costo=" + costo + ", fechaDespacho=" + fechaDespacho + ", fechaEstimada=" + fechaEstimada + ", estadoEnvio=" + estadoEnvio + '}';
    }
    
    
    
}
