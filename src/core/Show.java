package core;

import java.util.ArrayList;
import java.util.Date;

public class Show {
	
	private int id;
	private Date date;
	private E_STATUS isCanceled;
	private Date createDate;
	private int ticketPrice;
	private int minAge;
	private Artist mainArtist;
        private Place place;
        private Agent creatAgent;
	
	public Show(int id, Artist mainArtist, Date date, Place place, E_STATUS isCanceled, Date createDate, int ticketPrice, int minAge, Agent creatAgent) {
            super();
            this.id = id;
            this.date = date;
            this.isCanceled = isCanceled;
            this.createDate = createDate;
            this.ticketPrice = ticketPrice;
            this.minAge = minAge;
            this.mainArtist = mainArtist;
            this.place = place;
            this.creatAgent = creatAgent;
	}

        public Place getPlace() {
            return place;
        }

        public Agent getCreatAgent() {
            return creatAgent;
        }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public E_STATUS getIsCanceled() {
		return isCanceled;
	}

	public void setIsCanceled(E_STATUS isCanceled) {
		this.isCanceled = isCanceled;
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
