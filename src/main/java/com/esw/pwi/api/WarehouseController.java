package com.esw.pwi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.esw.pwi.model.Warehouse;
import com.esw.pwi.services.IWarehouseService;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

	@Autowired
	IWarehouseService service;
	

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public Warehouse find(@PathVariable("id") int id) {
		Warehouse result = service.find(id);
		return result;
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(@RequestBody Warehouse warehouse) {
		 service.save(warehouse);
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void update(@RequestBody Warehouse warehouse) {
		service.update(warehouse);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		service.delete(id);
	}
}
