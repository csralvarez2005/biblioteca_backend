package biblioteca_backend.Entidad;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String nombre;
    private String telefono;
    private String direccion;

    @ManyToMany
    @JoinTable(
            name = "saca",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "ejemplar_id")
    )
    private Set<Ejemplar> ejemplares;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<Ejemplar> getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Set<Ejemplar> ejemplares) {
        this.ejemplares = ejemplares;
    }
}
