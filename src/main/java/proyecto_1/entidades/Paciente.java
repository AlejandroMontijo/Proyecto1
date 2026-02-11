package proyecto_1.entidades;

public class Paciente {

    private int id;
    private String nombre;
    private int edad;
    private String direccion;

    public Paciente(int id, String nombre, int edad, String direccion) throws Exception {
        if (id <= 0) {
            throw new Exception("El ID del paciente debe ser positivo.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("El nombre del paciente no puede estar vacío.");
        }
        if (edad <= 0) {
            throw new Exception("La edad del paciente debe ser positiva.");
        }
        if (direccion == null || direccion.trim().isEmpty()) {
            throw new Exception("La dirección del paciente no puede estar vacía.");
        }
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
