package com.henrique.mongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henrique.mongo.domain.User;
import com.henrique.mongo.dto.UserDTO;
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
	
	public User insert(User obj) {
		
		return repository.insert(obj);
		
	}
	
	public User fromDTO(UserDTO objDto) {
		
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
		
	}
}
