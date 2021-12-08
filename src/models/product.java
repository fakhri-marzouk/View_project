package models;

public class product {

	private String id;
	private String price;
	private String name;
	private String quantity;
	
	public product(String id, String name,String price, String quantity) {
		super();
		this.id = id;
		this.price = price;
		this.name = name;
		this.quantity = quantity;
	}
	public String getId() {
		return id;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
}