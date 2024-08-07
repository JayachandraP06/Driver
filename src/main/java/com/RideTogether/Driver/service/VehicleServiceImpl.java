package com.RideTogether.Driver.service;

import com.RideTogether.Driver.driver.Vehicle;
import com.RideTogether.Driver.dto.VehicleDto;
import com.RideTogether.Driver.repository.VehicleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

  @Autowired private VehicleRepository vehicleRepository;

  @Override
  public void addVehicle(VehicleDto vehicleDto) {
    Vehicle vehicle =
        Vehicle.builder()
            .vehicleId(vehicleDto.getVehicleId())
            .vehicleName(vehicleDto.getVehicleName())
            .driverId(vehicleDto.getDriverId())
            .model(vehicleDto.getModel())
            .noOfSeats(vehicleDto.getNoOfSeats())
            .build();

    vehicleRepository.save(vehicle);
  }

  @Override
  public void updateVehicle(Vehicle vehicle, VehicleDto vehicleDto) {
    vehicle.setVehicleName(vehicle.getVehicleName());
    vehicle.setModel(vehicleDto.getModel());
    vehicle.setNoOfSeats(vehicle.getNoOfSeats());
    vehicleRepository.save(vehicle);
  }

  @Override
  public Vehicle getVehicle(String vehicleId) {
    return vehicleRepository.findById(vehicleId).orElse(null);
  }

  @Override
  public void deleteVehicle(String vehicleId) {
    vehicleRepository.deleteById(vehicleId);
  }

  @Override
  public List<Vehicle> getAllVehicles(String driverId) {
    return vehicleRepository.findByDriverId(driverId);
  }
}
