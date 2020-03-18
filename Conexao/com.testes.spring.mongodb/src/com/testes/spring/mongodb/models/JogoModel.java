package com.testes.spring.mongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "jogos")
public class JogoModel {
	@Id
	public String id;
	
	@Indexed
	public String nome;
	
	@Indexed
	public String desenvolvedora;
	
	@Indexed
	public String genero;
	
	public String informacoesAdicionais;

	public JogoModel() {

	}

	public JogoModel(String id, String nome, String desenvolvedora, String genero, String informacoesAdicionais) {

		this.id = id;
		this.nome = nome;
		this.desenvolvedora = desenvolvedora;
		this.genero = genero;
		this.informacoesAdicionais = informacoesAdicionais;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDesenvolvedora() {
		return desenvolvedora;
	}

	public void setDesenvolvedora(String desenvolvedora) {
		this.desenvolvedora = desenvolvedora;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getInformacoesAdicionais() {
		return informacoesAdicionais;
	}

	public void setInformacoesAdicionais(String informacoesAdicionais) {
		this.informacoesAdicionais = informacoesAdicionais;
	}

}
