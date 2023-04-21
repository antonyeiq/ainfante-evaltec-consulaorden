package com.ainfante.evaltec.consulaorden.app.services;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.ainfante.evaltec.consulaorden.app.models.ItemOrden;
import com.ainfante.evaltec.consulaorden.app.models.Orden;
import com.ainfante.evaltec.consulaorden.app.repositories.OrdenRepository;

@SpringBootTest
class OrdenServiceImplTest {

	@MockBean
	OrdenRepository ordenRepository;

	@Autowired
	OrdenService ordenService;

	List<Orden> lstOrden;
	Optional<Orden> optOrden;
	List<ItemOrden> itemsOrden;
	@MockBean
	private Pageable pageableMock;
	@MockBean
	private Page<Orden> ordenPage;

	@BeforeEach
	void setup() {
		lstOrden = new ArrayList<>();
		optOrden = Optional.of(new Orden());
		List<ItemOrden> itemsOrden = new ArrayList<>();
	}

	@Test
	void testFindAll() {		
		when(ordenService.findAll()).thenReturn(lstOrden);
	}

	@Test
	void testFindById() {		
		when(ordenService.findById(anyString())).thenReturn(optOrden);		
	}

	@Test
	void testGetItemsByIdOrden() {		
		when(ordenRepository.findById(anyString())).thenReturn(optOrden);
	}

	@Test
	void testFindPageOrden() {		
        when(ordenRepository.findAll(pageableMock)).thenReturn(ordenPage);
	}

}
