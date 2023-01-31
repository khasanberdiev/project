package io.my.recommendationservice;

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
public class Recommendation {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private Long id_address;
    private int rooms;
    private int floor;
    private int builtYear;
    private int totalFloor;



}
