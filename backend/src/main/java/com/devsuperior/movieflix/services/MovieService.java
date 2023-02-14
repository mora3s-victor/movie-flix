package com.devsuperior.movieflix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieAllDataDTO;
import com.devsuperior.movieflix.dto.SimpleMovieDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	
	@Transactional(readOnly = true)
	public MovieAllDataDTO findById(Long id) {
		Optional<Movie> obj = repository.findById(id);
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new MovieAllDataDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public Page<SimpleMovieDTO> findByGenre(Long genreId, Pageable pageable) {
		Genre genre = null;		
			if(genreId != 0) {
				genre = genreRepository.getOne(genreId);	
			}
		return repository.findByGenre(genre,pageable);
	}
	
}
