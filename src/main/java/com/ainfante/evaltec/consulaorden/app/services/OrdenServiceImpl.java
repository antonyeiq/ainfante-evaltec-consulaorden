package com.ainfante.evaltec.consulaorden.app.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ainfante.evaltec.consulaorden.app.models.ItemOrden;
import com.ainfante.evaltec.consulaorden.app.models.Orden;
import com.ainfante.evaltec.consulaorden.app.repositories.OrdenRepository;

@Service
public class OrdenServiceImpl implements OrdenService {

	@Autowired
	OrdenRepository ordenRepository;

	@Override
	public List<Orden> findAll() {
		return ordenRepository.findAll().stream().map(orden -> {
			orden.setCliente(orden.getCliente().toUpperCase());
			return orden;
		}).collect(Collectors.toList());
	}

	@Override
	public Optional<Orden> findById(String id) {
		Optional<Orden> orden = ordenRepository.findById(id);
		if (orden.isPresent()) {
			String cliente = orden.get().getCliente();
			orden.get().setCliente(cliente.toUpperCase());
		}
		return orden;
	}

	@Override
	public List<ItemOrden> getItemsByIdOrden(String id) {
		List<ItemOrden> itemsOrden = new ArrayList<>();
		Optional<Orden> optOrden = ordenRepository.findById(id);
		if (optOrden.isPresent()) {
			itemsOrden = optOrden.get().getItemsOrden();
		}
		return itemsOrden;
	}

	@Override
	public Map<String, Object> findPageOrden(int page, int size) {
		Pageable paging = PageRequest.of(page, size);
		Page<Orden> pageOrdenes = ordenRepository.findAll(paging);
		List<Orden> lstOrdenes = pageOrdenes.getContent().stream().map(orden -> {
			orden.setCliente(orden.getCliente().toUpperCase());
			return orden;
		}).collect(Collectors.toList());
		Map<String, Object> response = new HashMap<>();
		response.put("ordenes", lstOrdenes);
		response.put("currentPage", pageOrdenes.getNumber());
		response.put("totalItems", pageOrdenes.getTotalElements());
		response.put("totalPages", pageOrdenes.getTotalPages());
		return response;
	}
}
