package com.invillia.acme.resources;

import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.models.Store;
import com.invillia.acme.repository.StoreRepository;

@RestController
@RequestMapping("/store")
public class StoreResource {

	@Autowired
	private StoreRepository sr;

	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Store> ListStores() {
		Iterable<Store> ListStores = sr.findAll();
		return ListStores;
	}
	
	@PostMapping()
	public Store InsereStore(@RequestBody @Valid Store store) {
		return sr.save(store);
	}

	@DeleteMapping("/{code}")
	public void DeletaStore(@PathVariable long code) {
		sr.deleteById(code);
	}
	
	@PutMapping("/{code}")
	public ResponseEntity<Object> AtualizaStore(@RequestBody Store store, @PathVariable long code) {
		Optional<Store> storeOptional = sr.findById(code);
		if (!storeOptional.isPresent())
			return ResponseEntity.notFound().build();
		store.setCode(code);
		sr.save(store);
		return ResponseEntity.noContent().build();
	}
		
}	
