package models;

import java.util.ArrayList;

public class Rating {
    ArrayList<Comments> listOfComments;
    ArrayList<Integer> listOfRatings;
    Integer totalRatingSum;

    public Rating() {
        this.listOfComments = new ArrayList<>();
        listOfRatings = new ArrayList<>();
        totalRatingSum = 0;
    }

    public void addCommentsAndRating(Integer rating, String comment){
        Comments c = new Comments(comment);
        listOfComments.add(c);
        listOfRatings.add(rating);
        totalRatingSum+=rating;
    }

    public double getAverageRating() {
        return totalRatingSum / (listOfRatings.size() * 1.0);
    }
}
