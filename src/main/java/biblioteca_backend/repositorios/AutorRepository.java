package biblioteca_backend.repositorios;

import biblioteca_backend.Entidad.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
