package com.ingresso.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_genero")
public class Genero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "Insira a descricao")
	private String discricao;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "genero")
	@JsonIgnoreProperties("genero")
	private List<Filme> filme;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDiscricao() {
		return discricao;
	}

	public void setDiscricao(String discricao) {
		this.discricao = discricao;
	}

	public List<Filme> getFilme() {
		return filme;
	}

	public void setFilme(List<Filme> filme) {
		this.filme = filme;
	}

		
}
