package core;

import java.net.URL;
import java.util.ArrayList;

public class OpenPlace extends Place{
	
	private E_COVERS cover;
	private boolean withSeats;
	private boolean withPlatform;
	private boolean withAmplification;
	private boolean withToilet;

        public OpenPlace(E_COVERS cover, boolean withSeats, boolean withPlatform, boolean withAmplification, boolean withToilet, int id, String name, Address address, String email, String phoneNumber, String location, int maxCapacity, int representativeID) {
            super(id, name, address, email, phoneNumber, location, maxCapacity, representativeID);
            this.cover = cover;
            this.withSeats = withSeats;
            this.withPlatform = withPlatform;
            this.withAmplification = withAmplification;
            this.withToilet = withToilet;
        }
	
	public E_COVERS getCover() {
		return cover;
	}

	public void setCover(E_COVERS cover) {
		this.cover = cover;
	}

	public boolean isWithSeats() {
		return withSeats;
	}

	public void setWithSeats(boolean withSeats) {
		this.withSeats = withSeats;
	}

	public boolean isWithPlatform() {
		return withPlatform;
	}

	public void setWithPlatform(boolean withPlatform) {
		this.withPlatform = withPlatform;
	}

	public boolean isWithAmplification() {
		return withAmplification;
	}

	public void setWithAmplification(boolean withAmplification) {
		this.withAmplification = withAmplification;
	}

	public boolean isWithToilet() {
		return withToilet;
	}

	public void setWithToilet(boolean withToilet) {
		this.withToilet = withToilet;
	}


}
