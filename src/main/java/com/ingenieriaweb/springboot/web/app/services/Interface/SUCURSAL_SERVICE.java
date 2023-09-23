package com.ingenieriaweb.springboot.web.app.services.Interface;
import java.util.List;

import com.ingenieriaweb.springboot.web.app.models.*;
public interface SUCURSAL_SERVICE {
	public List<SUCURSAL> findAll();
	public SUCURSAL findByIdSucursal(Long idSucursal);

}
