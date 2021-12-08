package models;

public class customer {
	
	private String id_customer;
	private String cin ;
	private String phone ;
	private String name;
	private String address;
	
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getId() {
		return id_customer;
	}
	public void setId(String id) {
		this.id_customer = id;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public customer(String id, String cin, String name, String phone, String address) {
		this.id_customer = id;
		this.cin = cin;
		this.phone = phone;
		this.name = name;
		this.address = address;
	}
	

}
