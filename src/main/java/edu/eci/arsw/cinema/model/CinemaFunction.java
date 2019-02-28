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

/**
 *
 * @author cristian
 */
public class CinemaFunction {

	private Movie movie;
	private List<List<Boolean>> seats = new ArrayList<>();
	private String date;
	private String hour;
	private String gen;
	private int numSeats;

	public CinemaFunction() {
	}

	public CinemaFunction(Movie movie, String date) {
		this.movie = movie;
		this.date = date.split(" ")[0];
		this.hour = date.split(" ")[1];

		numSeats = 7 * 12;
		for (int i = 0; i < 7; i++) {
			List<Boolean> row = new ArrayList<>(Arrays.asList(new Boolean[12]));
			Collections.fill(row, Boolean.TRUE);
			this.seats.add(row);

		}
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public void buyTicket(int row, int col) throws CinemaException {
		if (seats.get(row).get(col).equals(true)) {
			seats.get(row).set(col, Boolean.FALSE);
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
		return movie.getGenre();
	}

	public void setGen(String gen) {
		this.gen = movie.getGenre();
	}

	public List<List<Boolean>> getSeats() {
		return this.seats;
	}

	public void setFuntion(CinemaFunction funtion) {
		this.seats = funtion.getSeats();
		this.date = funtion.getDate();
		this.hour = funtion.getHour();
		this.numSeats = funtion.getNumSeats();

	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
