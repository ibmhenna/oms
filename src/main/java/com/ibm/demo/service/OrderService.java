package com.ibm.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ibm.demo.entity.Order;

@Service
public class OrderService { //Spring Bean:An object having special annotations in spring

	public String createOrder(Order order) {
		return "Order created";
	}
	
	public String getOrder() {
		return "order1";
	}

	public String updateOrder(int orderId) {
		return "order updated";
	}

	public String deleteOrder(int orderId) {
		System.out.println("order deleted");;
		return "order deleted";
	}

	public Order getOrder(int orderId) {
		return new Order();
	}

	public List<Order> getOrders() {
		return new ArrayList<Order>();
	}
	

}
