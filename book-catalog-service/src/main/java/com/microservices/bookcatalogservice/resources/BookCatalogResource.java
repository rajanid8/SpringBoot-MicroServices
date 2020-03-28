package com.microservices.bookcatalogservice.resources;

import com.microservices.bookcatalogservice.model.Book;
import com.microservices.bookcatalogservice.model.BookCatalog;
import com.microservices.bookcatalogservice.model.UserRating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<BookCatalog> getCatalog(@PathVariable("userId") String userId){

        UserRating ratings = restTemplate.getForObject("http://localhost:8093/ratingData/users" + userId, UserRating.class);
        return ratings.getUserRatingList().stream().map(rating -> {
            //For each BookId call book-info-service and get book details
            Book book = restTemplate.getForObject("http://localhost:8092/books/" + rating.getBookId(), Book.class);
            //Put them all together
            return new BookCatalog(book.getBookName(), "description", rating.getRating());
        })
         .collect(Collectors.toList());



    }
}
