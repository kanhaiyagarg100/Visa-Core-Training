package com.visa.prj.client;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.User;
import com.visa.prj.service.BookingService;

public class BookingClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
		// ApplicationContext ctx= new ClassPathXmlApplicationContext("app.xml")
		
		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		BookingService bs= ctx.getBean("bookingService",BookingService.class);
		
		User u=new User();
		u.setEmail("a@visa.com");
		u.setPassword("unknown");
		u.setUsername("a");
		
		Hotel hotel= bs.getHotelById(4);
		
		bs.makeBooking(u, hotel, new Date(), new Date(), true, 2);
		
		List<Booking> bookings= bs.getAllBookingsByUser(u);
		for(Booking b: bookings) {
			System.out.println("Booking Id is "+b.getId());
		}
		
		List<Hotel> hotels= bs.findHotels("NY");
		for(Hotel h: hotels) {
			System.out.println("Hotel name is "+h.getName());
		}
	}

}
