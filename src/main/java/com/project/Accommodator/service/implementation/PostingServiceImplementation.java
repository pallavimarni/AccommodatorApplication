package com.project.Accommodator.service.implementation;

import com.project.Accommodator.model.Posting;
import com.project.Accommodator.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostingServiceImplementation implements PostingService {
    @Autowired
    com.project.Accommodator.repository.PostingRepository PostingRepository;

    public PostingServiceImplementation() {
        super();
    }

    @Override
    public Posting createPosting(Posting Posting) {

        return PostingRepository.save(Posting);
    }

    @Override
    public Posting getPostingById(int id) {
        Posting Posting = PostingRepository.findById(id).orElse(null);
        return Posting;
    }
}