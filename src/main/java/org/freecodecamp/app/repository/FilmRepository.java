package org.freecodecamp.app.repository;

import java.util.Optional;
import java.util.stream.Stream;

import org.freecodecamp.app.model.Film;

import com.speedment.jpastreamer.application.JPAStreamer;
import com.speedment.jpastreamer.projection.Projection;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.freecodecamp.app.model.Film;
import org.freecodecamp.app.model.Film$;

@ApplicationScoped
public class FilmRepository {
	
	private static final int PAGE_SIZE = 20;

	@Inject
	JPAStreamer jpaStreamer;

	public Optional<Film> getFilm(short filmId) {
		return jpaStreamer.stream(Film.class)
				.filter(Film$.filmId.equal(filmId))
				.findFirst();
	}
	
	public Stream<Film> paged(long page, short minLength) {
		return jpaStreamer.stream(Projection.select(Film$.filmId, Film$.title, Film$.length))
				.filter(Film$.length.greaterThan(minLength))
				.sorted(Film$.length)
				.skip(page * PAGE_SIZE)
				.limit(PAGE_SIZE);
	}

}
