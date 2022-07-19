package com.codo.acodo.repository;

import com.codo.acodo.entity.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormularioRepository extends JpaRepository<Formulario,Long> {
}
