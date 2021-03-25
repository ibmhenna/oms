package com.ibm.demo.service;

import org.springframework.stereotype.Service;

import com.ibm.demo.entity.Order;

@Service
public class OrderService { //Spring Bean:An object having special annotations in spring
	public String createOrder(Order order) {
		return "Order created";
	}

}
