package io.my.estateservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
//import org.springframework.data.elasticsearch.annotations.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@Document(indexName = "estatesearch")
public class SearchRequestModel {
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
}
