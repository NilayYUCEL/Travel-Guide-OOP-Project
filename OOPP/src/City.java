
import java.util.ArrayList;
import java.util.PriorityQueue;

public class City {
	private String city_name, region, information;
	private int plate, number_of_population;
	private boolean sea;
	private ArrayList<Place> places;
	
	
	public City(String city_name, String region, String information, int plate, int number_of_population, boolean sea,
			ArrayList<Place> places) {
		super();
		this.city_name = city_name;
		this.region = region;
		this.information = information;
		this.plate = plate;
		this.number_of_population = number_of_population;
		this.sea = sea;
		this.places=places;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public int getPlate() {
		return plate;
	}
	public void setPlate(int plate) {
		this.plate = plate;
	}
	public int getNumber_of_population() {
		return number_of_population;
	}
	public void setNumber_of_population(int number_of_population) {
		this.number_of_population = number_of_population;
	}
	public boolean isSea() {
		return sea;
	}
	public void setSea(boolean sea) {
		this.sea = sea;
	}

		
	public ArrayList<Place> getPlaces() {
		return places;
	}
	public void setPlaces(ArrayList<Place> places) {
		this.places = places;
	}
	
	@Override
	public String toString() {
		return "City [city_name=" + city_name + ", region=" + region + ", information=" + information + ", plate="
				+ plate + ", number_of_population=" + number_of_population + ", sea=" + sea + ", places=" + places
				;
	}
	public String displayAllPlaces() {
        String retStr = "";
        for (Place place : places) {
            if (place.getClass().getSimpleName().equalsIgnoreCase("traveltovisit")) {
                retStr += ((TravelToVisit) place).toString();
            } else if (place.getClass().getSimpleName().equalsIgnoreCase("foodanddrink")) {
                retStr += ((FoodAndDrink) place).toString();
            } else if (place.getClass().getSimpleName().equalsIgnoreCase("accommodation")) {
                retStr += ((Accommodation) place).toString();
            }
        }
        return retStr;
    }
	public String searchPlaces(String place_type) {
        String retStr = "";
        for (Place place : places) {
            if (place_type.equalsIgnoreCase(place.getType())) {
                if (place.getClass().getSimpleName().equalsIgnoreCase("traveltovisit"))
                    retStr += ((TravelToVisit) place).toString() + "\n";
                if (place.getClass().getSimpleName().equalsIgnoreCase("foodanddrink"))
                    retStr += ((FoodAndDrink) place).toString() + "\n";
                if (place.getClass().getSimpleName().equalsIgnoreCase("accommodation"))
                    retStr += ((Accommodation) place).toString() + "\n";
            }
        }

        if (retStr.equals(""))
            for (Place place : places) {
                retStr += place.toString();
            }
        return retStr;
    }

}
