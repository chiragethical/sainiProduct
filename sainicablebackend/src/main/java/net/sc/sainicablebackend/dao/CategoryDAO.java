package net.sc.sainicablebackend.dao;

import java.util.List;

import net.sc.sainicablebackend.dto.Category;

public interface CategoryDAO {

	Category get(int id);

	boolean add(Category category);

	boolean delete(Category category);

	boolean update(Category category);

	List<Category> list();
}
