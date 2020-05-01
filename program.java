package Exceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class program {
	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Date date = new Date();
		
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());	
		Soluçao1 reservation = new Soluçao1(number,checkIn,checkOut);
		System.out.println("Reservation: "+ reservation);
	
		
		System.out.println("Enter data to update the reservation: ");
		System.out.print("Check-in date (dd/MM/yyyy): ");
		checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		checkOut = sdf.parse(sc.next());

		if (reservation.updateDates(checkIn, checkOut) == null) {
			
			System.out.println("Reservation: " + reservation);
		}else{
			System.out.println(reservation.updateDates(checkIn, checkOut));
		}
		
		sc.close();
	}
}
