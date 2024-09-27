package biblioteca_backend.servicios;

import biblioteca_backend.Entidad.Dto.UsuarioDTO;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<UsuarioDTO> findAll();
    Optional<UsuarioDTO> findById(Long id);
    UsuarioDTO save(UsuarioDTO usuarioDTO);
    void deleteById(Long id);
}
