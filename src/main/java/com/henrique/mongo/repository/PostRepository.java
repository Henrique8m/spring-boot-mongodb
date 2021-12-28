package com.henrique.mongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.henrique.mongo.domain.Post;

@Repository
public interface PostRepository  extends MongoRepository<Post, String>{
	
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitle(String text); //findByTitle ja é uma expressao que busca pelo titulo e tem muitas outras no https://docs.spring.io/spring-data/data-document/docs/current/reference/html/   so buscar por query methods
	
	// medodo de consulta, utilizando operadores logicos e comparadores, a expressao busca um texto que foi passado como parametro, no titulo ou comentarios ou post, em um intervalo de data, maior que a minima e menor que a maxima
	//https://docs.mongodb.com/manual/reference/operator/query/
	// ?0 -> possição em que encontra o objeto vindo como parametro começando do zero ex ?0 = text, ?1 = minDate, ?1 = maxDate
	@Query("{ $and: [  {date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
	
}
