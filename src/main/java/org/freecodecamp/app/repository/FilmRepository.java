package org.freecodecamp.app.repository;

import java.util.Optional;

import org.freecodecamp.app.model.Film;

import com.speedment.jpastreamer.application.JPAStreamer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.freecodecamp.app.model.Film;
import org.freecodecamp.app.model.Film$;

@ApplicationScoped
public class FilmRepository {
	
	@Inject
	 JPAStreamer jpaStreamer; 
	
	 public Optional<Film> getFilm(short filmId) {
	        return jpaStreamer.stream(Film.class)
	                .filter(Film$.filmId.equal(filmId))
	                .findFirst();
	    }

}
