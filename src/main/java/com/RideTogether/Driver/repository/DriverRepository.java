package com.RideTogether.Driver.repository;

import com.RideTogether.Driver.driver.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends MongoRepository<Driver, String> {}
