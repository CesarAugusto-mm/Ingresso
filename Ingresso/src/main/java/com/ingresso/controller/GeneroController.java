package com.ingresso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingresso.model.Genero;
import com.ingresso.repository.GeneroRepository;

@RestController
@RequestMapping("/genero")
public class GeneroController {

	@Autowired
	private GeneroRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Genero>> get() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Genero>getById(@PathVariable int id) {
		Optional<Genero> generoExist = repository.findById(id);
		
		if (generoExist.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.ok(generoExist.get());
	}
	
	@PostMapping
	public ResponseEntity<Genero> post(@RequestBody Genero genero) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(genero));
	}
	
	@PutMapping
	public ResponseEntity<Genero> put(@RequestBody Genero genero) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(genero));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
