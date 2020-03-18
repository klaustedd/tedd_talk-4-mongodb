package com.testes.spring.exemplo.empresas.models;

import org.apache.commons.text.WordUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@Document(collection = "empresas")
public class EmpresaEnvelope {
	@Id
	private String id;

	private String cnpj;
	private String cep;
	private String municipio;
	private String bairro;
	private String logradouro;
	private Long numero;

	private BasicDBObject jsonApi; // Objeto da lib do MongoDB que nos permite salvar um json no mongo (Ou seja, em
									// vez de converter o json para um objeto e depois o mongo converter esse objeto
									// novamente para json, nós passamos o json para esse Objeto e ele salva o json
									// direto no mongo)

	public void processarEnvelope(BasicDBObject jsonApi) {

		// Processa as informações
		processarCnpj(jsonApi);
		processarCep(jsonApi);
		processarMunicipio(jsonApi);
		processarBairro(jsonApi);
		processarLogradouro(jsonApi);
		processarNumero(jsonApi);

		// Seta o jsonApi
		setJsonApi(jsonApi);

	}

	public void processarCnpj(BasicDBObject jsonApi) {
		// Recupera o cnpj do jsonApi
		String cnpjJson = jsonApi.getString("cnpj");

		// Mantém apenas os números
		cnpjJson = cnpjJson.replaceAll("\\D+", "");

		// Adiciona ao empresaEnvelope
		setCnpj(cnpjJson);
	}

	public void processarCep(BasicDBObject jsonApi) {
		// Recupera o cep do jsonApi
		String cepJson = jsonApi.getString("cep");

		// Mantém apenas os números
		cepJson = cepJson.replaceAll("\\D+", "");

		// Adiciona ao empresaEnvelope
		setCep(cepJson);
	}

	public void processarMunicipio(BasicDBObject jsonApi) {
		// Recupera o logradouroJson do jsonApi
		String municipioJson = jsonApi.getString("municipio");

		// Muda de "RUA LEGAL" para "Rua Legal"
		municipioJson = WordUtils.capitalizeFully(municipioJson);

		// Adiciona ao empresaEnvelope
		setMunicipio(municipioJson);
	}

	public void processarBairro(BasicDBObject jsonApi) {
		// Recupera o bairro do jsonApi
		String bairroJson = jsonApi.getString("bairro");

		// Muda de "BAIRRO LEGAL" para "Bairro Legal"
		bairroJson = WordUtils.capitalizeFully(bairroJson);

		// Adiciona ao empresaEnvelope
		setBairro(bairroJson);
	}

	public void processarLogradouro(BasicDBObject jsonApi) {
		// Recupera o logradouroJson do jsonApi
		String logradouroJson = jsonApi.getString("logradouro");

		// Muda de "RUA LEGAL" para "Rua Legal"
		logradouroJson = WordUtils.capitalizeFully(logradouroJson);

		// Adiciona ao empresaEnvelope
		setLogradouro(logradouroJson);
	}

	public void processarNumero(BasicDBObject jsonApi) {
		// Recupera o logradouroJson do jsonApi
		String numeroJson = jsonApi.getString("numero");

		// Adiciona ao empresaEnvelope
		setNumero(Long.valueOf(numeroJson));
	}

	public EmpresaEnvelope() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public DBObject getJsonApi() {
		return jsonApi;
	}

	public void setJsonApi(BasicDBObject jsonApi) {
		this.jsonApi = jsonApi;
	}

}
