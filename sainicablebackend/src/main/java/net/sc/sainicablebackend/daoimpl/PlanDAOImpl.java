package net.sc.sainicablebackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sc.sainicablebackend.dao.PlanDAO;
import net.sc.sainicablebackend.dto.Plan;

@Transactional
@Repository("planDAO")
public class PlanDAOImpl implements PlanDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public Plan get(int planId) {
		try {
			return sessionFactory.getCurrentSession().get(Plan.class, Integer.valueOf(planId));
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	
	public List<Plan> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM Plan", Plan.class).getResultList();
	}

	public boolean add(Plan plan) {
		try {
			sessionFactory.getCurrentSession().persist(plan);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean update(Plan plan) {
		try {
			sessionFactory.getCurrentSession().update(plan);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean delete(Plan plan) {
		try {

			plan.setActive(false);
			sessionFactory.getCurrentSession().update(plan);
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	
	public List<Plan> listActivePlans() {
		String selectActivePlans = "FROM Plan WHERE active = :active";
		return sessionFactory.getCurrentSession().createQuery(selectActivePlans, Plan.class)
				.setParameter("active", true).getResultList();
		
	}

}
