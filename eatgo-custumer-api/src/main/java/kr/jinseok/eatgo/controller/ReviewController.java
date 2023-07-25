package kr.jinseok.eatgo.controller;

import kr.jinseok.eatgo.Service.ReviewService;
import kr.jinseok.eatgo.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @PostMapping("/restaurant/{restaurantId}/review")
    public ResponseEntity<?> create(@PathVariable("restaurantId")Long restaurantId, @Validated @RequestBody Review resource) throws URISyntaxException {
        Review review = reviewService.addReview(restaurantId,resource);
        String uri = "/restaurant/"+restaurantId+"/review/"+review.getId();
        return ResponseEntity.created(new URI (uri))
                .body("{}");
    }
}
