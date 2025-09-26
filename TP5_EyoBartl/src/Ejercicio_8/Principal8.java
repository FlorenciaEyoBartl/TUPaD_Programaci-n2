//Para correr cada clase principal precione click derecho y luego "Run File"
package Ejercicio_8;


public class Principal8 {
     public static void main(String[] args) {
        System.out.println(" EJERCICIO 8");
        
        //Crear Usuario (agregación)
        Usuario usuario = new Usuario("Ana López", "ana.lopez@email.com");
        
        //Documento (crea su propia firma por COMPOSICIÓN)
        Documento documento = new Documento("Contrato de trabajo", 
                                          "Este es el contenido del contrato...",
                                          "a1b2c3d4e5f6", "2024-01-15", usuario);
        
        //relaciones
        System.out.println("Documento: " + documento.getTitulo());
        System.out.println("Firma: " + documento.getFirma().getCodigoHash() +
                         " (Fecha: " + documento.getFirma().getFecha() + ")");
        System.out.println("Usuario: " + documento.getFirma().getUsuario().getNombre() +
                         " (" + documento.getFirma().getUsuario().getEmail() + ")");
        
        //COMPOSICIÓN (la firma no existe sin documento)
        // La firma se creó dentro del documento y no se puede acceder directamente
        
        //AGREGACIÓN (cambiar usuario de la firma)
        Usuario nuevoUsuario = new Usuario("Carlos Ruiz", "carlos.ruiz@email.com");
        documento.getFirma().setUsuario(nuevoUsuario);
        System.out.println("Nuevo usuario: " + documento.getFirma().getUsuario().getNombre());
        
        //(firma sin usuario)
        Documento documentoSinUsuario = new Documento("Documento anónimo",
                                                    "Contenido anónimo...",
                                                    "z9y8x7w6v5", "2024-01-16", null);
        System.out.println("Documento anónimo: " + documentoSinUsuario.getTitulo());
        System.out.println("Usuario: " + documentoSinUsuario.getFirma().getUsuario()); // null
        
        //el usuario existe independientemente (agregación)
        System.out.println("Usuario original sigue existiendo: " + usuario.getNombre());
        
        
    }
    
}
