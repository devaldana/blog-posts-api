package com.devspods;

import com.devspods.domain.Author;
import com.devspods.domain.Category;
import com.devspods.domain.Gender;
import com.devspods.domain.PostStatus;
import com.devspods.services.AuthorService;
import com.devspods.services.CategoryService;
import com.devspods.services.GenderService;
import com.devspods.services.PostStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    @Autowired
    private GenderService genderService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PostStatusService postStatusService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner run() {
		
        return (args) -> {

            Gender male = this.genderService.save(new Gender("MALE"));
            Gender female = this.genderService.save(new Gender("FEMALE"));

            Author author = new Author();
            author.setName("David");
            author.setLastName("Aldana");
            author.setGender(male);

            Author author2 = new Author();
            author2.setName("Gabriela");
            author2.setLastName("Aldana");
            author2.setGender(female);

            this.authorService.save(author);
            this.authorService.save(author2);

            Category cat1 = new Category("Java", "The Java language associated topics");
            Category cat2 = new Category("Data Structures", "The Java, language associated topics");

            this.categoryService.save(cat1);
            this.categoryService.save(cat2);

            PostStatus published = new PostStatus("PUBLISHED");
            PostStatus draft = new PostStatus("DRAFT");

            this.postStatusService.save(published);
            this.postStatusService.save(draft);


//            Post post = new Post();
//
//            post.setCategory(cat1);
//            post.setStatus(published);
//            post.setPermalink("/the-java-language-associated-topics");
//            post.setTitle("Working with Stream and Lambda expressions");
//            post.setExcerpt("Bozho is right. I've encountered circumstances where I've had collections that I wanted to manage manually because of their size, or because of business rules that don't allow all objects in a collection to get saved at the same time.");
//            post.setContent("<h2>HTML Forms</h2><form action=\"/action_page.php\">First name:<br><input type=\"text\" name=\"firstname\" value=\"Mickey\"><br>Last name:<br><input type=\"text\" name=\"lastname\" value=\"Mouse\"><br><br><input type=\"submit\" value=\"Submit\"></form><p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/action_page.php\".</p>");
//            post.addAuthor(author);
//            post.addAuthor(author2);
//            post.addTechnicalReviewer(author2);
//            post.setDateOfPublication(LocalDateTime.now());
//
//            Post post2 = new Post();
//
//            post2.setCategory(cat2);
//            post2.setStatus(draft);
//            post2.setPermalink("/the-java-language-associated-topics-part-2");
//            post2.setTitle("Jax-RS");
//            post2.setExcerpt("Bozho is yes. I've encountered circumstances where I've had collections that I wanted to manage manually because of their size, or because of business rules that don't allow all objects in a collection to get saved at the same time.");
//            post2.setContent("<h2>HTML Forms X</h2><form action=\"/action_page.php\">First name:<br><input type=\"text\" name=\"firstname\" value=\"Mickey\"><br>Last name:<br><input type=\"text\" name=\"lastname\" value=\"Mouse\"><br><br><input type=\"submit\" value=\"Submit\"></form><p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/action_page.php\".</p>");
//
////            Author auth = new Author();
////            auth.setId(1L);
//
//            post2.addAuthor(author);
//            post2.addTechnicalReviewer(author);
//            post2.addTechnicalReviewer(author2);
//            post2.setDateOfPublication(LocalDateTime.now());
//
//            this.postRepository.deleteAll();
//            this.postRepository.saveAll(Arrays.asList(post, post2));
        };
    }
}
