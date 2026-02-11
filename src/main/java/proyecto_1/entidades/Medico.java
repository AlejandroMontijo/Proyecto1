package proyecto_1.entidades;

public class Medico {

    private int id;
    private String nombre;
    private Especialidad especialidad;

    public Medico(int id, String nombre, Especialidad especialidad) {


        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
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

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        String esp = especialidad != null ? especialidad.getNombre() : "Sin especialidad";
        return "ID: " + id + " | Nombre: " + nombre + " | Especialidad: " + esp;
    }
}
