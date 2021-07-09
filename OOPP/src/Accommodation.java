

public class Accommodation extends Place {
	
	private String price_range;
	private int star;
	
	public Accommodation(String name, String type, Address address, Phone phone, String price_range, int star) {
		super(name, type, address, phone);
		this.price_range = price_range;
		this.star = star;
	}

	public String getPrice_range() {
		return price_range;
	}

	public void setPrice_range(String price_range) {
		this.price_range = price_range;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	@Override
	public String toString() {
        return "\nAccommodation [ " + super.toString() + " price_range=" + price_range + ", star=" + star + "]\n";
    }
	

}
