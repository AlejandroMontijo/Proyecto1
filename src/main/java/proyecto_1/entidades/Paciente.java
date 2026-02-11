package proyecto_1.entidades;

public class Paciente {

    private int id;
    private String nombre;
    private int edad;
    private String direccion;

    public Paciente(int id, String nombre, int edad, String direccion) {



        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Edad: " + edad + " | Dirección: " + direccion;
    }
}
