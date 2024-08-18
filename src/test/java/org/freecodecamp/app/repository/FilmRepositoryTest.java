package org.freecodecamp.app.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.freecodecamp.app.model.Film;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class FilmRepositoryTest {
	
	@Inject
	FilmRepository filmRepository;
	
	@Test
	public void test() {
		Optional<Film> film = filmRepository.getFilm((short) 5);
		assertTrue(film.isPresent());
		assertEquals("AFRICAN EGG", film.get().getTitle());
	}

}
