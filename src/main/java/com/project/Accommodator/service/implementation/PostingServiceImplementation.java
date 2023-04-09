package com.project.Accommodator.service.implementation;

import com.project.Accommodator.model.PostRequestBody;
import com.project.Accommodator.model.Posting;
import com.project.Accommodator.model.Response;
import com.project.Accommodator.service.PostingService;
import com.project.Accommodator.repository.PostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Service
public class PostingServiceImplementation implements PostingService {
    @Autowired
    PostingRepository PostingRepository;

    public PostingServiceImplementation() {
        super();
    }

    @Override
    public Object createPosting(PostRequestBody postRequestBody) {

        Posting post = new Posting();
        post.setAddress(postRequestBody.getAddress());
        post.setCategory(postRequestBody.getCategory());
        post.setDate(postRequestBody.getDate());
        post.setDescription(postRequestBody.getDescription());
        post.setRent(postRequestBody.getRent());
        post.setType(postRequestBody.getType());
        post.setPincode(postRequestBody.getPincode());
        post.setEmail(postRequestBody.getEmail());
        post.setOwnerId(postRequestBody.getOwnerId());
        PostingRepository.save(post);
        if(postRequestBody.getImage() != null && !postRequestBody.getImage().isEmpty()){
            MultipartFile image = postRequestBody.getImage();
            try {
                byte[] bytes =image.getBytes();
                String extension = "";
                int i = image.getOriginalFilename().lastIndexOf('.');
                if (i > 0) {
                    extension = image.getOriginalFilename().substring(i + 1);
                }


                String fileName = post.getPostId() + "." + extension;

                File dir = new File(  "./static/post_images");
                if(!dir.exists()){
                    dir.mkdirs();
                }

                File uploadedFile = new File(dir.getAbsolutePath() + File.separator + fileName);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                stream.write(bytes);
                stream.close();

                post.setImage("http://csci5308vm25.research.cs.dal.ca/"+"/static/post_images/" + fileName);
                post = PostingRepository.save(post);

                return post;
            } catch (Exception e) {
                e.printStackTrace();
                return new Response("error", "An error occurred while processing your request. Please try again later.");
            }
        } else {
            return post;
        }
    }

    @Override
    public Iterable<Posting> getPostingById(int id) {
        Iterable<Posting> Posting = PostingRepository.getPostingById(id);
        return Posting;
    }
    @Override
    public Iterable<Posting> getAllPosts() {
        Iterable<Posting> Posting = PostingRepository.findAll();
        return Posting;
    }
}