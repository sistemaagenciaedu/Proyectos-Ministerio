package com.codo.acodo.repository;

import com.codo.acodo.entity.PreguntaFormulario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreguntaRepository extends JpaRepository<PreguntaFormulario,Long> {
}
