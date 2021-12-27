package com.henrique.mongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.henrique.mongo.domain.Post;
import com.henrique.mongo.domain.User;
import com.henrique.mongo.repository.PostRepository;
import com.henrique.mongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viajem ", "Vou viajar para são paulo. Abraços", maria);
		Post post2 = new Post(null, sdf.parse("21/03/2018"), "Bom dia ", "Acordei feliz hj!", maria);
		
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		
	}

}
