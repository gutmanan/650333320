package entity;

import java.util.ArrayList;
import java.sql.Date;
import javax.swing.ImageIcon;

public class User {
	
	private String userAlphaCode;
	private String firstName;
	private String lastName;
	private String nickname;
	private Date birthday;
	private String email;
        private String password;
	private ImageIcon image;
	private ArrayList<Artist> artists;
	
	public User(String id, String firstName, String lastName, String nickname, Date birthday, String email, String password) {
		super();
		this.userAlphaCode = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickname = nickname;
		this.birthday = birthday;
		this.email = email;
                this.password = password;
	}

	public String getUserAlphaCode() {
		return userAlphaCode;
	}

	public void setUserAlphaCode(String userAlphaCode) {
		this.userAlphaCode = userAlphaCode;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public ArrayList<Artist> getArtists() {
		return artists;
	}

	public void setArtists(ArrayList<Artist> artists) {
		this.artists = artists;
	}
	

}
