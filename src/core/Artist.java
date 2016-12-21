package core;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

public class Artist {
	
	private String id;
	private String stageName;
	private String biography;
	private String facebook;
	private String email;
	private boolean active;
	private Agent agent;

	public Artist(String id, String stageName, String biography, String facebook, String email, boolean active, Agent agent) {
		super();
		this.id = id;
		this.stageName = stageName;
		this.biography = biography;
		this.facebook = facebook;
		this.email = email;
		this.active = active;
		this.setAgent(agent);
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

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
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

}
