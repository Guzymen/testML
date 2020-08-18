package com.testML.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.testML.repository.IMutantRepository;

public abstract class MutantRepository implements IMutantRepository {

    private static final String COLLECTION = "dnaAnalysis";
    
    @Autowired
    MongoTemplate mongoTemplate;
    
    @Override
    public long countByIsMutant(boolean isMutant) {
        Query query = new Query();
        query.addCriteria(Criteria.where("isMutant").is(isMutant));
        return this.mongoTemplate.count(query, COLLECTION);
    }

}
