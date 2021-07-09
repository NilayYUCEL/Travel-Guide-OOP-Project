
public class Address {

	private String city;
	private String town;
	private String address;

	public Address(String city, String town, String address) {
		this.city = city;
		this.town = town;
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public String toString() {
		return address + " " + town + " / " + city;
	}

}
