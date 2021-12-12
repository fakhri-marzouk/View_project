package models;

public class Provider implements InterfaceModele , java.io.Serializable {
	
	private String name ;
	private String tel ;
	private String id ;
	private String product ;
	private String address ;
	public Provider(String name, String tel, String id, String product, String address) {
		super();
		this.name = name;
		this.tel = tel;
		this.id = id;
		this.product = product;
		this.address = address;
	}
	
	@Override
	public String getName() {
		return name;
	}
	@Override

	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	@Override

	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override

	public String getProduct() {
		return product;
	}
	@Override

	public void setProduct(String product) {
		this.product = product;
	}
	@Override

	public String getAddress() {
		return address;
	}
	@Override

	public void setAddress(String address) {
		this.address = address;
	}
	

}
