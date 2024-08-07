package com.RideTogether.Driver.service;

import com.RideTogether.Driver.driver.Driver;
import com.RideTogether.Driver.dto.DriverDto;
import com.RideTogether.Driver.repository.DriverRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService {
  @Autowired private DriverRepository driverRepo;

  @Override
  public void addDriver(DriverDto driverdto) {
    Driver driver = new Driver();
    driver.setDriverId(driverdto.getDriverId());
    driver.setDriverName(driverdto.getDriverName());
    driver.setDob(driverdto.getDob());
    driver.setRating(driverdto.getRating());
    driver.setPhoneNumber(driverdto.getPhoneNumber());
    driverRepo.save(driver);
  }

  @Override
  public void updateDriver(Driver driver, DriverDto driverdto) {
    driver.setPhoneNumber(driverdto.getPhoneNumber());
    driver.setDriverName(driverdto.getDriverName());
    driver.setDob(driverdto.getDob());
    driverRepo.save(driver);
  }

  @Override
  public Driver getDriver(String driverId) {

    return driverRepo.findById(driverId).orElse(null);
  }

  @Override
  public void deleteDriver(String driverId) {
    driverRepo.deleteById(driverId);
  }

  @Override
  public List<Driver> getAllDrivers() {

    return driverRepo.findAll();
  }
}
