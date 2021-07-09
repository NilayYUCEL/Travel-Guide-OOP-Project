
import java.util.ArrayList;
import java.util.Arrays;

public class FoodAndDrink extends Place {
	
	private String price_range;
	private boolean[] facilities;
	private ArrayList<String[]> comments;
	private int rates;
	
	public FoodAndDrink(String name, Address address, Phone phone, String type, String price_range,
			boolean[] facilities,int rates) {
		super(name,type, address, phone);
		this.price_range = price_range;
		this.facilities = facilities;
		this.comments = new ArrayList<String[]>();
		this.rates = rates;
	}
	

	public ArrayList<String[]> getComments() {
		return comments;
	}


	public void setComments(ArrayList<String[]> comments) {
		this.comments = comments;
	}


	public String getPrice_range() {
		return price_range;
	}

	public void setPrice_range(String price_range) {
		this.price_range = price_range;
	}

	public boolean[] getFacilities() {
		return facilities;
	}

	public void setFacilities(boolean[] facilities) {
		this.facilities = facilities;
	}




	@Override
    public String toString() {
        return "\nFoodAndDrink [ " + super.toString() + " price_range=" + price_range + ", facilities=" + Arrays.toString(facilities)
        + ", comments=" + comments + ", rate=" + rates + "]\n";
    }


	public int getRates() {
		return rates;
	}


	public void setRates(int rates) {
		this.rates = rates;
	}



	public void addComment(String userId, String comment) {
        String[] comment_array = new String[2];
        comment_array[0] = userId;
        comment_array[1] = comment;
        comments.add(comment_array);
    }

	
}
