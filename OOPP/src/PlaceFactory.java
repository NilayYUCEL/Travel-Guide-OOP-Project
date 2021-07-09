
public class PlaceFactory  {

	
	public Place getPlace(String type, String name, Address address, Phone phone, String season, String information,
			int price, int distance_to_center, boolean[] facilities, int rates, String price_range, int star) {
		if (type.equalsIgnoreCase("TravelToVisit")) {
			return new TravelToVisit(name, type, address, phone, season, information, price, distance_to_center,
					facilities, rates);
		} else if (type.equalsIgnoreCase("FoodAndDrink")) {
			return new FoodAndDrink(name, address, phone, type, price_range, facilities, rates);
		} else if (type.equalsIgnoreCase("Accommodation")) {
			return new Accommodation(name, type, address, phone, price_range, star);
		} else {
			return null;
		}
	}

}
