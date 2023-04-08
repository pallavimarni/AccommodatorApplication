package com.project.Accommodator.service;
import com.project.Accommodator.model.Favorite;
import com.project.Accommodator.model.Posting;

/**

 Interface for FavoriteService, responsible for managing operations related to user's favorite postings
 */
public interface FavoriteService {

    /**

     Creates a new Favorite for a user
     @param favorite The Favorite object to be created
     @return The created Favorite object
     */
    Favorite createFavorite(Favorite favorite);
    /**

     Retrieves all the favorite postings of a user with the given id
     @param id The id of the user
     @return Iterable<Posting> object containing all the favorite postings
     */
    Iterable<Posting> getFavoriteById(int id);
}
//package com.project.Accommodator.service;
//import com.project.Accommodator.model.Favorite;
//import com.project.Accommodator.model.Posting;
//
//public interface FavoriteService {
//    Favorite createFavorite(int studentId, int postId);
//    Iterable<Posting> getFavoriteById(int id);
//}
