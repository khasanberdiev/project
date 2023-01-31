package io.my.categoryservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import io.my.categoryservice.model.Category;
import io.my.categoryservice.model.request.CategoryRequestModel;
import io.my.categoryservice.model.response.CategoryResponseModel;
import io.my.categoryservice.service.CategoryService;


@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);


    @Autowired
    private CategoryService categoryService;

    @GetMapping("/kiko")
    public String news(){
        return "kikosan works";
    }

    @PostMapping
    public ResponseEntity<CategoryResponseModel> create(@RequestBody CategoryRequestModel categoryRequestModel){
        ModelMapper modelMapper=new ModelMapper();

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Category category=modelMapper.map(categoryRequestModel, Category.class);
        Category savedCategory=categoryService.create(category);
        CategoryResponseModel categoryResponseModel=modelMapper.map(savedCategory, CategoryResponseModel.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryResponseModel);
    }
    @GetMapping
    public ResponseEntity<List<CategoryResponseModel>> getAll(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // Perform CRUD operations here



        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<Category> categories=categoryService.getAll();
        System.out.println(categories);


        List<CategoryResponseModel> body=categories.stream().map(category->modelMapper.map(category, CategoryResponseModel.class)).collect(Collectors.toList());
        stopWatch.stop();
        System.out.println("====================------------====================");
        LOG.info("Time taken to execute CRUD operations: {} ms", stopWatch.getTotalTimeMillis());
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") long id){
        categoryService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<CategoryResponseModel> update(@PathVariable("id") Long id,
//                                                        @RequestBody CategoryRequestModel categoryRequestModel){
//        categoryService.
//    }

}
