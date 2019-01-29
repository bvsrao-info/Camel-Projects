package camelinaction;

import java.util.List;

import camelinaction.jpa.entity.OrderJpa;

public class Orders {
	
	List<OrderJpa> listOrders;

	public List<OrderJpa> getListOrders() {
		return listOrders;
	}

	public void setListOrders(List<OrderJpa> listOrders) {
		this.listOrders = listOrders;
	}	

}
