package com.devspods;

import com.devspods.domain.*;
import com.devspods.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {
	
    @Autowired
    private PostRepository postRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner run() {
		
        return (args) -> {

            Author author = new Author();

            author.setName("David");
            author.setLastName("Aldana");
            author.setSex(new Sex("MALE"));

            Author author2 = new Author();

            author2.setName("Gabriela");
            author2.setLastName("Aldana");
            author2.setSex(new Sex("FEMALE"));

            Post post = new Post();

            post.setCategory(new Category("Java", "The Java language associated topics"));
            post.setStatus(new PostStatus("PUBLISHED"));
            post.setTitle("Working with Stream and Lambda expressions");
            post.setExcerpt("Bozho is right. I've encountered circumstances where I've had collections that I wanted to manage manually because of their size, or because of business rules that don't allow all objects in a collection to get saved at the same time.");
            post.setContent("<h2>HTML Forms</h2><form action=\"/action_page.php\">First name:<br><input type=\"text\" name=\"firstname\" value=\"Mickey\"><br>Last name:<br><input type=\"text\" name=\"lastname\" value=\"Mouse\"><br><br><input type=\"submit\" value=\"Submit\"></form><p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/action_page.php\".</p>");
            post.addAuthor(author);
            post.addAuthor(author2);
            post.addTechnicalReviewer(author2);
            post.setDateOfPublication(LocalDateTime.now());

            this.postRepository.save(post);
        };
    }
}
