
package Model;


public abstract class Base {
    private long id;
    private boolean eliminado; // Implementa soft delete


    protected Base(long id, boolean eliminado) {
        this.id = id;
        this.eliminado = eliminado;
    }
    
    protected Base(){
        this.eliminado = false;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
    
}
