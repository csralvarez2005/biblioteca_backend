package biblioteca_backend.repositorios;

import biblioteca_backend.Entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
