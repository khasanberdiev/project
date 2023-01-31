package io.my.categoryservice.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryRequestModel implements Serializable {
    @NotNull(message = "Category name cannot be empty")
    @Size(min = 2, max = 25)
    private String categoryName;
    @Size(min = 2, max = 150)
    private String description;
}
