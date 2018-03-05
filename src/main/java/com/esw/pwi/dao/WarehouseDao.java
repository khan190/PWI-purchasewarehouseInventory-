package com.esw.pwi.dao;
import org.springframework.stereotype.Repository;

import com.esw.pwi.model.Warehouse;


@Repository
public class WarehouseDao extends AbstractDao<Integer, Warehouse> implements IWarehouseDao {

	/* (non-Javadoc)
	 * @see com.esw.pwi.dao.IWarehouseDao#find(java.lang.Integer)
	 */
	public Warehouse find(Integer id) {
		return getByKey(id);
	}

	/* (non-Javadoc)
	 * @see com.esw.pwi.dao.IWarehouseDao#save(com.esw.pwi.dao.WarehouseBean)
	 */
	public Warehouse save(Warehouse bean) {
		persist(bean);
		return bean;
	}

	/* (non-Javadoc)
	 * @see com.esw.pwi.dao.IWarehouseDao#update(com.esw.pwi.dao.WarehouseBean)
	 */
	public Warehouse update(Warehouse bean) {
		merge(bean);
		return bean;
	}

	/* (non-Javadoc)
	 * @see com.esw.pwi.dao.IWarehouseDao#delete(java.lang.Integer)
	 */
	public boolean delete(Integer id) {
		return getSession().createQuery("DELETE FROM WarehouseBean WHERE warehouseId=:warehouseId").setParameter("warehouseId", id).executeUpdate() == 1;
	}

	/* (non-Javadoc)
	 * @see com.esw.pwi.dao.IWarehouseDao#delete(com.esw.pwi.dao.WarehouseBean)
	 */
	public boolean delete(Warehouse bean) {
		remove(bean);
		return true;
	}

	}
