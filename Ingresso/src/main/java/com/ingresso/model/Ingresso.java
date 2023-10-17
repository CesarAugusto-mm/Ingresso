package com.ingresso.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_ingresso")
public class Ingresso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank(message = "Insira o nomeComprador")
	private String nomeComprador;

	private Integer idadeComprador;
	
	@NotBlank(message = "Insira o enderecoCinema")
	private String enderecoCinema;

	@Min(value = 1)
	@Max(value = 15)
	private Integer sala;

	@Min(value = 1)
	@Max(value = 116)
	private Integer poltrona;

	private LocalDate diaHora;

	private Double Valor;
    
	@ManyToOne
	@JsonIgnoreProperties("ingresso")
	private Filme filme;
	
	private int idade;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeComprador() {
		return nomeComprador;
	}

	public void setNomeComprador(String nomeComprador) {
		this.nomeComprador = nomeComprador;
	}

	public Integer getIdadeComprador() {
		return idadeComprador;
	}

	public void setIdadeComprador(Integer idadeComprador) {
		this.idadeComprador = idadeComprador;
	}

	public String getEnderecoCinema() {
		return enderecoCinema;
	}

	public void setEnderecoCinema(String enderecoCinema) {
		this.enderecoCinema = enderecoCinema;
	}

	public Integer getSala() {
		return sala;
	}

	public void setSala(Integer sala) {
		this.sala = sala;
	}

	public Integer getPoltrona() {
		return poltrona;
	}

	public void setPoltrona(Integer poltrona) {
		this.poltrona = poltrona;
	}

	public LocalDate getDiaHora() {
		return diaHora;
	}

	public void setDiaHora(LocalDate diaHora) {
		this.diaHora = diaHora;
	}

	public Double getValor() {
		return Valor;
	}

	public void setValor(Double valor) {
		Valor = valor;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
}
