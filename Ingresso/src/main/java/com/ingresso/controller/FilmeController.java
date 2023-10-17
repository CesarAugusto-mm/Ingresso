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

import com.ingresso.model.Filme;
import com.ingresso.repository.FilmeRepository;

@RestController
@RequestMapping("/filme")
public class FilmeController {
	
	@Autowired
	private FilmeRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Filme>> get() {
		return ResponseEntity.ok(repository.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Filme> getById(@PathVariable int id) {
		Optional<Filme> filmeExist = repository.findById(id);
		
		if (filmeExist.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
		return ResponseEntity.ok(filmeExist.get());
	}
	
	@PostMapping
	public ResponseEntity<Filme> post(@RequestBody Filme filme) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(filme));
	}

	@PutMapping 
	public ResponseEntity<Filme> put(@RequestBody Filme filme) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(filme));
	}
	
	@DeleteMapping
	public ResponseEntity<?> delete(@PathVariable int id) {
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
