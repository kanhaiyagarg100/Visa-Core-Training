package com.visa.prj.entity;
/**
 * This is a class to represent account business data.
 * This allows to credit and debit amount.
 * 
 * @author root
 * version 1.0
 */

public class Account {
	private double balance; //state of object --> Instance variables
	
	private static int count;
	
	public Account() {
		count++;
	}
	
	/**
	 * method to credit amount into account
	 * @param amt to be credited
	 */
	public void deposit(double amt) { // public void deposit(Account this, double amt)
		this.balance+= amt;				  // this.balance += amt
	}
	
	/** 
	 * method returns the current balance in account
	 * @return the current balance
	 */
	public double getBalance() {
		return balance;
	}
	
	public static int getCount() {
		return count;
	}
	
}
