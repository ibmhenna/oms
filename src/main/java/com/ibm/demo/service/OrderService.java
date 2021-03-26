package com.ibm.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.demo.entity.Order;
import com.ibm.demo.repo.OrderRepository;

@Service
public class OrderService { // Spring Bean:An object having special annotations in spring
	@Autowired
	OrderRepository orderRepository;// defining the dependancy as tis class is dependent on repository

	public String createOrder(Order order) {
		Order savedOrder = orderRepository.save(order);
		return savedOrder.getId();
	}

	public List<Order> getOrders() {
		return new ArrayList<Order>();
	}

	public String getOrder() {
		return "order1";
	}

	public String updateOrder(int orderId) {
		return "order updated";
	}

	public String deleteOrder(int orderId) {
		System.out.println("order deleted");
		;
		return "order deleted";
	}

	public Order getOrder(int orderId) {
		return new Order();
	}

}
