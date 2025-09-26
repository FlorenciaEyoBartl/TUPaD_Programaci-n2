
//Para correr cada clase principal precione click derecho y luego "Run File"

package ejercicio_1;

public class Principal1 {
    
    public static void main(String[] args) {
        
        System.out.println("EJERCICIO 1");
        
        //Crear titular (existe independientemente)
        Titular titular = new Titular("Ana García", "30123456");
        
        //Crear pasaporte (crea su propia foto por COMPOSICIÓN)
        Pasaporte pasaporte = new Pasaporte("B987654", "2024-01-15", 
                                          "ana_foto.jpg", "JPEG");
        
        //Establecer ASOCIACIÓN BIDIRECCIONAL
        pasaporte.setTitular(titular);
        
        // 
        System.out.println("Titular: " + titular.getNombre());
        System.out.println("Tiene pasaporte: " + titular.getPasaporte().getNumero());
        System.out.println("Foto del pasaporte: " + pasaporte.getFoto().getImagen() + " (" + pasaporte.getFoto().getFormato() + ")");
        
        // demuestra la bidireccionalidad
        System.out.println("¿Coinciden las referencias? " + (titular.getPasaporte() == pasaporte)); // debe ser true
    
    }
        
}
