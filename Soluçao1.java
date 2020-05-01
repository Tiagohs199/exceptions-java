package Exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Soluçao1 {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Soluçao1(Integer roomNumber, Date checkIn, Date checkOut) {	
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
	public String updateDates(Date checkIn, Date checkOut) {
		Date date = new Date();
		if (checkIn.before(date) || checkOut.before(date)) {
			return "Date must be after ";
		}
		if (!checkOut.after(checkIn)) {
			return "Error in reservation: check-Out must be after chek-in";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}

	@Override
	public String toString() {
		return "Room= " + roomNumber + ", checkIn = " + sdf.format(checkIn) + 
				", checkOut = " + sdf.format(checkOut)+","+ " Days: "+ duration() ;
	}
	
	

	
	
	

	
}
