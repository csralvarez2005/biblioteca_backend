package biblioteca_backend.controladores;


import biblioteca_backend.Entidad.Dto.LibroDTO;
import biblioteca_backend.servicios.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<LibroDTO> getAll() {
        return libroService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<LibroDTO> getById(@PathVariable Long id) {
        return libroService.findById(id);
    }

    @PostMapping
    public LibroDTO create(@RequestBody LibroDTO libroDTO) {
        return libroService.save(libroDTO);
    }

    @PutMapping("/{id}")
    public LibroDTO update(@PathVariable Long id, @RequestBody LibroDTO libroDTO) {
        libroDTO.setId(id);
        return libroService.save(libroDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        libroService.deleteById(id);
    }
}
