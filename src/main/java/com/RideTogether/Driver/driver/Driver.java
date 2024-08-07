package com.RideTogether.Driver.driver;

import java.time.LocalDate;
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
@Document(collection = "Driver")
public class Driver {
  @Id private String driverId;
  private String driverName;
  private LocalDate dob;
  private Long phoneNumber;
  private Double rating;
}
