package com.junaid.api.builder.microservices.dao.impl;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.junaid.api.builder.querymapper.query.bean.Registration;

public interface ApiRegistrationDao extends MongoRepository<Registration,String> {
}
