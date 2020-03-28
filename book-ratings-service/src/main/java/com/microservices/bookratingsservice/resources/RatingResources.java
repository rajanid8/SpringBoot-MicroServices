package com.microservices.bookratingsservice.resources;

import com.microservices.bookratingsservice.model.Rating;
import com.microservices.bookratingsservice.model.UserRating;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingData")
public class RatingResources {

    @RequestMapping("/{bookId}")
    public Rating getRating(@PathVariable("bookId") String bookId) {

        return new Rating(bookId, 4);
    }

    @RequestMapping("/users{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {

        List<Rating> ratings = Arrays.asList(
                new Rating("1001", 4),
                new Rating("1002", 3),
                new Rating("1003", 5)
        );
        UserRating userRating = new UserRating();
        userRating.setUserRatingList(ratings);
        return userRating;
    }

}
