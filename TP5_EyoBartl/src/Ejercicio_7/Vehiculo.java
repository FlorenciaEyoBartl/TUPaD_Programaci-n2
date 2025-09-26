
package Ejercicio_7;


public class Vehiculo {
    private String patente;
    private String modelo;
    private Motor motor;       // ← AGREGACIÓN (0..1)
    private Conductor conductor; // ← ASOCIACIÓN BIDIRECCIONAL (0..1)
    
    // Constructor SIN motor (agregación)
        public Vehiculo(String patente, String modelo) {
        this.patente = patente;
        this.modelo = modelo;
        this.motor = null;     // Inicialmente sin motor
        this.conductor = null; // Inicialmente sin conductor
    }
    
    // Getters
    public String getPatente() { return patente; }
    public String getModelo() { return modelo; }
    public Motor getMotor() { return motor; }
    public Conductor getConductor() { return conductor; }
    
    // Setter para AGREGACIÓN (motor)
    public void setMotor(Motor motor) {
        this.motor = motor;
        if (motor != null) {
            motor.setVehiculo(this); // Relación inversa
        }
    }
    
    // Setter para ASOCIACIÓN BIDIRECCIONAL (conductor)
    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
        //BIDIRECCIONALIDAD el conductor también conoce este vehículo
        if (conductor != null) {
            conductor.setVehiculo(this);
        }
    }
}
