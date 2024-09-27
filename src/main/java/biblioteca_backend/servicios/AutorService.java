package biblioteca_backend.servicios;

import biblioteca_backend.Entidad.Dto.AutorDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface AutorService {

    List<AutorDTO> findAll();
    Optional<AutorDTO> findById(Long id);
    AutorDTO save(AutorDTO autorDTO);
    void deleteById(Long id);
}
