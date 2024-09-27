package biblioteca_backend.repositorios;

import biblioteca_backend.Entidad.Ejemplar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EjemplarRepository extends JpaRepository<Ejemplar, Long> {
}
