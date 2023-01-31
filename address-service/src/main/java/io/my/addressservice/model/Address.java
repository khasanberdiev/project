package io.my.addressservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 1, max = 200, message
            = "Title must be between 3 and 200 characters")
    private String houseNumber;

    @NotNull
    @Size(min = 1, max = 252, message
            = "Title must be between 3 and 252 characters")
    private String street;

    @NotNull
    @Size(min = 1, max = 252, message
            = "Title must be between 3 and 252 characters")
    private String city;

    @NotNull
    @Size(min = 1, max = 252, message
            = "Title must be between 3 and 252 characters")
    private String region;

    @Size(min = 1, max = 252, message
            = "Title must be between 3 and 252 characters")
    private String postalCode;

    @NotNull
    @Size(min = 1, max = 252, message
            = "Title must be between 3 and 252 characters")
    private String country;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;



//    @OneToOne(mappedBy = "address")
//    private Property property;
}
