package com.ainfante.evaltec.consulaorden.app.services;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
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

@ExtendWith(MockitoExtension.class)
class OrdenServiceImplTest {

    @Mock
    OrdenRepository ordenRepository;

    @InjectMocks
    OrdenServiceImpl ordenService;

    @Spy
    private Page<Orden> pageOrdenes;

    List<Orden> lstOrden = new ArrayList<>();
    Optional<Orden> optOrden;
    List<ItemOrden> itemsOrden = new ArrayList<>();

    @BeforeEach
    void setup() {
        Orden orden = new Orden();
        orden.setCliente("Antony");
        itemsOrden.add(new ItemOrden());
        orden.setItemsOrden(itemsOrden);
        lstOrden.add(orden);
        optOrden = Optional.of(orden);
    }

    @Test
    void returnClientUpperCaseSuccessful() {
        when(ordenRepository.findAll()).thenReturn(lstOrden);
        ordenService.findAll();
    }

    @Test
    void testFindById() {
        when(ordenRepository.findById(anyString())).thenReturn(optOrden);
        ordenService.findById(anyString());
    }

    @Test
    void testGetItemsByIdOrden() {
        when(ordenRepository.findById(anyString())).thenReturn(optOrden);
        ordenService.getItemsByIdOrden(anyString());
    }

    @Test
    void testFindPageOrden() {
        doReturn(lstOrden).when(pageOrdenes).getContent();
        //when(pageOrdenes.getContent()).thenReturn(lstOrden);
        when(ordenRepository.findAll(any(Pageable.class))).thenReturn(pageOrdenes);
        ordenService.findPageOrden(0, 2);
    }

}
