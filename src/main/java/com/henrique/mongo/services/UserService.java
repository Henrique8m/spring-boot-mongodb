package com.henrique.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henrique.mongo.domain.User;
import com.henrique.mongo.repository.UserRepository;
import com.henrique.mongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		
		return repository.findAll();
		
	}
	
	public User findById(String id) {
		
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));	
					
	}
	
}
