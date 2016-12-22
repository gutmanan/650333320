package core;

import java.net.URL;
import java.util.ArrayList;

public class Place {
	
	private int id;
	private String name;
	private Address address;
	private String email;
	private String phoneNumber;
	private String location;
	private int maxCapacity;
        private int representativeID;
	
	public Place(int id, String name, Address address, String email, String phoneNumber, String location, int maxCapacity, int representativeID) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.location = location;
		this.maxCapacity = maxCapacity;
                this.representativeID = representativeID;
	}

        public int getRepresentativeID() {
            return representativeID;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
}
