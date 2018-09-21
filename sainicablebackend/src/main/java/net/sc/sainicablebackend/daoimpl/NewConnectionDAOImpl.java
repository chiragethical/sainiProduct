package net.sc.sainicablebackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sc.sainicablebackend.dao.NewConnectionDAO;
import net.sc.sainicablebackend.dto.NewConnection;

@Transactional
@Repository("newConnectionDAO")
public class NewConnectionDAOImpl implements NewConnectionDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public NewConnection get(int newConnectionId) {
		try {
			return sessionFactory.getCurrentSession().get(NewConnection.class, Integer.valueOf(newConnectionId));
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public NewConnection get(String newConnectionEmail) {
		String selectActiveNewConnections = "FROM NewConnection WHERE email = :email";
		return sessionFactory.getCurrentSession().createQuery(selectActiveNewConnections, NewConnection.class)
				.setParameter("email", true).getSingleResult();
	}

	public List<NewConnection> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM NewConnection", NewConnection.class).getResultList();
	}

	public boolean add(NewConnection newConnection) {
		try {
			sessionFactory.getCurrentSession().persist(newConnection);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
		
	}

	public boolean update(NewConnection newConnection) {
		try {
			sessionFactory.getCurrentSession().update(newConnection);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
		
	}

	public boolean delete(NewConnection newConnection) {
		try {

			newConnection.setActive(false);
			sessionFactory.getCurrentSession().update(newConnection);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public List<NewConnection> listActiveNewConnections() {
		String selectActiveNewConnections = "FROM NewConnection WHERE active = :active";
		return sessionFactory.getCurrentSession().createQuery(selectActiveNewConnections, NewConnection.class)
				.setParameter("active", true).getResultList();
	}

}
