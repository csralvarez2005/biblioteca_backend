package biblioteca_backend.servicios.Impl;

import biblioteca_backend.Entidad.Dto.EjemplarDTO;
import biblioteca_backend.Entidad.Ejemplar;
import biblioteca_backend.repositorios.EjemplarRepository;
import biblioteca_backend.servicios.EjemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EjemplarServiceImpl implements EjemplarService {
    @Autowired
    private EjemplarRepository ejemplarRepository;

    @Override
    public List<EjemplarDTO> findAll() {
        return ejemplarRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<EjemplarDTO> findById(Long id) {
        return ejemplarRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public EjemplarDTO save(EjemplarDTO ejemplarDTO) {
        Ejemplar ejemplar = convertToEntity(ejemplarDTO);
        Ejemplar savedEjemplar = ejemplarRepository.save(ejemplar);
        return convertToDTO(savedEjemplar);
    }

    @Override
    public void deleteById(Long id) {
        ejemplarRepository.deleteById(id);
    }

    // Métodos para convertir entre entidades y DTOs
    private EjemplarDTO convertToDTO(Ejemplar ejemplar) {
        EjemplarDTO ejemplarDTO = new EjemplarDTO();
        ejemplarDTO.setId(ejemplar.getId());
        ejemplarDTO.setCodigo(ejemplar.getCodigo());
        ejemplarDTO.setLocalizacion(ejemplar.getLocalizacion());
        return ejemplarDTO;
    }

    private Ejemplar convertToEntity(EjemplarDTO ejemplarDTO) {
        Ejemplar ejemplar = new Ejemplar();
        ejemplar.setId(ejemplarDTO.getId());
        ejemplar.setCodigo(ejemplarDTO.getCodigo());
        ejemplar.setLocalizacion(ejemplarDTO.getLocalizacion());
        return ejemplar;
    }
}
