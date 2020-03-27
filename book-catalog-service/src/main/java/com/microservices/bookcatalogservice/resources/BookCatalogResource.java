package com.microservices.bookcatalogservice.resources;

import com.microservices.bookcatalogservice.model.Book;
import com.microservices.bookcatalogservice.model.BookCatalog;
import com.microservices.bookcatalogservice.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResource {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<BookCatalog> getCatalog(@PathVariable("userId") String userId){

        List<Rating> ratings = Arrays.asList(
                new Rating("1001", 4),
                new Rating("1002", 3),
                new Rating("1003", 5)
        );

        //Calling book-info service into this book-catalog-service using WebClient
        return ratings.stream().map (rating -> {
            Book book = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8092/books/"+rating.getBookId())
                    .retrieve()
                    .bodyToMono(Book.class)
                    .block();
            return new BookCatalog(book.getBookName(), "complete book for Spring Boot", rating.getRating());
        }).collect(Collectors.toList());
    }
}
