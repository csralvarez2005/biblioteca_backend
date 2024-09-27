package biblioteca_backend.controladores;

import biblioteca_backend.Entidad.Dto.AutorDTO;
import biblioteca_backend.servicios.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<AutorDTO> getAll() {
        return autorService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<AutorDTO> getById(@PathVariable Long id) {
        return autorService.findById(id);
    }

    @PostMapping
    public AutorDTO create(@RequestBody AutorDTO autorDTO) {
        return autorService.save(autorDTO);
    }

    @PutMapping("/{id}")
    public AutorDTO update(@PathVariable Long id, @RequestBody AutorDTO autorDTO) {
        autorDTO.setId(id);
        return autorService.save(autorDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        autorService.deleteById(id);
    }
}
