package it.epicode.W6_D2_U2.service;

import it.epicode.W6_D2_U2.exception.BlogNotFoundException;
import it.epicode.W6_D2_U2.model.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogService {
    private List<Blog> blogs = new ArrayList<>();

    public Blog saveBlog(Blog blog){
        blog.setId(new Random().nextInt(1,300));
        blog.setCover("https://picsum.photos/200/300");
        blogs.add(blog);
        return blog;
    }

    public List<Blog> getAllBlogs() {
        return new ArrayList<>(blogs);
    }

    public Blog getBlogById(int id) throws BlogNotFoundException{
        return blogs.stream().filter(blog -> blog.getId()==id).findFirst().orElseThrow();
    }

    public Blog updateBlog(int id,Blog blog)throws BlogNotFoundException{
        Blog blogDaCercare = getBlogById(id);

        blogDaCercare.setCategoria(blog.getCategoria());
        blogDaCercare.setTitolo(blog.getTitolo());
        blogDaCercare.setContenuto(blog.getContenuto());
        blogDaCercare.setTempoDiLettura(blog.getTempoDiLettura());

        return blogDaCercare;
    }

    public void deleteBlog(int id) throws BlogNotFoundException{
        Blog blogDaRimuovere = getBlogById(id);

        blogs.remove(blogDaRimuovere);
    }


}
