package biblioteca_backend.Entidad;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Ejemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String localizacion;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;

    @ManyToMany(mappedBy = "ejemplares")
    private Set<Usuario> usuarios;

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

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
