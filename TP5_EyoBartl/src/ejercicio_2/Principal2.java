
//Para correr cada clase principal precione click derecho y luego "Run File"
package ejercicio_2;


public class Principal2 {
    
      public static void main(String[] args) {
          
        System.out.println("EJERCICIO 2");
        
        //Crear una batería (EXISTE INDEPENDIENTEMENTE) - AGREGACIÓN
        Bateria bateria = new Bateria("Liti_on", "4000 mAh");
        
        //Crear un usuario
        Usuario usuario = new Usuario("Carlos López", "40123456");
        
        //Crear celular SIN batería inicialmente
        Celular celular = new Celular("123456789012345", "Samsung", "Galaxy S21");
        
        //ESTABLECER AGREGACIÓN (de la batería)
        celular.setBateria(bateria);
        
        //ESTABLECER ASOCIACIÓN BIDIRECCIONAL
        celular.setUsuario(usuario);
        
        //relaciones
        System.out.println("Usuario: " + usuario.getNombre());
        System.out.println("Celular: " + celular.getMarca() + " " + celular.getModelo());
        System.out.println("Batería: " + celular.getBateria().getModelo() + 
                          " (" + celular.getBateria().getCapacidad() + ")");
        
        //AGREGACIÓN (la batería puede cambiarse)
        Bateria bateriaNueva = new Bateria("Lit_po", "5000 mAh");
        celular.setBateria(bateriaNueva);
        System.out.println("Batería nueva: " + celular.getBateria().getModelo());
        
       
    }
          
}
