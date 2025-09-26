
package Ejercicio_13;


public class GeneradorQR {
     // Dependencia de creación: crea un CódigoQR dentro del método
    public void generar(String valor, Usuario usuario) {
        CodigoQR codigo = new CodigoQR(valor, usuario); // creación interna
        System.out.println("Se generó el código QR: " + codigo.getValor() +
                " para el usuario " + codigo.getUsuario().getNombre() +
                " (" + codigo.getUsuario().getEmail() + ")");
    }
}
