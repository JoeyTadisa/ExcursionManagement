package com.thuexcursion.crud.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thuexcursion.crud.model.Booking;
import com.thuexcursion.crud.repository.BookingRepository;

/*import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;*/

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository repository;
	
	public Booking saveBooking(Booking booking) {
		return repository.save(booking);
	}
	
	public List<Booking> saveBookings(List<Booking> bookings) {
		return repository.saveAll(bookings);
	}
	
	public List<Booking> getBookings(){
		return repository.findAll();
	}
	
	
	public Booking getBookingById(int id){
		return repository.findById(id).orElse(null);
	}

	//login
	/*public Excursion getExcursionByUsername(String username){
		return repository.findByUsername(username);
	}*/
	
	public String deleteBooking(int id) {
		 repository.deleteById(id);
		 return "excursion removed!" + id;
	}

	public List<Booking> getBookingByUserId(int user_id) {
		return repository.findByUserId(user_id);
	}


	/*public Booking updateExcursion(Booking booking) {
		Booking existingExcursion = repository.findById(booking.getId()).orElse(booking);
		 existingExcursion.setDescription(booking.getDescription());
		 existingExcursion.setDate_written(excursion.getDate_written());
		 existingExcursion.setMax_participants(excursion.getMax_participants());
		 existingExcursion.setReg_deadline(excursion.getReg_deadline());
		 existingExcursion.setDereg_deadline(excursion.getDereg_deadline());
		 existingExcursion.setMeeting_details(excursion.getMeeting_details());
		 existingExcursion.setTitle(excursion.getTitle());
		 existingExcursion.setMeeting_details(excursion.getMeeting_details());
		 existingExcursion.setRequested_by(excursion.getRequested_by());
		 return repository.save(existingExcursion);
	} */
	
	
	public Booking deregisterBooking(int id, boolean status) {		
		Booking existingBooking = repository.findById(id).orElse(null);
		existingBooking.setIs_deregistered(status);
		//existingBooking.setDate_deregistered(null);
		return repository.save(existingBooking);
	}

	


}
