package com.ingenieriaweb.springboot.web.app.dao;

import com.ingenieriaweb.springboot.web.app.models.CRONOGRAMA_VIAJE;
import com.ingenieriaweb.springboot.web.app.models.EMPLEADO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EMPLEADO_DAO extends JpaRepository<EMPLEADO, Long> {

}
