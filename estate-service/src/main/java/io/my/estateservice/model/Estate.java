package io.my.estateservice.model;

import io.my.estateservice.dto.Category;
import io.my.estateservice.enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Estate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estate_id")
    private Long id;

    @NotNull
    @Size(min = 3, max = 200, message= "Title must be between 3 and 200 characters")
    private String title;

    @NotNull
    @Positive
    @Min(value = 5, message = "Size should not be less than 5")
    private Integer size;

    @NotNull
    @Positive
    private Double price;

    @Positive
    private int bedroom;

    @Positive
    private int bathroom;

    @NotNull
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate available_from;

    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate available_until;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Purpose purpose;

    @NotNull
    private Long category_id;


    private int year_built;

    @Enumerated(EnumType.STRING)
    private Availability garage;

    @NotNull
    @Positive
    private int floor;

    @NotNull
    @Positive
    private int total_floor;

    // @Enumerated(EnumType.STRING)
    // private Status internet;

    private String description;
    private String feature;

    @Enumerated(EnumType.STRING)
    private Policy pet_policy;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Featured featured;

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

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
//    private Address address;
//
//    @OneToMany(mappedBy="property")
//    private List<Picture> picture;
}
