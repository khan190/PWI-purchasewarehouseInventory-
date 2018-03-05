package com.esw.pwi.services;

import java.util.List;
import java.util.Map;

import com.esw.pwi.model.Item;

public interface IItemService {
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
	Item save(Item warehouse);

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
	
	Map<Integer, Long> findItemQtyInWharehouse(Item item);
	
	Map<Integer, Long> setItemQtyInWharehouse(Item item);
	
	List<String> viewAvailableSizes(Item item);

}
