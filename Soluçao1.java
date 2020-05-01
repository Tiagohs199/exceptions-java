package Exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import Exceptions.exception.DomainExceptions;

public class Soluçao1 {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Soluçao1(Integer roomNumber, Date checkIn, Date checkOut) {	
		Date date = new Date();
		if (checkIn.before(date)) {
			throw new  DomainExceptions("Check-in must be after today ");
		}
		if(checkOut.before(date)) {
			throw new  DomainExceptions("Check-out must be after today ");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainExceptions( "Error in reservation: check-Out must be after chek-in");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();  //transforma checkin/out em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //converte a varialvel diff para dias
	}
	public void updateDates(Date checkIn, Date checkOut)  {
		Date date = new Date();
		if (checkIn.before(date) || checkOut.before(date)) {
			throw new  DomainExceptions("Date must be after ");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainExceptions( "Error in reservation: check-Out must be after chek-in");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}
	@Override
	public String toString() {
		return "Room= " + roomNumber + ", checkIn = " + sdf.format(checkIn) + 
				", checkOut = " + sdf.format(checkOut)+","+ " Days: "+ duration() ;
	}
	
	

	
	
	

	
}
