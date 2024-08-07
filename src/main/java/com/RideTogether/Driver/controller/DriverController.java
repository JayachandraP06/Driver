package com.RideTogether.Driver.controller;

import com.RideTogether.Driver.driver.Driver;
import com.RideTogether.Driver.dto.DriverDto;
import com.RideTogether.Driver.repository.DriverRepository;
import com.RideTogether.Driver.service.DriverService;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
public class DriverController {

  @Autowired private DriverService driverservice;

  @Autowired private DriverRepository driverRepository;

  @PostMapping
  public ResponseEntity<?> addDriver(@RequestBody DriverDto driverdto) {
    driverservice.addDriver(driverdto);
    return new ResponseEntity<>("Driver details Created successfully", HttpStatus.CREATED);
  }

  @PutMapping("/{driverId}")
  public ResponseEntity<?> updateDriver(
      @PathVariable String driverId, @RequestBody DriverDto driverdto) {

    Driver driver = driverservice.getDriver(driverId);

    if (Objects.isNull(driver))
      return new ResponseEntity<>("Driver not found", HttpStatus.NOT_FOUND);

    driverservice.updateDriver(driver, driverdto);
    return new ResponseEntity<>("Driver details Updated successfully", HttpStatus.OK);
  }

  @GetMapping("/{driverId}")
  public ResponseEntity<?> getDriver(@PathVariable String driverId) {
    Driver driver = driverservice.getDriver(driverId);
    if (Objects.nonNull(driver)) return new ResponseEntity<>(driver, HttpStatus.OK);
    return new ResponseEntity<>("Driver not found", HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/{driverId}")
  public ResponseEntity<?> deleteDriver(@PathVariable String driverId) {
    Driver driver = driverservice.getDriver(driverId);
    if (Objects.isNull(driver))
      return new ResponseEntity<>("Driver not found", HttpStatus.NOT_FOUND);
    driverservice.deleteDriver(driverId);
    return new ResponseEntity<>("Driver deleted successfully", HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Driver>> getAllDrivers() {

    return new ResponseEntity<>(driverservice.getAllDrivers(), HttpStatus.OK);
  }
}
