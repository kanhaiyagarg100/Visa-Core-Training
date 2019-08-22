package com.visa.prj.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.visa.prj.entity.Booking;
import com.visa.prj.entity.Hotel;
import com.visa.prj.entity.SearchCriteria;
import com.visa.prj.entity.User;
import com.visa.prj.service.BookingService;

@Controller
public class HotelController {
	@Autowired
	private BookingService bs;
	
	@RequestMapping("search.do")
	public ModelAndView getHotels() {
		ModelAndView mav= new ModelAndView();
		mav.setViewName("searchForm.jsp");
		mav.addObject("searchCriteria", new SearchCriteria());
		return mav;
	}
	
	@RequestMapping("hotels.do")
	public ModelAndView findHotels(@ModelAttribute(name="searchCriteria") SearchCriteria criteria) {
		ModelAndView mav= new ModelAndView();
		mav.setViewName("searchResults.jsp");
		List<Hotel> hotelList= bs.findHotels(criteria.getSearchString());
		mav.addObject("hotelList", hotelList);
		mav.addObject("searchCriteria", criteria);
		return mav;
	}
	
	@RequestMapping("viewHotel.do")
	public ModelAndView showHotel(@RequestParam(name="id") int id) {
		ModelAndView mav= new ModelAndView();
		Hotel hotel = bs.getHotelById(id);
		mav.setViewName("showHotel.jsp");
		mav.addObject("hotel", hotel);
		return mav;
	}
	
	@RequestMapping("bookingForm.do")
	public ModelAndView book(@ModelAttribute(name="hotel") Hotel hotel) {
		ModelAndView mav= new ModelAndView();
		Booking booking= new Booking();
		booking.setHotel(hotel);
		mav.addObject("user", new User());
		mav.addObject("booking", booking);
		mav.setViewName("bookingForm.jsp");
		return mav;
	}
}
