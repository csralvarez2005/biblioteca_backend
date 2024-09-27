package biblioteca_backend.Entidad;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String nombre;

    @ManyToMany(mappedBy = "autores")
    private Set<Libro> libros;

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

    public Set<Libro> getLibros() {
        return libros;
    }

    public void setLibros(Set<Libro> libros) {
        this.libros = libros;
    }
}
