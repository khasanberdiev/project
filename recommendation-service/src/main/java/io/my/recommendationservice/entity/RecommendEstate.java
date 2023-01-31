package io.my.recommendationservice.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecommendEstate {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String location;
    private int price;
    private int size;




}
