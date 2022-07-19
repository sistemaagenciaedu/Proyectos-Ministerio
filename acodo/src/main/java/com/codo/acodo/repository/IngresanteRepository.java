package com.codo.acodo.repository;

import com.codo.acodo.entity.Ingresante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngresanteRepository extends JpaRepository<Ingresante,Long> {
}
