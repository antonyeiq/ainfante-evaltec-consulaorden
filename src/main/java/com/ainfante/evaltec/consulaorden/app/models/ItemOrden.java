package com.ainfante.evaltec.consulaorden.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemOrden {
	private String producto;
	private int cantidad;
	private double precio;
	
	public double getTotal() {
		return this.precio * this.cantidad;
	}

}
