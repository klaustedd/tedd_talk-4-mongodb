package com.testes.spring.mongodb.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testes.spring.mongodb.models.JogoModel;
import com.testes.spring.mongodb.repositories.JogoRepository;

@RestController
@RequestMapping("/testes")
public class TesteController {
	@Autowired
	private JogoRepository jogoRepository;

	@PostMapping
	public ResponseEntity<Object> get(@RequestBody JogoModel jogoModel) {
		JogoModel salvo = jogoRepository.save(jogoModel);

		return ResponseEntity.ok(salvo);
	}

}
