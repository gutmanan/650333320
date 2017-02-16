package entity;

import java.util.ArrayList;
import java.util.Date;

public class Show {
	
	private int showNumber;
	private Date showDate;
	private E_STATUS status;
	private Date createDate;
	private int ticketPrice;
	private int minAge;
	private Artist mainArtist;
        private Place place;
        private Agent createAgent;
	
	public Show(int id, Artist mainArtist, Date date, Place place, E_STATUS isCanceled, Date createDate, int ticketPrice, int minAge, Agent creatAgent) {
            super();
            this.showNumber = id;
            this.showDate = date;
            this.status = isCanceled;
            this.createDate = createDate;
            this.ticketPrice = ticketPrice;
            this.minAge = minAge;
            this.mainArtist = mainArtist;
            this.place = place;
            this.createAgent = creatAgent;
	}

        public Place getPlace() {
            return place;
        }

        public Agent getCreateAgent() {
            return createAgent;
        }

	public int getShowNumber() {
		return showNumber;
	}

	public void setShowNumber(int showNumber) {
		this.showNumber = showNumber;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public E_STATUS getStatus() {
		return status;
	}

	public void setStatus(E_STATUS status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public Artist getMainArtist() {
		return mainArtist;
	}

	public void setMainArtist(Artist mainArtist) {
		this.mainArtist = mainArtist;
	}
}
