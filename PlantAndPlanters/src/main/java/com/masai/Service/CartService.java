package com.masai.Service;

import java.util.List;

import com.masai.Entity.Cart;
import com.masai.Entity.Planter;
import com.masai.Exception.CartException;
import com.masai.Exception.CustomerException;
import com.masai.Exception.PlanterException;

public interface CartService {

	public Cart addToCart( Integer CustomerId,Integer productId,Cart cart )
			throws CustomerException,CartException;
	
	public List<Planter> getAllItem ()throws CartException;
	
	public String deleteFromCart(Integer cartId,Integer planterId)
			throws PlanterException,CartException;
	
	public String emptyCart();
}
