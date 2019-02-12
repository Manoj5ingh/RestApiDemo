package com.abyeti.RestApi;

import java.util.*;

public class Superhero {
	static int count=1;
	int id;
	String name;
	List<String> superpower;
	double ratings;
	public Superhero(String name, List<String> superpower, double ratings) {
		super();
		this.id = count;
		count=count+1;
		this.name = name;
		this.superpower = superpower;
		this.ratings = ratings;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getSuperpower() {
		return superpower;
	}
	public void setSuperpower(List<String> superpower) {
		this.superpower = superpower;
	}
	public double getRatings() {
		return ratings;
	}
	public void setRatings(double ratings) {
		this.ratings = ratings;
	}
}
