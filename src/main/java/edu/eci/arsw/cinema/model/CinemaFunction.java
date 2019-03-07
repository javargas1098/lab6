/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.model;

import edu.eci.arsw.cinema.persistence.CinemaException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @author cristian
 */
public class CinemaFunction {

	private AtomicReference<Movie> movie = new AtomicReference<Movie>();
	private List<List<AtomicBoolean>> seats = Collections.synchronizedList(new ArrayList<>());
	private AtomicReference<String> date = new AtomicReference<String>();
	private AtomicReference<String> hour = new AtomicReference<String>();
	private AtomicReference<String> gen = new AtomicReference<String>();
	private int numSeats;

	public CinemaFunction() {
	}

	public CinemaFunction(Movie movie, String date) {
		this.setMovie(movie);
		;
		this.setDate(date.split(" ")[0]);
		this.setHour(date.split(" ")[1]);

		numSeats = 7 * 12;
		for (int i = 0; i < 7; i++) {
			List<AtomicBoolean> row = new ArrayList<AtomicBoolean>(Arrays.asList(new AtomicBoolean[12]));
			Collections.fill(row, new AtomicBoolean(true));
			this.seats.add(row);

		}
	}

	public String getHour() {
		return hour.get();
	}

	public void setHour(String hour) {
		this.hour.set(hour);
	}

	public void buyTicket(int row, int col) throws CinemaException {
		if (seats.get(row).get(col).get()) {
			seats.get(row).set(col, new AtomicBoolean(false));
			numSeats -= 1;

		} else {
			throw new CinemaException("Seat booked");
		}
	}

	public int getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	public String getGen() {
		return movie.get().getGenre();
	}

	public void setGen(String gen) {
		this.gen.set(movie.get().getGenre());
	}

	public List<List<AtomicBoolean>> getSeats() {
		return this.seats;
	}

	public void setFuntion(CinemaFunction funtion) {
		this.seats = funtion.getSeats();
		this.date.get();
		this.hour.get();
		this.numSeats = funtion.getNumSeats();

	}

	public Movie getMovie() {
		return movie.get();
	}

	public void setMovie(Movie movie) {
		this.movie.set(movie);
	}

	public String getDate() {
		return date.get();
	}

	public void setDate(String date) {
		this.date.set(date);
	}

}
