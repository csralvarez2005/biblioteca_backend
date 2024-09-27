package biblioteca_backend.servicios.Impl;

import biblioteca_backend.Entidad.Dto.LibroDTO;
import biblioteca_backend.Entidad.Libro;
import biblioteca_backend.repositorios.LibroRepository;
import biblioteca_backend.servicios.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroServiceImpl implements LibroService {
    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<LibroDTO> findAll() {
        return libroRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<LibroDTO> findById(Long id) {
        return libroRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public LibroDTO save(LibroDTO libroDTO) {
        Libro libro = convertToEntity(libroDTO);
        Libro savedLibro = libroRepository.save(libro);
        return convertToDTO(savedLibro);
    }

    @Override
    public void deleteById(Long id) {
        libroRepository.deleteById(id);
    }

    // Métodos para convertir entre entidades y DTOs
    private LibroDTO convertToDTO(Libro libro) {
        LibroDTO libroDTO = new LibroDTO();
        libroDTO.setId(libro.getId());
        libroDTO.setCodigo(libro.getCodigo());
        libroDTO.setTitulo(libro.getTitulo());
        libroDTO.setIsbn(libro.getIsbn());
        libroDTO.setEditorial(libro.getEditorial());
        libroDTO.setPaginas(libro.getPaginas());
        return libroDTO;
    }

    private Libro convertToEntity(LibroDTO libroDTO) {
        Libro libro = new Libro();
        libro.setId(libroDTO.getId());
        libro.setCodigo(libroDTO.getCodigo());
        libro.setTitulo(libroDTO.getTitulo());
        libro.setIsbn(libroDTO.getIsbn());
        libro.setEditorial(libroDTO.getEditorial());
        libro.setPaginas(libroDTO.getPaginas());
        return libro;
    }
}
