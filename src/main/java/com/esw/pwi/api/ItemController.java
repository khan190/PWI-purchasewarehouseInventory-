package com.esw.pwi.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esw.pwi.model.Item;
import com.esw.pwi.services.IItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	IItemService service;
	

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public Item find(@PathVariable("id") int id) {
		Item result = service.find(id);
		if (result == null) {
			throw new IllegalArgumentException("No item found for the given Id;");
		
		} else {
		return result;
		}
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(@RequestBody Item item) {
		 service.save(item);
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@RequestBody Item item) {
		service.update(item);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		service.delete(id);
	}

	@RequestMapping(value = "/view-quantity-against-warehouse", method = RequestMethod.POST)
	public @ResponseBody Map<Integer, Long> listItemQuantity(@RequestBody Item item) {
		Map<Integer, Long> itemQuantity= service.findItemQtyInWharehouse(item);
		return itemQuantity;
	}
	@RequestMapping(value = "/set-quantity-against-warehouse", method = RequestMethod.POST)
	public @ResponseBody Map<Integer, Long> setItemQuantity(@RequestBody Item item) {
		Map<Integer, Long> itemQuantity= service.setItemQtyInWharehouse(item);
		return itemQuantity;
	}
	@RequestMapping(value = "/view-available-sizes", method = RequestMethod.POST)
	public @ResponseBody List<String> viewAvailableSizes(@RequestBody Item item) {
		List<String> availableSizes= service.viewAvailableSizes(item);
		return availableSizes;
	}
}
