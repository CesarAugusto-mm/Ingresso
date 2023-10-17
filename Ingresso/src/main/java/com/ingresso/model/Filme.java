package com.ingresso.model;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_filme")
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Insira o nome")
	private String nome;
	
	private Date dataLancamento;
	
	@NotBlank(message = "Insira a sinopse")
	private String sinopse;
	
	private Boolean emCartaz;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "filme")
	@JsonIgnoreProperties("filme")
	private List<Ingresso> ingresso;
	
	@ManyToOne
	@JsonIgnoreProperties("filme")
	private Genero genero;
	
	private int fxIdade;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Boolean getEmCartaz() {
		return emCartaz;
	}

	public void setEmCartaz(Boolean emCartaz) {
		this.emCartaz = emCartaz;
	}

	public List<Ingresso> getIngresso() {
		return ingresso;
	}

	public void setIngresso(List<Ingresso> ingresso) {
		this.ingresso = ingresso;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public int getFxIdade() {
		return fxIdade;
	}

	public void setFxIdade(int fxIdade) {
		this.fxIdade = fxIdade;
	}
	
}
