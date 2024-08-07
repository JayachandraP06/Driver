package com.RideTogether.Driver.service;

import com.RideTogether.Driver.driver.Driver;
import com.RideTogether.Driver.dto.DriverDto;
import java.util.List;

public interface DriverService {
  public void addDriver(DriverDto driverdto);

  public void updateDriver(Driver driver, DriverDto driverdto);

  public Driver getDriver(String driverId);

  public void deleteDriver(String driverId);

  public List<Driver> getAllDrivers();
}
