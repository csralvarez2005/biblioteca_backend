package biblioteca_backend.servicios.Impl;

import biblioteca_backend.Entidad.Dto.UsuarioDTO;
import biblioteca_backend.Entidad.Usuario;
import biblioteca_backend.repositorios.UsuarioRepository;
import biblioteca_backend.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<UsuarioDTO> findById(Long id) {
        return usuarioRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        Usuario usuario = convertToEntity(usuarioDTO);
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return convertToDTO(savedUsuario);
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Métodos para convertir entre entidades y DTOs
    private UsuarioDTO convertToDTO(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setCodigo(usuario.getCodigo());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setTelefono(usuario.getTelefono());
        usuarioDTO.setDireccion(usuario.getDireccion());
        return usuarioDTO;
    }

    private Usuario convertToEntity(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setCodigo(usuarioDTO.getCodigo());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setTelefono(usuarioDTO.getTelefono());
        usuario.setDireccion(usuarioDTO.getDireccion());
        return usuario;
    }
}
