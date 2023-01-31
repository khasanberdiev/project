package io.my.recommendationservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recemmendation-service/")
public class RecommendationController {

    @GetMapping("/train")
    public void trainTheModel(){

    }
}
