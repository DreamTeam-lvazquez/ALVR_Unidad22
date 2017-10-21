package model;

public class Supplier {
	
	
	private String id;
	private String company;
	private String name;
	private String title;
	private String address;
	
	
	public Supplier(String id, String company, String name, String title, String address) {
		super();
		this.id = id;
		this.company = company;
		this.name = name;
		this.title = title;
		this.address = address;
	}
	
	public Supplier() {
		this("", "","","","");		
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", company=" + company + ", name=" + name + ", title=" + title + ", address="
				+ address + "]";
	}

	

}
