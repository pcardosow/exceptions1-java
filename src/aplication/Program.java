package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Room number: ");
		int roomNumber = sc.nextInt(); 
		System.out.println("CheckIn: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("CheckOut: ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Checkout must be after Checkin date");
		}
		else {
	    Reservation reservation = new Reservation (roomNumber,checkIn,checkOut);
	    System.out.println(reservation);
		
		
		System.out.println("Enter data to update the reservation: ");
		System.out.println("CheckIn: ");
		checkIn = sdf.parse(sc.next());
		System.out.println("CheckOut: ");
		checkOut = sdf.parse(sc.next());
		
		Date now = new Date();
		if(checkIn.before(now)||checkOut.before(now)) {
			System.out.println("Error in reservation: dates must be in the future");
		}
		else if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Checkout must be after Checkin date");
		}
		else {
			reservation.UpdateDate(checkIn,checkOut);
			System.out.println(reservation);
		}
	}

}
}