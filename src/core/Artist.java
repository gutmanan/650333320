package core;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

public class Artist {
	
	private String id;
	private String stageName;
	private String biography;
	private URL facebook;
	private URL email;
	private boolean active;
	private Agent agent;
	private ArrayList<Show> shows;
	private ArrayList<Artist> Appreciated;

	public Artist(String id, String stageName, String biography, URL facebook, URL email, boolean active, Agent agent,
			ArrayList<Show> shows, ArrayList<Artist> appreciated) {
		super();
		this.id = id;
		this.stageName = stageName;
		this.biography = biography;
		this.facebook = facebook;
		this.email = email;
		this.active = active;
		this.setAgent(agent);
		this.shows = shows;
		setAppreciated(appreciated);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public URL getFacebook() {
		return facebook;
	}

	public void setFacebook(URL facebook) {
		this.facebook = facebook;
	}

	public URL getEmail() {
		return email;
	}

	public void setEmail(URL email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public ArrayList<Artist> getAppreciated() {
		return Appreciated;
	}

	public void setAppreciated(ArrayList<Artist> appreciated) {
		Appreciated = appreciated;
	}
	
	public void updateInfo(String name, String bio, URL fb, URL eml) {
		if (name != null) {
			setStageName(name);
		}
		if (bio != null) {
			setBiography(bio);
		}
		if (fb != null) {
			setFacebook(fb);
		}
		if (eml != null) {
			setEmail(eml);
		}
	}
	
	public boolean checkAvailability(Date date) {
		if (shows != null) {
			for (Show s : shows) {
				
			}
		}
		return false;
	}

}
