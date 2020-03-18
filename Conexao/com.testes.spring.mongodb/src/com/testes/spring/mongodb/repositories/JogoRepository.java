package com.testes.spring.mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.testes.spring.mongodb.models.JogoModel;

@Repository
public interface JogoRepository extends MongoRepository<JogoModel, String>{

}
