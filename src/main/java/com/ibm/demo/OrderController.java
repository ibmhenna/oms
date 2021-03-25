package com.ibm.demo;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.demo.entity.Order;
import com.ibm.demo.service.OrderService;

@RestController
public class OrderController {
	@Autowired //Spring automatically performs injection
	OrderService orderService;
	@PostMapping("/order")
//	String createOrder(@RequestBody Order order) {
	String createOrder(@RequestBody @Valid Order order, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException();
			
		}
		System.out.println(order); //front-end
		return orderService.createOrder(order);//calls for service layer
	}

	@GetMapping("/order")
	String getOrder(Order order) {
		System.out.println(order);
		return "order created";
	}

	@PutMapping("/order/{id}")
	String updateOrder(@PathVariable("id") int orderId) {
		System.out.println(orderId);
		return "order updated";
	}

	@DeleteMapping("/order/{id}")
	String deleteOrder(@PathVariable("id") int orderId) {
		System.out.println(orderId);
		return "order deleted";
	}
}
