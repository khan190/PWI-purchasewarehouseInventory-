package com.esw.pwi.dao;

import com.esw.pwi.model.Warehouse;

public interface IWarehouseDao {
	/**
	 * Finds a warehouse by id
	 * 
	 * @param id
	 * @return
	 */
	Warehouse find(Integer id);

	/**
	 * Save a warehouse
	 * 
	 * @param warehouse
	 * @return
	 */
	Warehouse save(Warehouse warehouse);

	/**
	 * update a warehouse
	 * 
	 * @param warehouse
	 * @return
	 */
	Warehouse update(Warehouse warehouse);

	/**
	 * Delete a warehouse
	 * 
	 * @param id
	 * @return
	 */
	boolean delete(Integer id);

	/**
	 * Delete a warehouse object
	 * 
	 * @param warehouse
	 * @return
	 */
	boolean delete(Warehouse warehouse);

}
