package com.ainfante.evaltec.consulaorden.app.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ordenes")
public class Orden {
	@Id
	private String id;
	private String cliente;
	private String formaPago;
	private Date fechaPedido;
	private BigDecimal monto;
	private String estado;
	private List<ItemOrden> itemsOrden;
}
