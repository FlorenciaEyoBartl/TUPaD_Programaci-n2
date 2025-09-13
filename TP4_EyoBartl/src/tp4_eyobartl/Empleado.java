package tp4_eyobartl;


public class Empleado {
    
    // Atributos con encapsulamiento (atributos privados + getters/setters para control)
    private int id;
    private String nombre;
    private String puesto;
    private double salario;
    private static int totalEmpleados = 0; // Contador. Atributo estático de clase
    
    // Constructor que recibe todos los atributos
    // this referencia al objeto actual. Sirve para diferenciar entre atributos y parámetros que tienen el mismo nombre.
    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        totalEmpleados++; // Incrementar contador estático
    }
    
    // Constructor sobrecargado (solo nombre y puesto)
    public Empleado(String nombre, String puesto) {
        this.id = totalEmpleados + 1; // ID automático
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = 1000.0; // Salario por defecto
        totalEmpleados++; // Incrementar contador estático
    }
    
    // Métodos sobrecargados para actualizar salario
    public void actualizarSalario(double porcentajeAumento) {
        this.salario = this.salario * (1 + porcentajeAumento / 100);
    }
    
    public void actualizarSalario(int aumentoFijo) {
        this.salario += aumentoFijo;
    }
    
    // Método toString para representación legible por consola
    @Override
    public String toString() {
        return "Empleado [ID: " + id + ", Nombre: " + nombre + 
               ", Puesto: " + puesto + ", Salario: $" + salario + "]";
    }
    
    // Método estático para mostrar total de empleados
    public static int mostrarTotalEmpleados() {
        return totalEmpleados;
    }
    
    // Getters (encapsulamiento)
    public int getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getPuesto() {
        return puesto;
    }
   
    public double getSalario() {
        return salario;
    }
    
    // Setters (encapsulamiento)
    public void setId(int id) {
        this.id = id;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    public void setSalario(double salario) {
        this.salario = salario;
    }
}
    
