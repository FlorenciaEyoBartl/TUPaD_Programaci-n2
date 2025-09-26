
package Ejercicio_14;


public class EditorVideo {
    // Dependencia de creación: crea un Render dentro del método
    public void exportar(String formato, Proyecto proyecto) {
        Render render = new Render(formato, proyecto); // creación interna
        System.out.println("Proyecto \"" + render.getProyecto().getNombre() +
                "\" de " + render.getProyecto().getDuracionMin() + " minutos " +
                "se exportó en formato: " + render.getFormato());
    }
}
