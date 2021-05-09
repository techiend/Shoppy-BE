package com.varisgreen.shoopy.back.repository;

import com.varisgreen.shoopy.back.entity.Contacto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends CrudRepository<Contacto, Long> {
}
