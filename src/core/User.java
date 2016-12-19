package core;

import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

public class User {
	
	private String id;
	private String firstName;
	private String lastName;
	private String nickname;
	private Date birthday;
	private URL email;
	private Image image;
	private ArrayList<Artist> artists;
	
	public User(String id, String firstName, String lastName, String nickname, Date birthday, URL email, Image image,
			ArrayList<Artist> artists) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickname = nickname;
		this.birthday = birthday;
		this.email = email;
		this.image = image;
		this.artists = artists;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public URL getEmail() {
		return email;
	}

	public void setEmail(URL email) {
		this.email = email;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public ArrayList<Artist> getArtists() {
		return artists;
	}

	public void setArtists(ArrayList<Artist> artists) {
		this.artists = artists;
	}
	

}
