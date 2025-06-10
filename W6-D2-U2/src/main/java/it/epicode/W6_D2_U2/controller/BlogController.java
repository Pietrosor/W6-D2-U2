package it.epicode.W6_D2_U2.controller;

import it.epicode.W6_D2_U2.exception.BlogNotFoundException;
import it.epicode.W6_D2_U2.model.Blog;
import it.epicode.W6_D2_U2.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/blogs")
    @ResponseStatus(HttpStatus.CREATED)
    public Blog saveBlog(@RequestBody Blog blog){
        return blogService.saveBlog(blog);
    }

    @GetMapping
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }
    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable int id) throws BlogNotFoundException {
        return blogService.getBlogById(id);
    }

    @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable int id, @RequestBody Blog blog)
    throws BlogNotFoundException{
        return blogService.updateBlog(id,blog);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
    public void deleteBlog(@PathVariable int id) throws BlogNotFoundException {
        blogService.deleteBlog(id);
    }




}
