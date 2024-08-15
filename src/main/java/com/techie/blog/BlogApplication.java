package com.techie.blog;

import com.techie.blog.model.Blog;
import com.techie.blog.model.Comments;
import com.techie.blog.model.User;
import com.techie.blog.repository.BlogRepository;
import com.techie.blog.repository.CommentsRepository;
import com.techie.blog.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Slf4j
@SpringBootApplication
public class BlogApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private CommentsRepository commentsRepository;

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		log.info("Server Started!");

		// creating sample user for ease
		User user = new User();
		user.setUserName("swapnil-anand");
		user.setFirstName("swapnil");
		user.setLastName("sharma");
		user.setMiddleName("anand");
		user.setPassword("ninja@1Q");
		user.setCreatedBy("swapnil");
		user.setCreatedDt(LocalDateTime.now());
		user.setUpdatedBy("swapnil");
		user.setUpdatedDt(LocalDateTime.now());

		// user saving into repository
		userRepository.save(user);

		log.info("User Saved in to the database with id {}", user.getId());

		Blog blog = new Blog();
		blog.setBlogContent("Sample Blog from CLI");
		blog.setAuthor("Swapnil Anand");
		blog.setCreatedDt(LocalDateTime.now());
		blog.setUser(user);
		blog.setTitle("The Reapers Death!");
		blog.setLastUpdatedBy("Swapnil Anand");
		blog.setLastUpdatedDt(LocalDateTime.now());
		blog.setCreatedBy("Swapnil Anand");

		blogRepository.save(blog);
		log.info("Blog Saved in to the database with id {}", blog.getId());

		Comments comment = new Comments();
		comment.setBlogPost(blog);
		comment.setComment("Good");
		comment.setUpdatedBy("Swapnil Anand");
		comment.setUpdatedDt(LocalDateTime.now());
		comment.setCreatedDt(LocalDateTime.now());
		comment.setCreatedBy("Swapnil Anand");
		comment.setUserName("Swapnil Anand");


		commentsRepository.save(comment);
		log.info("Comment Saved in to the database with id {}", comment.getId());
	}
}
