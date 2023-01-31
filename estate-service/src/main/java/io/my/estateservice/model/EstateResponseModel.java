package io.my.estateservice.model;

import io.my.estateservice.enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class EstateResponseModel {
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

//    @ManyToOne(fetch=FetchType.LAZY, optional=false)
//    @JoinColumn(name="property_id", nullable = false)
//    private Category category;


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
}
