package com.esw.pwi.dao;

import java.util.List;

import com.esw.pwi.model.Item;
import com.esw.pwi.model.ItemAttribute;

public interface IItemAttributeDao {
	/**
	 * Finds a attribute by id
	 * 
	 * @param id
	 * @return
	 */
	ItemAttribute find(Integer id);

	/**
	 * Save a attribute
	 * 
	 * @param bean
	 * @return
	 */
	ItemAttribute save(ItemAttribute bean);

	/**
	 * update a attribute
	 * 
	 * @param bean
	 * @return
	 */
	ItemAttribute update(ItemAttribute bean);

	/**
	 * Delete a attribute
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(Integer id);

	/**
	 * Delete a attribute object
	 * 
	 * @param bean
	 * @return
	 */
	boolean delete(ItemAttribute bean);
	
	List<ItemAttribute> list(Item item);

}
