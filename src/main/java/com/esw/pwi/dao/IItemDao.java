package com.esw.pwi.dao;

import java.util.List;

import com.esw.pwi.model.Item;

public interface IItemDao {
	/**
	 * Finds a item by id
	 * 
	 * @param id
	 * @return
	 */
	Item find(Integer id);

	/**
	 * Save a item
	 * 
	 * @param item
	 * @return
	 */
	Item save(Item item);

	/**
	 * update a item
	 * 
	 * @param item
	 * @return
	 */
	Item update(Item item);

	/**
	 * Delete a item
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(Integer id);

	/**
	 * Delete a item object
	 * 
	 * @param item
	 * @return
	 */
	boolean delete(Item item);
	
	List<Item> list(Item item);

}
