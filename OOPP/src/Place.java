
public abstract class Place {
	private String name;
	private String type;
	private Address address;
	private Phone phone;

	public Place(String name, String type, Address address, Phone phone) {
		this.name = name;
		this.type = type;
		this.address = address;
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	@Override
	  public String toString() {
        return " Place [name=" + name + " type:" + type + " " +address.toString() + " " + phone.toString() + "] ";
    }

}
