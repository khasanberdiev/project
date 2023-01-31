package io.my.addressservice.model.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressRequestModel {
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


}
