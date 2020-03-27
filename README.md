# SpringBoot-MicroServices

project 1 : 
book-catalog-service

project 2 : 
book-info-service

project 3 : 
book-rating-service



Master -
  
  Consists simple 3 spring boot applications
  
Branch 1 - 

ConsumeBookInfoService-RestTemplate

    Created for the code which is calling 'book-info-service' in 'book-catalog-service' using RestTemplate.
    
    Code is in BookCatalogResource.java.
    
    Only 'book-catalog-service' is changed, remaining two services are same like in master.
    
Branch 2 - 

ConsumeBookInfoService-WebClient

    Created for the code which is calling 'book-info-service' in 'book-catalog-service' using WebClient.
    
    Code is in BookCatalogResource.java.
    
    Only 'book-catalog-service' is changed, remaining two services are same like in master.
    


