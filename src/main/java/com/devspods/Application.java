package com.devspods;

import com.devspods.domain.Category;
import com.devspods.domain.Post;
import com.devspods.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			
            Post post = new Post();

            post.setCategory(new Category("Java"));
            post.setTitle("Working with Stream and Lambda expressions");
            post.setExcerpt("Bozho is right. I've encountered circumstances where I've had collections that I wanted to manage manually because of their size, or because of business rules that don't allow all objects in a collection to get saved at the same time.");
            post.setContent("<h2>HTML Forms</h2><form action=\"/action_page.php\">First name:<br><input type=\"text\" name=\"firstname\" value=\"Mickey\"><br>Last name:<br><input type=\"text\" name=\"lastname\" value=\"Mouse\"><br><br><input type=\"submit\" value=\"Submit\"></form><p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/action_page.php\".</p>");

            this.postRepository.save(post);
        };
    }
}
