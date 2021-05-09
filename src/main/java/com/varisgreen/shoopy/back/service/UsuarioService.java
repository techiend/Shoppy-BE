package com.varisgreen.shoopy.back.service;

import com.varisgreen.shoopy.back.entity.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario save(Usuario usuario);
    List<Usuario> findAll();
    Usuario findById(long id);
}
