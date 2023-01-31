package io.my.categoryservice.service;

import io.my.categoryservice.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category create(Category category);
    void delete(Long id);
    List<Category> getAll();
    Optional<Category> findById(Long id);
    Optional<Category> update(Long id, Category category);
}
