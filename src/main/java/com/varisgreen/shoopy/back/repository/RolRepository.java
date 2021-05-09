package com.varisgreen.shoopy.back.repository;

import com.varisgreen.shoopy.back.entity.Rol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends CrudRepository<Rol, Long> {
}
