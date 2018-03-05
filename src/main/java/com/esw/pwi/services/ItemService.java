package com.esw.pwi.services;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esw.pwi.dao.IItemAttributeDao;
import com.esw.pwi.dao.IItemDao;
import com.esw.pwi.model.Item;
import com.esw.pwi.model.ItemAttribute;

@Service
@Transactional
public class ItemService implements IItemService {

	@Autowired
	private IItemDao dao;
	
	@Autowired
	private IItemAttributeDao attributeDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.esw.pwi.services.IItemService#find(java.lang.Integer)
	 */
	public Item find(Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("Item Id is required.");
		}
		return dao.find(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.esw.pwi.services.IItemService#save(com.esw.pwi.model.Item)
	 */
	public Item save(Item item) {
		item.setCreateDate(new Date());
		return dao.save(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.esw.pwi.services.IItemService#update(com.esw.pwi.model.Item)
	 */
	public Item update(Item item) {
		Item entity = dao.find(item.getItemId());
		if (entity == null) {
			throw new IllegalArgumentException("No Item found for the gvien Id.");
		} else {
			entity.setWarehouseId(item.getWarehouseId());
			entity.setBrandId(item.getBrandId());
			entity.setItemName(item.getItemName());
			entity.setItemType(item.getItemType());
			entity.setInStockQty(item.getInStockQty());
			entity.setAvailableQty(item.getAvailableQty());
			entity.setInTransitQty(item.getInTransitQty());
			entity.setMoq(item.getMoq());
			entity.setQpb(item.getQpb());
			entity.setReorderPoint(item.getReorderPoint());
			entity.setUpdateDate(new Date());
		}
		return entity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.esw.pwi.services.IItemService#delete(java.lang.Integer)
	 */
	public boolean delete(Integer id) {
		if (id == null) {
			throw new IllegalArgumentException("Item Id is required.");
		}
		Item item = dao.find(id);
		if (item == null) {
			throw new IllegalArgumentException("No Item found for the gvien Id.");
		}

		return deleteItem(item);

	}

	private boolean deleteItem(Item item) {
		if (item != null) {
			return dao.delete(item);
		}
		return false;
	}

	public Map<Integer, Long> findItemQtyInWharehouse(Item item) {
		List<Item> items = dao.list(item);
		Map<Integer, Long> warehouseVsQty = new HashMap<Integer, Long>();
		for (Item entity : items) {
			warehouseVsQty.put(entity.getWarehouseId(), entity.getAvailableQty());
		}
		return warehouseVsQty;
	}

	public Map<Integer, Long> setItemQtyInWharehouse(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("Item cannot be null!");
		}
		Map<Integer, Long> warehouseVsQty = new HashMap<Integer, Long>();
			List<Item> items = dao.list(item);
			for (Item entity : items) {
				entity.setAvailableQty(item.getAvailableQty());
				dao.update(entity);
				warehouseVsQty.put(entity.getWarehouseId(), entity.getAvailableQty());
			}
		return warehouseVsQty;
	}
	public List<String> viewAvailableSizes(Item item) {
		if (item == null) {
			throw new IllegalArgumentException("Item cannot be null!");
		}
		List<String> availableSizes = new LinkedList<String>();
			List<ItemAttribute> attributes = attributeDao.list(item);
			for (ItemAttribute entity : attributes) {
				availableSizes.add(entity.getAttributeValue());
			}
		return availableSizes;
	}

}
