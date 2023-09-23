package com.ingenieriaweb.springboot.web.app.services.Interface;

import com.ingenieriaweb.springboot.web.app.models.*;

public interface BUS_SUCURSAL_SERVICE {
	
	public void save(BUS_SUCURSAL bus_sucursal);
	public BUS_SUCURSAL findByIdSucursalAndIdBus(Long idSucursal, Long idBus);

}
