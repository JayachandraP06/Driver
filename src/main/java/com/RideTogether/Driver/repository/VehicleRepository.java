package com.RideTogether.Driver.repository;

import com.RideTogether.Driver.driver.Vehicle;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle, String> {

  public List<Vehicle> findByDriverId(String driverId);
}
