package com.project.Accommodator.service;
import com.project.Accommodator.model.Posting;

public interface PostingService {
    Posting createPosting(Posting Posting);

    Posting getPostingById(int id);

}
