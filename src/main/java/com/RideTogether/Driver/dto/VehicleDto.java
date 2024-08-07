package com.RideTogether.Driver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
  private String vehicleId;
  private String vehicleName;
  private String model;
  private int noOfSeats;
  private String driverId;
}
