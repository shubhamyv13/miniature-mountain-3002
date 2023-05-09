package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Entity.Orders;
import com.masai.Exception.OrdersException;
import com.masai.Service.OrderService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class OrdersController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/orders")
	public ResponseEntity<Orders> addOrder(@Valid @RequestBody Orders order) throws OrdersException{
		
		Orders savedOrder = orderService.addOrder(order);
		
		return new ResponseEntity<Orders>(savedOrder,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/orders/{orderId}")
	public ResponseEntity<Orders> updateOrder(@PathVariable Integer orderId ,@Valid @RequestBody Orders order) throws OrdersException{
		
		Orders updatedOrder = orderService.updateOrder(order,orderId);
		
		return new ResponseEntity<Orders>(updatedOrder,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/orders/{orderId}")
	public ResponseEntity<Orders> deleteOrder(@PathVariable Integer orderId) throws OrdersException{
		
		Orders deletedOrder = orderService.deleteOrderById(orderId);
		
		return new ResponseEntity<Orders>(deletedOrder,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/orders/{orderId}")
	public ResponseEntity<Orders> viewOrder(@PathVariable Integer orderId) throws OrdersException{
		
		Orders order = orderService.viewOrder(orderId);
		
		return new ResponseEntity<Orders>(order,HttpStatus.OK);
		
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<Orders>> viewAllOrder() throws OrdersException{
		
		List<Orders> orderList = orderService.viewAllOrders();
		
		return new ResponseEntity<List<Orders>>(orderList,HttpStatus.OK);
		
	}
	
	
}
