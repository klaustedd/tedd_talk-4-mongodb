package com.testes.spring.exemplo.empresas.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.testes.spring.exemplo.empresas.models.EmpresaEnvelope;

@Repository
public interface EmpresaEnvelopeRepository extends MongoRepository<EmpresaEnvelope, String> {

}
