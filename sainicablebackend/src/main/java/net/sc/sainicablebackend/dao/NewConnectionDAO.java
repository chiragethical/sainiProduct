package net.sc.sainicablebackend.dao;

import java.util.List;

import net.sc.sainicablebackend.dto.NewConnection;


public interface NewConnectionDAO {

	NewConnection get(String newConnectionEmail);
	List<NewConnection> list();	
	boolean add(NewConnection newConnection);
	boolean update(NewConnection newConnection);
	boolean delete(NewConnection newConnection);

	List<NewConnection> listActiveNewConnections();	


}
