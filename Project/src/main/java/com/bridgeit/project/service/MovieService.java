

package com.bridgeit.project.service;

import java.util.List;

import javax.validation.Valid;

import com.bridgeit.project.dto.MovieDTO;
import com.bridgeit.project.model.Actor;
import com.bridgeit.project.model.Movie;
import com.bridgeit.project.response.Response;

public interface MovieService {


	Response createMovie(MovieDTO moviedto);
	List<Movie> getAllMovie(long movieId);
	Response addActorProducerToMovie(long movieId, long producerId, List<String> actors);
	Response updateMovie(MovieDTO moviedto, long movieId);


	
}
