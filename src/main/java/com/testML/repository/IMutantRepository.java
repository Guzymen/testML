package com.testML.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.testML.model.DnaAnalysis;

@Repository
public interface IMutantRepository extends MongoRepository<DnaAnalysis, String>{

    public long countByIsMutant(boolean isMutant);
}
