package models;

import java.sql.Date;

public class order {
	
	String CIN ;
	String name ;
	String phone ;
	String address ;
	String total_price ;
	Date date_command ;
	
	
	public order(String cIN, String name, String phone, String address, String total_price, Date date_command) {
		super();
		CIN = cIN;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.total_price = total_price;
		this.date_command = date_command;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTotal_price() {
		return total_price;
	}
	public void setTotal_price(String total_price) {
		this.total_price = total_price;
	}
	public Date getDate_command() {
		return date_command;
	}
	public void setDate_command(Date date_command) {
		this.date_command = date_command;
	}
	
	
}
