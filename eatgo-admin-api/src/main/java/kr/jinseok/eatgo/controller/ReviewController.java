package kr.jinseok.eatgo.controller;

import kr.jinseok.eatgo.Service.ReviewService;
import kr.jinseok.eatgo.domain.Restaurant;
import kr.jinseok.eatgo.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @GetMapping("/review")
    public List<Review> list(){
        List<Review> reviews = reviewService.getReviews();
        return reviews;
        }
    @GetMapping("/review/{id}")
    public List<Review> review(@PathVariable("id") Long id){
        List<Review> reviews = reviewService.getRestaurantReview(id);
        return reviews;
    }

}
