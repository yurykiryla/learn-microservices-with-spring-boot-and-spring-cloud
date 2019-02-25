package com.itemsharing.itemservice.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itemsharing.itemservice.model.Item;
import com.itemsharing.itemservice.model.User;
import com.itemsharing.itemservice.service.ItemService;
import com.itemsharing.itemservice.service.UserService;
import com.itemsharing.itemservice.util.UserContextHolder;

@RestController
@RequestMapping("/v1/item")
public class ItemController {
	@Autowired
	private ItemService itemService;

	@Autowired
	private UserService userService;
	
	private static final Logger LOG = LoggerFactory.getLogger(ItemController.class);

	@RequestMapping(method = RequestMethod.POST)
	public Item addItem(@RequestBody Item item) {
		String username = "jadams";

		return itemService.addItemByUser(item, username);
	}

	@RequestMapping("/itemsByUser")
	public List<Item> getAllItemsByUser() {
		String username = "jadams";

		return itemService.getItemsByUsername(username);
	}
	
	@RequestMapping("/all")
	public List<Item> getAllItems() {
		return itemService.getAllItems();
	}
	
	@RequestMapping("/{id}")
	public Item getItemById(@PathVariable long id) {
		return itemService.getItemById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Item updateItem(@PathVariable long id, @RequestBody Item item) throws IOException {
		item.setId(id);
		return itemService.updateItem(item);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteItemById(@PathVariable long id) {
		itemService.deleteItemById(id);
	}
	
	@RequestMapping("/user/{username}")
	public User getUserByUsername(@PathVariable String username) {
		LOG.debug("ItemServiceController Correlation Id: {}", UserContextHolder.getContext().getCorrelationId());
		
		return itemService.getUserByUsername(username);
	}
}
