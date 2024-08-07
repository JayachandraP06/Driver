package com.RideTogether.Driver.service;

import com.RideTogether.Driver.driver.Vehicle;
import com.RideTogether.Driver.dto.VehicleDto;
import java.util.List;

public interface VehicleService {
  public void addVehicle(VehicleDto vehicleDto);

  public void updateVehicle(Vehicle vehicle, VehicleDto vehicleDto);

  public Vehicle getVehicle(String vehicleId);

  public void deleteVehicle(String vehicleId);

  public List<Vehicle> getAllVehicles(String driverId);
}
