package com.ibm.demo;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.demo.entity.Order;
import com.ibm.demo.service.OrderService;


@RestController
public class OrderController {
	@Autowired // Spring automatically performs injection
	OrderService orderService;

	@PostMapping("/order")
	@ResponseStatus(code = HttpStatus.CREATED) // to return status code 201
//	String createOrder(@RequestBody Order order) {
	String createOrder(@RequestBody @Valid Order order, BindingResult bindingResult) {
		validateModel(bindingResult);
		System.out.println(order); // front-end
		return orderService.createOrder(order);// calls for service layer
	}

	@GetMapping("/order")
	List<Order> getOrders() {
		return orderService.getOrders();
	}
	
	/**
	 * method to search orderId
	 * @param orderId
	 * @return zero or matching id
	 */

	@GetMapping("/order/{id}")
	Optional<Order> getOrder(@PathVariable("id") String orderId) {
		return orderService.getOrder(orderId); //to obtain all the orders as an array
												//for single order, provide object id in the url
	}

	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong. Please try later");
		}
	}

	@PutMapping("/order/{id}")
	void updateOrder(@RequestBody @Valid Order order, BindingResult bindingResult, @PathVariable("id") String orderId) {
		validateModel(bindingResult);
		System.out.println(orderId);
		order.setId(orderId);
		orderService.updateOrder(order);
	}

	@DeleteMapping("/order/{id}")
	String deleteOrder(@PathVariable("id") int orderId, HttpRequest httpRequest) {
		System.out.println(httpRequest.getHeaders());
		System.out.println(orderId);
		return orderService.deleteOrder(orderId);
	}
}
