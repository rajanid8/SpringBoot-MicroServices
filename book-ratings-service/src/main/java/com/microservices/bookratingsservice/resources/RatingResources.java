package com.microservices.bookratingsservice.resources;

import com.microservices.bookratingsservice.model.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingData")
public class RatingResources {

    @RequestMapping("/{bookId}")
    public Rating getRating(@PathVariable("bookId") String bookId) {

        return new Rating(bookId, 4);
    }

}
