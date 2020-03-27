package com.microservices.bookcatalogservice.resources;

import com.microservices.bookcatalogservice.model.BookCatalog;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResource {

    @RequestMapping("/{userId}")
    public List<BookCatalog> getCatalog(@PathVariable("userId") String userId){
             /*return Collections.singletonList(
                new BookCatalog("Spring Boot in Action", "Book about complete spring boot", 4),
              );*/
             return Arrays.asList(
                 new BookCatalog("Spring Boot in Action", "Book about basics in  spring boot", 3),
                 new BookCatalog("Mastering in Spring Boot", "Book about complete spring boot", 4),
                 new BookCatalog("Spring Microservices in Action", "Book about complete microservices", 4)
             );
    }
}
