package core;

import java.net.URL;
import java.util.ArrayList;

public class Agent { 
	
	private String id;
	private String firstName;
	private String lastName;
        private String phoneNum;
	private String email;
	private ArrayList<Artist> Represented;
	private ArrayList<Place> faivoritePlaces;
	
	public Agent(String id, String firstName, String lastName, String phoneNum, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
                this.phoneNum = phoneNum;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Artist> getRepresented() {
		return Represented;
	}

	public void setRepresented(ArrayList<Artist> represented) {
		Represented = represented;
	}

	public ArrayList<Place> getFaivoritePlaces() {
		return faivoritePlaces;
	}

	public void setFaivoritePlaces(ArrayList<Place> faivoritePlaces) {
		this.faivoritePlaces = faivoritePlaces;
	}
	

}
