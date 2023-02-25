package com.project.Accommodator.controller;
import com.project.Accommodator.model.Posting;
import com.project.Accommodator.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posting")
public class PostingController {
    @Autowired
    PostingService PostingService;
    @CrossOrigin

    @GetMapping("/get/{id}")
    public Posting getPostingById(@PathVariable("id") int id) {
        return PostingService.getPostingById(id);
    }
    @CrossOrigin
    @PostMapping("/create")
    public Posting createPosting(@RequestBody Posting Posting) {
        return PostingService.createPosting(Posting);
    }
}
