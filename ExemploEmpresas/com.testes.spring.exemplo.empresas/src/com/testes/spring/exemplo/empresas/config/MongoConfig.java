package com.testes.spring.exemplo.empresas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.testes.spring.exemplo.empresas.repositories.EmpresaEnvelopeRepository;

@Configuration
@EnableMongoRepositories(basePackageClasses = EmpresaEnvelopeRepository.class)
public class MongoConfig extends AbstractMongoClientConfiguration {

	@Override
	public MongoClient mongoClient() {
		return MongoClients.create("mongodb://localhost:27017/");
	}

	@Override
	protected String getDatabaseName() {
		return "MongoLoveEmpresasDB";
	}

}
