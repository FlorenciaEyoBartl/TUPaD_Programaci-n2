
//Para correr cada clase principal precione click derecho y luego "Run File"
package Ejercicio_7;


public class Principal7 {
     public static void main(String[] args) {
        System.out.println("EJERCICIO 7");
        
        //Crear Motor (agregación)
        Motor motor = new Motor("V8", "M123456");
        
        //Crear Conductor (asociación bidireccional)
        Conductor conductor = new Conductor("Roberto Díaz", "B1234567");
        
        //Crear Vehículo SIN motor inicialmente
        Vehiculo vehiculo = new Vehiculo("ABC123", "Toyota Hilux");
        
        //Establece AGREGACIÓN (motor)
        vehiculo.setMotor(motor);
        
        //Establece ASOCIACIÓN BIDIRECCIONAL
        vehiculo.setConductor(conductor);
        
        //relaciones
        System.out.println("Vehículo: " + vehiculo.getModelo() + " (" + vehiculo.getPatente() + ")");
        System.out.println("Motor: " + vehiculo.getMotor().getTipo() + 
                         " (Serie: " + vehiculo.getMotor().getNumeroSerie() + ")");
        System.out.println("Conductor: " + vehiculo.getConductor().getNombre() +
                         " (Licencia: " + vehiculo.getConductor().getLicencia() + ")");
        
        //bidireccionalidad
        System.out.println("Bidireccionalidad ¿Conductor vehiculo = vehiculo? " + 
                          (conductor.getVehiculo() == vehiculo)); // true
        
        //AGREGACIÓN (cambiar motor)
        Motor nuevoMotor = new Motor("V6", "M789012");
        vehiculo.setMotor(nuevoMotor);
        System.out.println("Nuevo motor: " + vehiculo.getMotor().getTipo());
        
        //(vehículo sin conductor)
        Vehiculo vehiculoSinConductor = new Vehiculo("XYZ789", "Ford Fiesta");
        System.out.println("Vehículo sin conductor: " + vehiculoSinConductor.getModelo());
        System.out.println("Conductor: " + vehiculoSinConductor.getConductor()); // null
        
        // (motor sin vehículo)
        Motor motorSuelto = new Motor("V4", "M000001");
        System.out.println("Motor sin vehículo: " + motorSuelto.getTipo());
        System.out.println("Vehículo: " + motorSuelto.getVehiculo()); // null
       
    }
}
