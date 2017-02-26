package entity;

public class Place {
	
	private int placeNumber;
	private String name;
	private Address address;
	private String email;
	private String phoneNumber;
	private String location;
	private int maxCapacity;
	
	public Place(int id, String name, Address address, String email, String phoneNumber, String location, int maxCapacity) {
		super();
		this.placeNumber = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.location = location;
		this.maxCapacity = maxCapacity;

	}
        
        public Place(int id) {
            this.placeNumber = id;
        }

	public int getPlaceNumber() {
		return placeNumber;
	}

	public void setPlaceNumber(int placeNumber) {
		this.placeNumber = placeNumber;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

    public String getLocation() {
        return location;
    }

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
}
