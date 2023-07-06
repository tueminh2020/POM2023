package com.bankguru.account;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonParseException;

public class CustomerDataJson {
	public static CustomerDataJson get(String fileName) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(new File(fileName), CustomerDataJson.class);
	}
	
	@JsonProperty("customerName")
	String customerName;
	
	@JsonProperty("gender")
	String gender;
	
	@JsonProperty("dateOfBirth")
	String dob;
	
	@JsonProperty("address")
	String address;
	
	@JsonProperty("city")
	String city;
	
	@JsonProperty("state")
	String state;
	
	@JsonProperty("pin")
	String pin;
	
	@JsonProperty("phone")
	String phone;
	
	@JsonProperty("email")
	String email;
	
	@JsonProperty("password")
	String password;
	
	public String getcustomerName() {
		return customerName;
	}
	
	public String getgender() {
		return gender;
	}

	public String getDOB() {
		return dob;
	}

	public String getEmail() {
		return email;
	}
	
	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}
	
	public String getPin() {
		return pin;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getAddress() {
		return address;
	}
	

}
