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

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Checkout must be after Checkin date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation);

			System.out.println("Enter data to update the reservation: ");
			System.out.println("CheckIn: ");
			checkIn = sdf.parse(sc.next());
			System.out.println("CheckOut: ");
			checkOut = sdf.parse(sc.next());

			String error = reservation.UpdateDate(checkIn, checkOut);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} 
			
			else {
				System.out.println(reservation);
			}

		}
		sc.close();
	}

}
