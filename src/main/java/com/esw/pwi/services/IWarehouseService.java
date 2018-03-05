package com.esw.pwi.services;

import com.esw.pwi.model.Warehouse;

public interface IWarehouseService {
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

}
