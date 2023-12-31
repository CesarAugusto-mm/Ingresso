package com.ingresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingresso.model.Ingresso;

@Repository
public interface IngressoRepository extends JpaRepository<Ingresso, Integer>{

}
