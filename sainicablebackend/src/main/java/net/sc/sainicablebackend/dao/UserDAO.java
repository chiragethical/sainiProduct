package net.sc.sainicablebackend.dao;

import net.sc.sainicablebackend.dto.Cart;
import net.sc.sainicablebackend.dto.User;

public interface UserDAO {

	// user related operation
	User getByEmail(String email);
	User get(int id);

	boolean add(User user);
	
	boolean update(Cart cart);
	
}