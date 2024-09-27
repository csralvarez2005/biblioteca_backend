package biblioteca_backend.servicios.Impl;

import biblioteca_backend.Entidad.Autor;
import biblioteca_backend.Entidad.Dto.AutorDTO;
import biblioteca_backend.repositorios.AutorRepository;
import biblioteca_backend.servicios.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public List<AutorDTO> findAll() {
        return autorRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<AutorDTO> findById(Long id) {
        return autorRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public AutorDTO save(AutorDTO autorDTO) {
        Autor autor = convertToEntity(autorDTO);
        Autor savedAutor = autorRepository.save(autor);
        return convertToDTO(savedAutor);
    }

    @Override
    public void deleteById(Long id) {
        autorRepository.deleteById(id);
    }

    // Métodos para convertir entre entidades y DTOs
    private AutorDTO convertToDTO(Autor autor) {
        AutorDTO autorDTO = new AutorDTO();
        autorDTO.setId(autor.getId());
        autorDTO.setCodigo(autor.getCodigo());
        autorDTO.setNombre(autor.getNombre());
        return autorDTO;
    }

    private Autor convertToEntity(AutorDTO autorDTO) {
        Autor autor = new Autor();
        autor.setId(autorDTO.getId());
        autor.setCodigo(autorDTO.getCodigo());
        autor.setNombre(autorDTO.getNombre());
        return autor;
    }
}
