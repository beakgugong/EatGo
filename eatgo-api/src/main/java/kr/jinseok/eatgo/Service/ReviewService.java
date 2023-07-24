package kr.jinseok.eatgo.Service;

import kr.jinseok.eatgo.domain.Restaurant;
import kr.jinseok.eatgo.domain.Review;
import kr.jinseok.eatgo.domain.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private ReviewRepository reviewRepository;
    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review addReview(Long restaurantId, Review review){
        review.setRestaurantId(restaurantId);
        return reviewRepository.save(review);
    }
}
