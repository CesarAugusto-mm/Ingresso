package com.ingresso.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingresso.model.Ingresso;
import com.ingresso.repository.IngressoRepository;
import com.ingresso.service.IngressoService;

@RestController
@RequestMapping("/ingresso")
public class IngressoController {
	
	@Autowired
	private IngressoRepository repository;
	
	@Autowired 
	private IngressoService service;
	
	@GetMapping
	public ResponseEntity<List<Ingresso>> get() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ingresso> getById(@PathVariable int id) {
		return ResponseEntity.ok(service.getIngressoById(id));
	}
	
	////
	@GetMapping("/{id}/{numSala}")
	public ResponseEntity<Ingresso> roonNumber(@PathVariable int id,@PathVariable int numSala) {
		return ResponseEntity.ok(service.trocarDeSala(id, numSala));
	}
	
	@GetMapping("/{id}/{numPoltrona}/poltrona")
	public ResponseEntity<Ingresso> seatNumber(@PathVariable int id, @PathVariable int numPoltrona) {
		return ResponseEntity.ok(service.trocardepoltrona(id, numPoltrona));
	}
	
	@PostMapping
	public ResponseEntity<Ingresso> post(@RequestBody Ingresso ingresso) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(service.comprar(ingresso, ingresso.getFilme().getId()));
	}
	
	@PutMapping
	public ResponseEntity<Ingresso> put(@RequestBody Ingresso ingresso) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(ingresso));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		service.cancelar(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
