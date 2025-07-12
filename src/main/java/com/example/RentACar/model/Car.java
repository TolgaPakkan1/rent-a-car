package com.example.RentACar.model;

/*import com.example.RentACar.enumm.FuelType;
import com.example.RentACar.enumm.TransmissionType;*/
import com.example.RentACar.enumm.FuelType;
import com.example.RentACar.enumm.TransmissionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cars")

public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private int year;

    private String colour;

    private Double dailyPrice;

    private Double km;

    @Enumerated(EnumType.STRING)
    private TransmissionType transmissionType;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Column(name = "units_in_stock")
    private int unitInStock;

    @Column(name = "brand_id")
    private Long brandId;

    private String image;

    private Boolean active;
}
