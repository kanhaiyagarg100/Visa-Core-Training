package com.visa.prj.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.BookingDao;
import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;

@Service
public class BookingService {
	
	@Autowired
	private BookingDao bookingDao;
	
	public List<Booking> getAllBookingsByUser(User user){
		return bookingDao.getAllBookingsOfUser(user);
	}
	
	public List<Hotel> findHotels(String criteria) {
		return bookingDao.findHotels(criteria);
	}
	
	public Hotel getHotelById(long id) {
		return bookingDao.findHotelById(id);
	}
	
	public User getUser(String email, String password) {
		return bookingDao.getUser(email, password);
	}
	@Transactional
	public void makeBooking(User u, Hotel h, Date checkin, Date checkout, Boolean smoking, int no_of_beds) {
		 Booking booking = new Booking();
		 User user= bookingDao.getUser(u.getEmail(), u.getPassword());
		 if(user==null) {
			 user= new User();
			 user.setEmail(u.getEmail());
			 user.setPassword(u.getPassword());
			 user.setUsername(u.getUsername());
		 }
		 booking.setUser(user);
		 booking.setHotel(bookingDao.findHotelById(h.getId()));
		 booking.setCheckinDate(checkin);
		 booking.setCheckoutDate(checkout);
		 booking.setSmoking(smoking);
		 booking.setBeds(no_of_beds);
		 
		 long id= bookingDao.createBooking(booking);
		 System.out.println("Booking with Id "+id+" created!!");
	}

}

