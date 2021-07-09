import java.util.Comparator;

public class PriceComparator implements Comparator<Place> {

	// Order for Priority queue
	@Override
	public int compare(Place a, Place b) {
		// TODO Auto-generated method stub

		int place_a;
		int place_b;
		if (a.getType().equalsIgnoreCase("TravelToVisit")) {
			place_a = ((TravelToVisit) a).getPrice();
			place_b = ((TravelToVisit) b).getPrice();
		} else if(a.getType().equalsIgnoreCase("FoodAndDrink")) {

            String a_place = ((FoodAndDrink) a).getPrice_range();
            int x=0;
            for (int i = 0; i < a_place.length(); i++) {
                x+=Integer.valueOf(a_place.charAt(i));
            }
            place_a=x;
            String b_place = ((FoodAndDrink) b).getPrice_range();
            x=0;
            for (int i = 0; i < b_place.length(); i++) {
                x+=Integer.valueOf(b_place.charAt(i));
            }
            place_b=x;

        }
        else {
            String a_place = ((Accommodation) a).getPrice_range();
            int x=0;
            for (int i = 0; i < a_place.length(); i++) {
                x+=Integer.valueOf(a_place.charAt(i));
            }
            place_a=x;
            String b_place = ((Accommodation) b).getPrice_range();
            x=0;
            for (int i = 0; i < b_place.length(); i++) {
                x+=Integer.valueOf(b_place.charAt(i));
            }
            place_b=x;
        }

		if (place_a < place_b) {
			return -1;
		} else if (place_a > place_b) {
			return 1;
		}

		return 0;
	}

}

