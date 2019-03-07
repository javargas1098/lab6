/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.cinema.model;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 * @author cristian
 */
public class Movie {
	private AtomicReference<String> name;
	private AtomicReference<String> gen;
	private AtomicInteger seats;

	public Movie() {
	}

	public Movie(String name, String gen) {
		setName(name);
		setGenre(gen);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public String getGenre() {
		return gen.get();
	}

	public void setGenre(String gen) {
		this.gen.set(gen);
	}

	public int getSeats() {
		return seats.get();
	}

	public void setSeats(int seats) {
		this.seats.set(seats);
	}
}
