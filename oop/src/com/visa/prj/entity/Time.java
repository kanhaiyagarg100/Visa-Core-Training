package com.visa.prj.entity;

public class Time {
	private int hours;
	private int min;
	
	public Time() {
	}
	public Time(int hours, int minutes) {
		this.hours = hours;
		this.min = minutes;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int minutes) {
		this.min = minutes;
	}
	
	public static Time addtime(Time t1, Time t2) {
		int min= t1.getHours()*60 + t2.getHours()*60 + t1.getMin() + t2.getMin();
		return new Time(min/60, min%60);
	}
	
	public Time addtime(Time t2) {
		int min= this.getHours()*60 + t2.getHours()*60 + this.getMin() + t2.getMin();
		return new Time(min/60, min%60);
	}
}
