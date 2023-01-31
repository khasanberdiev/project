package io.my.addressservice.model.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressResponseModel {
    private Long id;
    private String houseNumber;
    private String street;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private Double latitude;
    private Double longitude;

}
