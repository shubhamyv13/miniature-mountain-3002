package com.masai.Service;

import java.util.List;

import com.masai.Entity.Cart;
import com.masai.Entity.Planter;
import com.masai.Exception.CartException;
import com.masai.Exception.CustomerException;
import com.masai.Exception.PlanterException;

public class CartServiceImpl implements CartService {

	@Override
	public Cart addToCart(Integer CustomerId, Integer productId, Cart cart) throws CustomerException, CartException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Planter> getAllItem() throws CartException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteFromCart(Integer cartId, Integer planterId) throws PlanterException, CartException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String emptyCart() {
		// TODO Auto-generated method stub
		return null;
	}

}
