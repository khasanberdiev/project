package io.my.categoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    private String categoryName;
    private String description;

}
