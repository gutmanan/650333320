package entity;

import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

public class Artist {
	
	private String artistAlphaCode;
	private String stageName;
	private String biography;
	private String facebook;
	private String email;
	private boolean isActive;
	private Agent agent;
        private Image signatrue;

	public Artist(String id, String stageName, String biography, String facebook, String email, boolean active, Agent agent,Image image) {
            super();
            this.artistAlphaCode = id;
            this.stageName = stageName;
            this.biography = biography;
            this.facebook = facebook;
            this.email = email;
            this.isActive = active;
            this.setAgent(agent);
            this.signatrue = image;
	}
        
        public Artist(String id) {
            this.artistAlphaCode = id;
        }

	public String getArtistAlphaCode() {
		return artistAlphaCode;
	}

	public void setArtistAlphaCode(String artistAlphaCode) {
		this.artistAlphaCode = artistAlphaCode;
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

	public boolean isIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}
        
        public Image getSignatrue() {
		return signatrue;
	}

	public void setImage(Image image) {
		this.signatrue = image;
	}

}
