package com.testes.spring.exemplo.empresas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mongodb.BasicDBObject;
import com.testes.spring.exemplo.empresas.daos.EmpresaEnvelopeDAO;
import com.testes.spring.exemplo.empresas.dtos.MunicipioGroupDto;
import com.testes.spring.exemplo.empresas.models.EmpresaEnvelope;
import com.testes.spring.exemplo.empresas.repositories.EmpresaEnvelopeRepository;

@Service
public class EmpresaEnvelopeService {

	@Autowired
	private EmpresaEnvelopeRepository empresaEnvelopeRepository;

	@Autowired
	private EmpresaEnvelopeDAO empresaEnvelopeDAO;

	public void salvarCnpj(String cnpj) {
		/*---------------------- Fazendo a requisição ----------------------*/
		// Instancia o objeto que
		RestTemplate restTemplate = new RestTemplate();

		// Seta a url base para pesquisar o cnpj
		String url = "https://www.receitaws.com.br/v1/cnpj/";

		// Adiciona o cnpj que deve ser pesquisado
		url += cnpj;

		// Executa a pesquisa e pede como retorno o BasicDBObject
		BasicDBObject jsonApi = restTemplate.getForObject(url, BasicDBObject.class);

		/*---------------------- Gerando Envelope ----------------------*/
		// Gera um objeto de EmpresaEnvelope
		EmpresaEnvelope empresaEnvelope = new EmpresaEnvelope();

		// Processa as informações
		empresaEnvelope.processarEnvelope(jsonApi);

		/*---------------------- Persistindo os dados ----------------------*/
		empresaEnvelopeRepository.save(empresaEnvelope);
	}

	public List<MunicipioGroupDto> agruparPorMunicipio() {
		return empresaEnvelopeDAO.agruparPorMunicipio();
	}
}
