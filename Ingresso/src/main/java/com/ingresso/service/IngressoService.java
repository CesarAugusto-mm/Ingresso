package com.ingresso.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.ingresso.model.Filme;
import com.ingresso.model.Ingresso;
import com.ingresso.repository.FilmeRepository;
import com.ingresso.repository.IngressoRepository;

@Service
public class IngressoService {

	@Autowired
	private FilmeRepository filmeRepository;

	@Autowired
	private IngressoRepository ingressoRepository;

	public Ingresso comprar(Ingresso ingresso, int idFilme) {

		Optional<Filme> filmeExist = filmeRepository.findById(idFilme);

		if (filmeExist.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "O filme não existe");

		if (filmeExist.get().getFxIdade() > ingresso.getIdade())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Você não possui idade para ver este filme!");

		return ingressoRepository.save(ingresso);

	}

	public Ingresso getIngressoById(int id) {
		Optional<Ingresso> ingressoExist = ingressoRepository.findById(id);

		if (ingressoExist.isEmpty())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ingresso inexistente");
		
		
		return ingressoExist.get();

	}
	
	public void cancelar(int id) {
		Optional<Ingresso> ingressoExist = ingressoRepository.findById(id);
		
		if (ingressoExist.isEmpty())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ingresso inesistente");
		
		if (ChronoUnit.DAYS.between(LocalDate.now(), ingressoExist.get().getDiaHora()) < 5) 
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Expirado");
		
		
		  ingressoRepository.deleteById(id);	
	}
	
		public Ingresso trocarDeSala(int id, int numSala) {
			Optional<Ingresso> ingressoExist = ingressoRepository.findById(id);
			
			if (ingressoExist.isEmpty())
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ingresso inesistente");
			
			if (ChronoUnit.DAYS.between(LocalDate.now(), ingressoExist.get().getDiaHora()) > 20) 
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Expirado");
			
			ingressoExist.get().setSala(numSala);
			
			return ingressoRepository.save(ingressoExist.get());
			
		}
		
		public Ingresso trocardepoltrona(int id, int numPoltrona) {
			Optional<Ingresso> ingressoExist = ingressoRepository.findById(id);
			
			if (ingressoExist.isEmpty())
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ingresso inesistente");
			
			if (ChronoUnit.DAYS.between(LocalDate.now(),ingressoExist.get().getDiaHora()) > 9)
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Expirado");
			
			ingressoExist.get().setPoltrona(numPoltrona);
			
			return ingressoRepository.save(ingressoExist.get());
		}
	
}
