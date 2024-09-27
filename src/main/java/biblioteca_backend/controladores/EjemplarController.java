package biblioteca_backend.controladores;


import biblioteca_backend.Entidad.Dto.EjemplarDTO;
import biblioteca_backend.servicios.EjemplarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ejemplares")
public class EjemplarController {

    @Autowired
    private EjemplarService ejemplarService;

    @GetMapping
    public List<EjemplarDTO> getAll() {
        return ejemplarService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<EjemplarDTO> getById(@PathVariable Long id) {
        return ejemplarService.findById(id);
    }

    @PostMapping
    public EjemplarDTO create(@RequestBody EjemplarDTO ejemplarDTO) {
        return ejemplarService.save(ejemplarDTO);
    }

    @PutMapping("/{id}")
    public EjemplarDTO update(@PathVariable Long id, @RequestBody EjemplarDTO ejemplarDTO) {
        ejemplarDTO.setId(id);
        return ejemplarService.save(ejemplarDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ejemplarService.deleteById(id);
    }
}
