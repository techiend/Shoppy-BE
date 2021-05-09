package com.varisgreen.shoopy.back.service.implementation;

import com.varisgreen.shoopy.back.entity.Contacto;
import com.varisgreen.shoopy.back.entity.Usuario;
import com.varisgreen.shoopy.back.exception.UsuarioNotFoundException;
import com.varisgreen.shoopy.back.repository.ContactoRepository;
import com.varisgreen.shoopy.back.repository.UsuarioRepository;
import com.varisgreen.shoopy.back.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ContactoRepository contactoRepository;

    @Override
    public Usuario save(Usuario usuario){
        Usuario user = usuarioRepository.save(usuario);
        List<Contacto> contactos = usuario.getContactos();
        if (contactos != null) {
            for (Contacto contacto :
                    contactos) {
                contacto.setUsuario(user);
            }
            contactoRepository.saveAll(contactos);
        }
        return user;
    }

    public List<Usuario> findAll() {
        return StreamSupport.stream(
                usuarioRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Usuario findById (long id){
        return usuarioRepository.findById(id).orElseThrow(()-> new UsuarioNotFoundException(id));
    }
}
