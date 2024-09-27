package biblioteca_backend.controladores;


import biblioteca_backend.Entidad.Dto.UsuarioDTO;
import biblioteca_backend.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> getAll() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UsuarioDTO> getById(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    @PostMapping
    public UsuarioDTO create(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.save(usuarioDTO);
    }

    @PutMapping("/{id}")
    public UsuarioDTO update(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        usuarioDTO.setId(id);
        return usuarioService.save(usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }
}
