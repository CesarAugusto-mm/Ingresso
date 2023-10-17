package com.ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingresso.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {

}
