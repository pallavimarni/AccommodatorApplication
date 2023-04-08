package com.project.Accommodator.service.implementation;

import com.project.Accommodator.model.Favorite;
import com.project.Accommodator.model.Posting;
import com.project.Accommodator.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**

 Service implementation for managing favorites.
 */
@Service
public class FavoriteServiceImplementation implements FavoriteService {

    @Autowired
    com.project.Accommodator.repository.FavoriteRepository FavoriteRepository;

    /**

     Default constructor.
     */
    public FavoriteServiceImplementation() {
        super();
    }
    /**

     Creates a new favorite.
     @param favorite The favorite to be created.
     @return The created favorite.
     */
    @Override
    public Favorite createFavorite(Favorite favorite) {
        return FavoriteRepository.save(favorite);
    }
    /**

     Retrieves all postings marked as favorites by a specific student.
     @param id The ID of the student whose favorites are to be retrieved.
     @return The list of postings marked as favorites by the student.
     */
    @Override
    public Iterable<Posting> getFavoriteById(int id) {
        Iterable<Posting> posts = FavoriteRepository.findFavoritesById(id);
        return posts;
    }
}