package com.project.Accommodator.service.implementation;

import com.project.Accommodator.model.Posting;
import com.project.Accommodator.service.PostingService;
import com.project.Accommodator.repository.PostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**

 Implementation of the PostingService interface that provides functionality to create and retrieve postings.
 */
@Service
public class PostingServiceImplementation implements PostingService {

    /**

     Repository for managing postings.
     */
    @Autowired
    PostingRepository PostingRepository;
    /**

     Constructor for PostingServiceImplementation.
     */
    public PostingServiceImplementation() {
        super();
    }
    /**

     Creates a new posting and saves it to the repository.
     @param Posting The posting to be created.
     @return The created posting.
     */
    @Override
    public Posting createPosting(Posting Posting) {
        return PostingRepository.save(Posting);
    }
    /**

     Retrieves postings associated with the given owner ID.
     @param id The ID of the owner.
     @return An iterable of postings associated with the given owner ID.
     */
    @Override
    public Iterable<Posting> getPostingById(int id) {
        Iterable<Posting> Posting = PostingRepository.getPostingById(id);
        return Posting;
    }
    /**

     Retrieves all postings in the repository.
     @return An iterable of all postings in the repository.
     */
    @Override
    public Iterable<Posting> getAllPosts() {
        Iterable<Posting> Posting = PostingRepository.findAll();
        return Posting;
    }
}