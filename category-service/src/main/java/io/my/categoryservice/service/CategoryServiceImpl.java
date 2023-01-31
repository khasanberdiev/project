package io.my.categoryservice.service;

import io.my.categoryservice.model.Category;
import io.my.categoryservice.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category create(Category category) {
        Category savedCategory=categoryRepository.save(category);
        return savedCategory;
    }

    @Override
    public void delete(Long id) {
        Optional<Category> category=categoryRepository.findById(id);
        if(!category.isPresent()){
            throw new NullPointerException("Does not exist");
        }
        categoryRepository.deleteById(id);

    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        Optional<Category> category=categoryRepository.findById(id);
        if(category.isEmpty()){
            throw new NoSuchElementException("Not found");
        }
        return category;
    }

    @Override
    public Optional<Category> update(Long id, Category category) {
        Optional<Category> savedCategory=categoryRepository.findById(id);
        if(savedCategory.isEmpty()){
            throw new NoSuchElementException("Not found");
        }

        return Optional.empty();
    }
}
