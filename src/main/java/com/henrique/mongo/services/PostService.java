package com.henrique.mongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henrique.mongo.domain.Post;
import com.henrique.mongo.repository.PostRepository;
import com.henrique.mongo.services.exception.ObjectNotFoundException;

@Service
public class PostService{
	
	@Autowired
	private PostRepository repository;
	
	public Post findById(String id) {
		Optional<Post> opt = repository.findById(id);
		return opt.orElseThrow(() -> new ObjectNotFoundException("Post Não encontrado"));
	}
	
	public List<Post> findByTitle(String text){
		return repository.findByTitle(text);
	}

	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000); // para buscar na data maxima, essa data tem que ser somado mais um dia, o dia e dado em milesegundo por isso a equação
		return repository.fullSearch(text, minDate, maxDate);
	}
	
}
