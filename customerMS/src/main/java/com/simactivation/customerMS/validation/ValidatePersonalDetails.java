package com.simactivation.customerMS.validation;


import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class ValidatePersonalDetails {
	@Pattern(regexp = "^[a-zA-Z]{1,10}$", message = "Firstname/Lastname should be maximum of 15 characters")
	private String firstName;
	@Pattern(regexp = "^[a-zA-Z]{1,10}$" , message = "Firstname/Lastname should be maximum of 15 characters")
	private String lastName;
	@Email(message = "Email Address format not allow")
	private String emailAddress;
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
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	@Override
	public String toString() {
		return "ValidatePersonalDetails [firstName=" + firstName + ", lastName=" + lastName + ", emailAddress="
				+ emailAddress + "]";
	}
	
}