package com.RideTogether.Driver.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDto {
  private String driverId;
  private String driverName;
  private LocalDate dob;
  private Long phoneNumber;
  private Double rating;
}
