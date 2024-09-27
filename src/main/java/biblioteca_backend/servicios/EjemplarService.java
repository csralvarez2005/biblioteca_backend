package biblioteca_backend.servicios;

import biblioteca_backend.Entidad.Dto.EjemplarDTO;

import java.util.List;
import java.util.Optional;

public interface EjemplarService {

    List<EjemplarDTO> findAll();
    Optional<EjemplarDTO> findById(Long id);
    EjemplarDTO save(EjemplarDTO ejemplarDTO);
    void deleteById(Long id);
}
