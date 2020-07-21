package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private int roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(){
	
	}
	
	public Reservation(int roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}
	
	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
	}
	
	public String UpdateDate(Date checkin, Date checkout) {
		Date now = new Date();
		if(checkin.before(now)||checkout.before(now)) {
			return "Error in reservation: dates must be in the future";
		}
		if(!checkout.after(checkin)) {
			return "Error in reservation: Checkout must be after Checkin date";
		}
		
		this.checkin = checkin;
		this.checkout = checkout;
		return null;
	}
	
	public String toString() {
		return "Reservation: Room "+getRoomNumber()+", check-in: "+sdf.format(checkin)+", check-out: "+sdf.format(checkout)+", "+duration()+" nights";
	}
}
