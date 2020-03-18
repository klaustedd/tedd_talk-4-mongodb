package com.testes.spring.exemplo.empresas.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testes.spring.exemplo.empresas.dtos.CnpjDto;
import com.testes.spring.exemplo.empresas.services.EmpresaEnvelopeService;

@RestController
@RequestMapping("/rest/empresa-envelope")
public class EmpresaEnvelopeController {
	@Autowired
	private EmpresaEnvelopeService service;

	@PostMapping
	public ResponseEntity<Object> salvarCnpj(@RequestBody CnpjDto cnpjDto) {
		service.salvarCnpj(cnpjDto.getCnpj());
		return ResponseEntity.ok().build();
	}

	@GetMapping
	public ResponseEntity<Object> agruparPorMunicipio() {
		return ResponseEntity.ok(service.agruparPorMunicipio());
	}
}
