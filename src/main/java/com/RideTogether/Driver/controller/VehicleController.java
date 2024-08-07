package com.RideTogether.Driver.controller;

import com.RideTogether.Driver.driver.Vehicle;
import com.RideTogether.Driver.dto.VehicleDto;
import com.RideTogether.Driver.service.VehicleService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/vehicle")
@RestController
public class VehicleController {

  @Autowired private VehicleService vehicleService;

  @PostMapping
  public ResponseEntity<?> addVehicle(@RequestBody VehicleDto vehicleDto) {
    vehicleService.addVehicle(vehicleDto);
    return new ResponseEntity<>("Vehicle details created successfully", HttpStatus.CREATED);
  }

  @PutMapping("/{vehicleId}")
  public ResponseEntity<?> updateVehicle(
      @PathVariable String vehicleId, @RequestBody VehicleDto vehicleDto) {
    Vehicle vehicle = vehicleService.getVehicle(vehicleId);
    if (Objects.isNull(vehicle))
      return new ResponseEntity<>("vehicle not found", HttpStatus.NOT_FOUND);
    vehicleService.updateVehicle(vehicle, vehicleDto);
    return new ResponseEntity<>("vehicle details updated successfully", HttpStatus.OK);
  }

  @GetMapping("/{vehicleId}")
  public ResponseEntity<?> getVehicle(@PathVariable String vehicleId) {
    Vehicle vehicle = vehicleService.getVehicle(vehicleId);
    if (Objects.isNull(vehicle))
      return new ResponseEntity<>("vehicle not found", HttpStatus.NOT_FOUND);
    return new ResponseEntity<>(vehicle, HttpStatus.OK);
  }

  @DeleteMapping("/{vehicleId}")
  public ResponseEntity<?> deleteVehicle(@PathVariable String vehicleId) {
    Vehicle vehicle = vehicleService.getVehicle(vehicleId);
    if (Objects.isNull(vehicle))
      return new ResponseEntity<>("Vehicle not found", HttpStatus.NOT_FOUND);
    vehicleService.deleteVehicle(vehicleId);
    return new ResponseEntity<>("Vehicle deleted successfully", HttpStatus.OK);
  }

  @GetMapping("/driver/{driverId}")
  public ResponseEntity<?> getAllVehicles(@PathVariable String driverId) {
    List<Vehicle> vehicleList = vehicleService.getAllVehicles(driverId);
    return new ResponseEntity<>(vehicleList, HttpStatus.OK);
  }
}
