package com.esw.pwi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esw.pwi.dao.IWarehouseDao;
import com.esw.pwi.model.Warehouse;

@Service
@Transactional
public class WarehouseService implements IWarehouseService {


	@Autowired
	private IWarehouseDao dao;

	/* (non-Javadoc)
	 * @see com.esw.pwi.services.IWarehouseService#find(java.lang.Integer)
	 */
	public Warehouse find(Integer id) {
		return dao.find(id);
	}

	/* (non-Javadoc)
	 * @see com.esw.pwi.services.IWarehouseService#save(com.esw.pwi.model.Warehouse)
	 */
	public Warehouse save(Warehouse warehouse) {
		return dao.save(warehouse);	
	}

	/* (non-Javadoc)
	 * @see com.esw.pwi.services.IWarehouseService#update(com.esw.pwi.model.Warehouse)
	 */
	public Warehouse update(Warehouse warehouse) {
		Warehouse entity = dao.find(warehouse.getWarehouseId());
		if(entity!=null){
			entity.setSiteId(warehouse.getSiteId());
			entity.setWarehouseName(warehouse.getWarehouseName());
		}
		return entity;	
	}

	/* (non-Javadoc)
	 * @see com.esw.pwi.services.IWarehouseService#delete(java.lang.Integer)
	 */
	public boolean delete(Integer id) {
		Warehouse warehouse = dao.find(id);
		if (warehouse == null) {
			throw new IllegalArgumentException("No Warehouse found for the gvien Id.");
		}
		
		return deleteWarehouse(warehouse);
		
	}
	
	private boolean deleteWarehouse(Warehouse warehouse) {
		if (warehouse != null) {
			return dao.delete(warehouse);
		}
		return false;
	}
	
}
