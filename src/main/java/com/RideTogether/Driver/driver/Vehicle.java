package com.RideTogether.Driver.driver;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "vehicle")
public class Vehicle {
  @Id private String vehicleId;
  private String vehicleName;
  private String model;
  private int noOfSeats;
  private String driverId;
}
