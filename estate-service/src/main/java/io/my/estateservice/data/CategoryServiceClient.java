package io.my.estateservice.data;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.my.estateservice.model.CategoryResponseModel;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

public interface CategoryServiceClient {
    @GetMapping("estate/categories")
    @CircuitBreaker(name = "category-service", fallbackMethod = "getAllCategoriesFallBack")
    public List<CategoryResponseModel> getAllCategories();
    default List<CategoryResponseModel> getAllCategoriesFallBack(Throwable exception){

        return new ArrayList<>();

    }
}
