package com.microservices.bookratingsservice.model;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public class UserRating {

    private List<Rating> userRatingList;

    public List<Rating> getUserRatingList() {
        return userRatingList;
    }

    public void setUserRatingList(List<Rating> userRatingList) {
        this.userRatingList = userRatingList;
    }
}
