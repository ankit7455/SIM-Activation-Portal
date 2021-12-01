package com.simactivation.customerMS.validation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ValidateUpdateDetail {
		@NotNull(message = "pincode can't be NULL")
		@Min(99999)
		@Max(10000000)
		private long pincode;
		@NotNull(message = "address can't be NULL")
		@Pattern(regexp = "^[a-zA-Z ]{1,25}$",message = "Address length 25 digit excceded")
		private String address;
		@NotNull(message = "city cant be NULL")
		@Pattern(regexp = "^[a-zA-Z ]{1,25}$",message = "City/State should not contain any special characters except space")
		private String city;
		@NotNull(message = "state can't be NULL")
		@Pattern(regexp = "^[a-zA-Z ]{1,25}$",message = "City/State should not contain any special characters except space")
		private String state;
		
		
		public ValidateUpdateDetail(
				@NotNull(message = "pincode can't be NULL") @Pattern(regexp = "[0-9]{6}", message = "pincode should be 6 digit") int pincode,
				@NotNull(message = "address can't be NULL") @Pattern(regexp = "^[a-zA-Z ]{1,25}$", message = "Address length 25 digit excceded") String address,
				@NotNull(message = "city cant be NULL") @Pattern(regexp = "^[a-zA-Z ]{1,25}$", message = "City/State should not contain any special characters except space") String city,
				@NotNull(message = "state can't be NULL") @Pattern(regexp = "^[a-zA-Z ]{1,25}$", message = "City/State should not contain any special characters except space") String state) {
			super();
			this.pincode = pincode;
			this.address = address;
			this.city = city;
			this.state = state;
		}
		public long getPincode() {
			return pincode;
		}
		public void setPincode(long pincode) {
			this.pincode = pincode;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		@Override
		public String toString() {
			return "ValidateUpdateDetail [pincode=" + pincode + ", address=" + address + ", city=" + city + ", state="
					+ state + "]";
		}
		
		
		
}