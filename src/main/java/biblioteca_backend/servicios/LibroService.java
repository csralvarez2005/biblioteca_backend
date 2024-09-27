package biblioteca_backend.servicios;

import biblioteca_backend.Entidad.Dto.LibroDTO;

import java.util.List;
import java.util.Optional;

public interface LibroService {

    List<LibroDTO> findAll();
    Optional<LibroDTO> findById(Long id);
    LibroDTO save(LibroDTO libroDTO);
    void deleteById(Long id);
}
