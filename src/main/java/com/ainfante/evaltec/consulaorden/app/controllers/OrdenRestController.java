package com.ainfante.evaltec.consulaorden.app.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ainfante.evaltec.consulaorden.app.exceptions.OrdenNotFound;
import com.ainfante.evaltec.consulaorden.app.models.ItemOrden;
import com.ainfante.evaltec.consulaorden.app.models.Orden;
import com.ainfante.evaltec.consulaorden.app.services.OrdenService;

@RestController
@RequestMapping("/api/orden")
public class OrdenRestController {

	@Autowired
	OrdenService ordenService;

	@GetMapping
	public ResponseEntity<Map<String, Object>> getOrdenes(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "2") int size) {
		try {
			Map<String, Object> response = ordenService.findPageOrden(page, size);

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/{id}/items")
	public List<ItemOrden> getDetalleOrden(@PathVariable final String id) {
		return ordenService.getItemsByIdOrden(id);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Orden> getOrdenById(@PathVariable final String id) {
		try {
			Optional<Orden> orden = ordenService.findById(id);

			if (orden.isEmpty())
				throw new OrdenNotFound();

			return new ResponseEntity<>(orden.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
