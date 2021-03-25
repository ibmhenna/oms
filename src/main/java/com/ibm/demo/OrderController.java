package com.ibm.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@PostMapping("/order")
	String createOrder() {//localhost:8080/order
		return "success";// change to POST on postman to see the msg
	}

	@GetMapping("/order")
	String getOrder() {
		return "order created";
	}

	@PutMapping("/order/(id)")
	String updateOrder(@PathVariable("id") int orderId) {
		System.out.println(orderId); //localhost:8080/order/"ordernumber" at postman
		return "order updated";
	}

	@DeleteMapping("/order/(id)")
	String deleteOrder(@PathVariable("id") int orderId) {
		System.out.println(orderId);
		return "order deleted";
	}
}
