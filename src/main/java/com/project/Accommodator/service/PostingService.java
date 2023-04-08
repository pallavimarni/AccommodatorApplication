package com.project.Accommodator.service;
import com.project.Accommodator.model.PostRequestBody;
import com.project.Accommodator.model.Posting;

/**

 The PostingService interface provides methods to create, retrieve and manage postings.
 */
public interface PostingService {

    Object createPosting(PostRequestBody Posting);


    /**

     Creates a new posting.
     @param posting The posting to be created.
     @return The newly created posting.
     */
//    Posting createPosting(Posting posting);
    /**

     Retrieves postings by the specified id.
     @param id The id of the posting to be retrieved.
     @return An iterable collection of postings with the specified id.
     */
    Iterable<Posting> getPostingById(int id);
    /**

     Retrieves all postings.
     @return An iterable collection of all postings.
     */
    Iterable<Posting> getAllPosts();
}





