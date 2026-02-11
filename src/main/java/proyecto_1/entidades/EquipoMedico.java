package proyecto_1.entidades;

public class EquipoMedico {

    private int id;
    private String nombre;
    private int cantidad;

    public EquipoMedico(int id, String nombre, int cantidad) {


        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Cantidad: " + cantidad;
    }
}
