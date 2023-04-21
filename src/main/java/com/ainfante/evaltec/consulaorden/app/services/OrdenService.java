package com.ainfante.evaltec.consulaorden.app.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.ainfante.evaltec.consulaorden.app.models.ItemOrden;
import com.ainfante.evaltec.consulaorden.app.models.Orden;

public interface OrdenService {
	Map<String, Object> findPageOrden(int page, int size);
	public List<Orden> findAll();
	public Optional<Orden> findById(String id);
	public List<ItemOrden> getItemsByIdOrden(String id);
}
