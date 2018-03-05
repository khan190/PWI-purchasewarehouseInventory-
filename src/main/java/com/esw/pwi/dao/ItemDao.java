package com.esw.pwi.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.esw.pwi.model.Item;


@Repository
public class ItemDao extends AbstractDao<Integer, Item> implements IItemDao {

	/* (non-Javadoc)
	 * @see com.esw.pwi.dao.IItemDao#find(java.lang.Integer)
	 */
	public Item find(Integer id) {
		return getByKey(id);
	}

	/* (non-Javadoc)
	 * @see com.esw.pwi.dao.IItemDao#save(com.esw.pwi.dao.WarehouseBean)
	 */
	public Item save(Item bean) {
		persist(bean);
		return bean;
	}

	/* (non-Javadoc)
	 * @see com.esw.pwi.dao.IItemDao#update(com.esw.pwi.dao.WarehouseBean)
	 */
	public Item update(Item bean) {
		merge(bean);
		return bean;
	}

	/* (non-Javadoc)
	 * @see com.esw.pwi.dao.IItemDao#delete(java.lang.Integer)
	 */
	public boolean delete(Integer id) {
		return getSession().createQuery("DELETE FROM ItemBean WHERE itemId=:itemId").setParameter("itemId", id).executeUpdate() == 1;
	}

	/* (non-Javadoc)
	 * @see com.esw.pwi.dao.IItemDao#delete(com.esw.pwi.dao.ItemBean)
	 */
	public boolean delete(Item bean) {
		remove(bean);
		return true;
	}
	
	public List<Item> list(Item item) {
		Criteria c = getSession().createCriteria(Item.class);

		if (item != null) {
			if (item.getWarehouseId() != null) {
				c.add(Restrictions.eq("warehouseId", item.getWarehouseId()));
			}
		}
		@SuppressWarnings("unchecked")
		List<Item> items = c.list();
		return items;
	}


	}
