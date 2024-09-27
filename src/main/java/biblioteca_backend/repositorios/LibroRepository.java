package biblioteca_backend.repositorios;

import biblioteca_backend.Entidad.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
