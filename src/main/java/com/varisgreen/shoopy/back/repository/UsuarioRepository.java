package com.varisgreen.shoopy.back.repository;

import com.varisgreen.shoopy.back.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
