package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Entity.Orders;
import com.masai.Exception.OrdersException;
import com.masai.Repository.OrdersRepository;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrdersRepository ordersRepository;

	@Override
	public Orders addOrder(Orders order) throws OrdersException {
		Orders addNewOrder = ordersRepository.save(order);
		
		if(addNewOrder != null) return addNewOrder;
		
		throw new OrdersException("Input Mis-Match");
	}

	@Override
	public Orders updateOrder(Orders order,Integer orderId) throws OrdersException {
		
        Optional<Orders> optOrders = ordersRepository.findById(orderId);
		
		if(optOrders.isPresent()) {
			
			Orders currentOrder = optOrders.get();
			currentOrder.setBookingOrderId(orderId);
			return ordersRepository.save(currentOrder);
			
		}
		
		throw new OrdersException("Order detail not found with id :" + orderId);
	}

	@Override
	public Orders deleteOrderById(Integer orderId) throws OrdersException {
        Optional<Orders> optOrders = ordersRepository.findById(orderId);
		
		if(optOrders.isPresent()) {
			
			Orders currentOrder = optOrders.get();
			ordersRepository.deleteById(orderId);
			return currentOrder;
			
		}
		
		throw new OrdersException("Order detail not found with id :" + orderId);
	}

	@Override
	public Orders viewOrder(Integer orderId) throws OrdersException {
		
        Optional<Orders> optOrders = ordersRepository.findById(orderId);
		
		if(optOrders.isPresent()) {
			
			Orders currentOrder = optOrders.get();
			
			return currentOrder;
			
		}
		
		throw new OrdersException("Order detail not found with id :" + orderId);
	}

	@Override
	public List<Orders> viewAllOrders() throws OrdersException {
		
        List<Orders> orderList = ordersRepository.findAll();
		
		if(orderList.size() > 0) {
			
			return orderList;
			
		}
		
		throw new OrdersException("Order detail not found");
	}

}
