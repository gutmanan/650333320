package core;

import java.net.URL;
import java.util.ArrayList;

public class Place {
	
	private int id;
	private String name;
	private Address address;
	private URL email;
	private String phoneNumber;
	private URL location;
	private int maxCapacity;
	private ArrayList<Show> shows;
	
	public Place(int id, String name, Address address, URL email, String phoneNumber, URL location, int maxCapacity,
			ArrayList<Show> shows) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.location = location;
		this.maxCapacity = maxCapacity;
		this.shows = shows;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public URL getEmail() {
		return email;
	}

	public void setEmail(URL email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public URL getLocation() {
		return location;
	}

	public void setLocation(URL location) {
		this.location = location;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public ArrayList<Show> getShows() {
		return shows;
	}

	public void setShows(ArrayList<Show> shows) {
		this.shows = shows;
	}
	

}
