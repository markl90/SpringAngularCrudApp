package com.qa.server2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.micrometer.core.lang.NonNull;


@Entity
public class Account {
	
		@Id @GeneratedValue
	    private Long id;
	    private String firstName;
	    private String lastName;
	    private int accountNumber;
	    
	    private static int accNum = 456;
	    
	    public Account(String firstName, String lastName) {
	    	this.firstName = firstName;
	    	this.lastName = lastName;
	    	this.accountNumber = accNum;
	    }
	    
	    public Account() {}
	      
	    
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public Long getId() {
			return id;
		}
		
		public int getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(int accountNumber) {
			this.accountNumber = accountNumber;
		}
		@Override
		public String toString() {
			return "Account [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
		}
		
}		
