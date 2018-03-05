package com.esw.pwi.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.esw.pwi.model.Item;
import com.esw.pwi.model.ItemAttribute;


@Repository
public class ItemAttributeDao extends AbstractDao<Integer, ItemAttribute> implements IItemAttributeDao {

	/* (non-Javadoc)
	 * @see com.esw.pwi.dao.IItemAttributeDao#find(java.lang.Integer)
	 */
	public ItemAttribute find(Integer id) {
		return getByKey(id);
	}

	/* (non-Javadoc)
	 * @see com.esw.pwi.dao.IItemAttributeDao#save(com.esw.pwi.dao.WarehouseBean)
	 */
	public ItemAttribute save(ItemAttribute bean) {
		persist(bean);
		return bean;
	}

	/* (non-Javadoc)
	 * @see com.esw.pwi.dao.IItemAttributeDao#update(com.esw.pwi.dao.WarehouseBean)
	 */
	public ItemAttribute update(ItemAttribute bean) {
		merge(bean);
		return bean;
	}

	/* (non-Javadoc)
	 * @see com.esw.pwi.dao.IItemAttributeDao#delete(java.lang.Integer)
	 */
	public boolean delete(Integer id) {
		return getSession().createQuery("DELETE FROM ItemAttributeBean WHERE itemId=:itemId").setParameter("itemId", id).executeUpdate() == 1;
	}

	/* (non-Javadoc)
	 * @see com.esw.pwi.dao.IItemAttributeDao#delete(com.esw.pwi.dao.ItemAttributeBean)
	 */
	public boolean delete(ItemAttribute bean) {
		remove(bean);
		return true;
	}
	
	public List<ItemAttribute> list(Item item) {
		Criteria c = getSession().createCriteria(ItemAttribute.class);

		if (item != null) {
			if (item.getItemId() != null) {
				c.add(Restrictions.eq("itemId", item.getItemId()));
			}
		}
		@SuppressWarnings("unchecked")
		List<ItemAttribute> attributeValues = c.list();
		return attributeValues;
	}


	}
