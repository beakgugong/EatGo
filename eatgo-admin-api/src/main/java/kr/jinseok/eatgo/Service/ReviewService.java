package kr.jinseok.eatgo.Service;

import kr.jinseok.eatgo.domain.Restaurant;
import kr.jinseok.eatgo.domain.Review;
import kr.jinseok.eatgo.domain.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;
    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getReviews(){
        return reviewRepository.findAll();
    }
    public List<Review> getRestaurantReview(Long id){
        return reviewRepository.findAllByRestaurantId(id);
    }
}
