package com.miadistribuidora.miadistribuidora.controller;

import com.miadistribuidora.miadistribuidora.model.db.ItemDb;
import com.miadistribuidora.miadistribuidora.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/address")
@CrossOrigin("*")
public class AddressController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping("/get-items")
	public ResponseEntity<List<ItemDb>> getItems() {
		List<ItemDb> response = itemService.getItems();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/get-item/{idItem}")
	public ResponseEntity<Optional<ItemDb>> getItem(@PathVariable(value = "idItem", required = true) Integer idItem) {
		Optional<ItemDb> response = itemService.getItem(idItem);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping("/save-item")
	public ResponseEntity<ItemDb> saveItem(@RequestBody ItemDb item) {
		ItemDb response = itemService.saveItem(item);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PatchMapping("/update-item")
	public ResponseEntity<ItemDb> updateItem(@RequestBody ItemDb item) {
		ItemDb response = itemService.updateItem(item);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete-item/{idItem}")
	public ResponseEntity<ItemDb> deleteItem(@PathVariable(value = "idItem", required = true) Integer idItem) {
		itemService.deleteItem(idItem);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
