package com.testes.spring.exemplo.empresas.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.stereotype.Component;

import com.testes.spring.exemplo.empresas.dtos.MunicipioGroupDto;

@Component
public class EmpresaEnvelopeDAO {
	@Autowired
	private MongoOperations mongoTemplate;

	public List<MunicipioGroupDto> agruparPorMunicipio() {

		// Define a operação de agregação -> {$group:{_id: "$municipio", count: { $sum:
		// 1 }}}
		GroupOperation municipioGroupOperation = Aggregation.group("municipio").count().as("count");

		// Define a operação de ordenação -> {$sort: { _id: 1}}
		SortOperation municipioSortOperation = Aggregation.sort(Direction.ASC, "_id");

		// Adiciona todas as operações na lista de AggregationOperation.
		// A ordem IMPORTA.
		AggregationOperation[] agregacoes = new AggregationOperation[] { municipioGroupOperation,
				municipioSortOperation };

		// Gera o objecto agggregation que como base o
		// AggregationOperation[]. Esse objeto é usado para executar a
		// pesquisa
		Aggregation aggregation = Aggregation.newAggregation(agregacoes);

		// Executa a query no banco de dados, e faz o cast para um objeto
		// genérico
		AggregationResults<MunicipioGroupDto> output = mongoTemplate.aggregate(aggregation, "empresas",
				MunicipioGroupDto.class);

		// Recupera o valor da propriedade "cotaExcedida"
		return output.getMappedResults();

	}
}
