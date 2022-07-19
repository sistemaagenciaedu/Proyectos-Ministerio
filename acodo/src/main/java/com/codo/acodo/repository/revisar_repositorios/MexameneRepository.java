package com.codo.acodo.repository.revisar_repositorios;

import com.codo.acodo.entity.revisar_entidades.Mexamen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MexameneRepository extends JpaRepository<Mexamen,Long>{
}
