package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Entity.Cart;


public interface CartRepository extends JpaRepository<Cart,Integer>{

}
