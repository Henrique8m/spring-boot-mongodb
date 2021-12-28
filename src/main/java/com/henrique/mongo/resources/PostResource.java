package com.henrique.mongo.resources;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.henrique.mongo.domain.Post;
import com.henrique.mongo.services.PostService;

@Controller
@RequestMapping(value = "/posts")
public class PostResource implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PostService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		return ResponseEntity.ok().body(service.findById(id));
	}

}
