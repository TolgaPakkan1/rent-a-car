package com.example.RentACar.dto;

import com.example.RentACar.model.Address;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserDto {

    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private Address address;

    private String roles;
}
