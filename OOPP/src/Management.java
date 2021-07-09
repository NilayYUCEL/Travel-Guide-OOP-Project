
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Management {

	// This lists keep the information of the text files
	public static ArrayList<City> cities;
	public static ArrayList<Person> users;
	public static ArrayList<Place> places;
	public static ArrayList<String[]> comments;
	public static ArrayList<Place> search;
	public static PriorityQueue<Place> places_q;
	public static PriorityQueue<Place> temp;
	
	// This array keep the information of the online user
	public String[] logged = new String[3];
	public boolean isLogged;

	// This constructor creates new ArrayLists required to hold the information in
	// the text files.
	public Management() throws IOException {
		cities = new ArrayList<City>();
		users = new ArrayList<Person>();
		places = new ArrayList<Place>();
		comments = new ArrayList<String[]>();

		readFile();

		logged[0] = "User";
		logged[1] = "1";
		logged[2] = "denemedeneem";

		// System.out.println(users.toString());

	}
	
	//This method use for create a PlaceFactory according to Factory Design Patern
	public Place FactoryPatternDemo(String type, String name, Address address, Phone phone, String season,
			String information, int price, int distance_to_center, boolean[] facilities, int rates, String price_range,
			int star) {

		PlaceFactory placeFactory = new PlaceFactory();
		Place place = placeFactory.getPlace(type, name, address, phone, season, information, price, distance_to_center,
				facilities, rates, price_range, star);
		return place;
	}
	
	// All text files are read and evaluated
	// The relevant object is created and stored in the list
	public void readFile() throws IOException {

		// COMMENTS

		File fileDir = new File("comment.txt");
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));
		String str1 = in.readLine();
		while ((str1 = in.readLine()) != null) {
			String[] comArr = str1.split(";");
			comments.add(comArr);
		}
		in.close();

		// PLACES

		fileDir = new File("places.txt");
		in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));
		String str3;
		Address address;
		Phone phone;

		str3 = in.readLine();

		while ((str3 = in.readLine()) != null) {
			boolean[] facilities = new boolean[5];
			String[] split_str = str3.split(";");

			if (!split_str[2].equals("")) {
				String[] split_address = split_str[2].split(",");
				address = new Address(split_address[2], split_address[1], split_address[0]);
			} else
				address = new Address("", "", "");

			if (!split_str[3].equals("")) {
				String[] split_phone = split_str[3].split("-");
				phone = new Phone(split_phone[0], split_phone[1], split_phone[2]);
			} else
				phone = new Phone("", "", "");

			String[] split_facilites;
			Place place;
			int price = 0, distance_to_center = 0;
			String price_range = "";

			if (!split_str[0].equals("Accommodation")) {
				split_facilites = split_str[8].split(",");
				for (int i = 0; i < split_facilites.length; i++) {
					if (split_facilites[i].equals("no"))
						facilities[i] = false;
					else if (split_facilites[i].equals("yes"))
						facilities[i] = true;
				}
			}

			if (split_str[0].equals("TravelToVisit")) {
				price = Integer.valueOf(split_str[6]);
				distance_to_center = Integer.valueOf(split_str[7]);

			}

			place = FactoryPatternDemo(split_str[0], split_str[1], address, phone, split_str[4], split_str[5],
					price, distance_to_center, facilities, Integer.valueOf(split_str[9]), split_str[6],
					Integer.valueOf(split_str[9]));

			for (int i = 0; i < comments.size(); i++) {
				if (comments.get(i)[0].contentEquals(place.getName())) {
					if (split_str[0].equalsIgnoreCase("TravelToVisit"))
						((TravelToVisit) place).addComment((comments.get(i)[1]), comments.get(i)[2]);
					else if (split_str[0].equalsIgnoreCase("FoodAndDrink"))
						((FoodAndDrink) place).addComment((comments.get(i)[1]), comments.get(i)[2]);
				}
			}
			places.add(place);

		}
		in.close();

		// PERSON
	
		
		 

		fileDir = new File("person.txt");
		in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));
		String str2 = in.readLine();
		while ((str2 = in.readLine()) != null) {
			String[] personArray = str2.split(";");
			String[] interestsar = null;

			if (personArray[0].equals("user")) {
				interestsar = personArray[8].split(",");
			}
			ArrayList<String> interests = new ArrayList<String>();
			if (personArray[0].equals("user")) {
				for (int i = 0; i < interestsar.length; i++) {
					interests.add(interestsar[i]);
				}
			}

			ArrayList<Place> fav_places = new ArrayList<Place>();
			if (personArray.length == 10) {
				String[] fav_placesar = null;
				if (personArray[0].equals("user"))
					fav_placesar = personArray[9].split(",");
				if (personArray[0].equals("user")) {
					for (int i = 0; i < fav_placesar.length; i++) {
						for (int j = 0; j < places.size(); j++) {
							if (fav_placesar[i].equalsIgnoreCase(places.get(j).getName())) {
								fav_places.add(places.get(j));
							}
						}
					}
				}
			} else {
				fav_places = null;
			}

			String[] phones = null;
			if (personArray[0].equals("user"))
				phones = personArray[5].split("-");
			String[] address1 = null;
			if (personArray[0].equals("user"))
				address1 = personArray[7].split(",");
			if (personArray[0].equalsIgnoreCase("admin")) {
				PersonAbstractFactory AdminFactory = PersonFactoryProducer.getFactory("Admin");
				Admin admin=AdminFactory.getAdmin(personArray[1], personArray[2], personArray[3], personArray[4]);
				users.add(admin);}
			else if (personArray[0].equalsIgnoreCase("user")) {
				PersonAbstractFactory UserFactory = PersonFactoryProducer.getFactory("User");
				User user=UserFactory.getUser(Integer.valueOf(personArray[6]), personArray[1], personArray[2], personArray[3],
						personArray[4], new Phone(phones[0], phones[1], phones[2]),
						new Address(address1[2], address1[1], address1[0]), interests, fav_places);
				users.add(user);
}
		}
		in.close();

		// CÝTY

		ArrayList<Place> place_city;
		fileDir = new File("city.txt");
		in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));
		String str = in.readLine();
		while ((str = in.readLine()) != null) {
			String[] arr = str.split(";");
			String information_city = "Plat: " + arr[0] + "\nName: " + arr[1] + "\nArea: " + arr[2] + "\nPopulation: "
					+ arr[3] + "\nPopulation Density: " + arr[4] + "\nCenter: " + arr[5] + "\nCenter Population: "
					+ arr[6] + "\nRegion: " + arr[7] + "\nSea: " + arr[8];
			Boolean sea;
			if (arr[8] == "yes")
				sea = true;
			else
				sea = false;

			place_city = new ArrayList<Place>();
			for (int j = 0; j < places.size(); j++) {
				if (arr[1].equalsIgnoreCase(places.get(j).getAddress().getCity())) {
					place_city.add(places.get(j));

				}
			}

			cities.add(new City(arr[1], arr[7], information_city, Integer.valueOf(arr[0]), Integer.valueOf(arr[3]), sea,
					place_city));

		}
		in.close();

		// System.out.println(cities.toString());

	}

	// Mail and password are checked
	// If true, the logged[] array is filled in
	public boolean logIn(String mail, String password) {
		boolean flag = false;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getClass().getSimpleName().equalsIgnoreCase("user")) {
				if (mail.equals(((User) users.get(i)).getMail())
						&& password.equals(((User) users.get(i)).getPassword())) {
					isLogged = true;
					logged[0] = users.get(i).getClass().getSimpleName();
					logged[1] = String.valueOf(((User) users.get(i)).getUser_id());
					logged[2] = ((User) users.get(i)).getMail();
					flag = true;
					break;
				} else {
					flag = false;

				}
			} else if (users.get(i).getClass().getSimpleName().equalsIgnoreCase("admin")) {
				if (mail.equals(((Admin) users.get(i)).getMail())
						&& password.equals(((Admin) users.get(i)).getPassword())) {
					isLogged = true;
					logged[0] = users.get(i).getClass().getSimpleName();
					logged[1] = "0";
					logged[2] = ((Admin) users.get(i)).getMail();
					flag = true;
					break;
				} else {
					flag = false;

				}
			}

		}

		return flag;
	}

	// Control for place addition (only administrator can add a place)
	// If online user is administrator, the function returns true
	public boolean addPlace(String type) {// Control for person that add place(Admin)

		if (type.equalsIgnoreCase(logged[0]))
			return true;
		else
			return false;

	}

	// This function display all cities and its information
	public String displayCities() {

		return cities.toString();
	}
	
	// Get city name and location type
	// If there is a place of type, it will be printed
	// If type is null, it will be printed all places
	public String displayPlaces(String city_name, String type) {
		String retSt = "No place!";
		for (City city : cities) {
			if (city_name.equalsIgnoreCase(city.getCity_name())) {
				retSt = city.searchPlaces(type);
			}
		}
		return retSt;
	}
	
	// Necessary information are received for the user
	// Email check is done
	// If appropriate, the id is assigned for the new user and added to the user
	// text file

	public boolean signUp(String name, String surname, String mail, String password, String phone, String address,
			String interest1) throws IOException {
		int id = users.size() - 2;
		String[] phones = phone.split("-");
		String[] addresses = address.split(",");
		String[] interests3 = interest1.split(",");
		ArrayList<Place> favplace= new ArrayList();

		ArrayList<String> interest2 = new ArrayList<String>();
		for (int i = 0; i < interests3.length; i++) {
			interest2.add(interests3[i]);
		}

		boolean flag = true;
		for (Person person : users) {
			if (person.getClass().getSimpleName().equalsIgnoreCase("User")) {
				if (((User) person).getMail().equals(mail))
					flag = false;
			}
		}

		if (flag == true) {
			PersonAbstractFactory UserFactory = PersonFactoryProducer.getFactory("User");
			User user = UserFactory.getUser(id, name, surname, mail, password, new Phone(phones[0], phones[1], phones[2]),
					new Address(addresses[2], addresses[1], addresses[0]), interest2,favplace);
			users.add(user);

			String str = "user" + ";" + name + ";" + surname + ";" + mail + ";" + password + ";" + phone + ";" + id
					+ ";" + address + ";" + interest1 + ";";

			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("person.txt", true), "UTF-8");
			BufferedWriter fbw = new BufferedWriter(writer);
			fbw.newLine();
			fbw.write(str);
			fbw.close();
		}
		return flag;

	}
	
	// Text files need to be updated when new information is added
	// This function updates text files

	public void writeToTxt() throws IOException {
		// String arrayine satýrlarý at

		String[] arr = new String[users.size()];
		String str = "";
		int index = 0;
		for (Person p : users) {
			if (p.getClass().getSimpleName().equalsIgnoreCase("admin"))
				str = "admin" + ";" + ((Admin) p).getName() + ";" + ((Admin) p).getSurname() + ";"
						+ ((Admin) p).getMail() + ";" + ((Admin) p).getPassword() + ";;;;;";
			else if (p.getClass().getSimpleName().equalsIgnoreCase("user")) {
				String adres = ((User) p).getAddress().getAddress() + "," + ((User) p).getAddress().getTown() + ","
						+ ((User) p).getAddress().getCity();
				String intr = "";
				if (((User) p).getInterest() != null && ((User) p).getInterest().size() > 0) {
					for (String string : ((User) p).getInterest()) {
						intr += string + ",";
					}
					intr = intr.substring(0, intr.length() - 1);
				}
				String favs = "";

				if (((User) p).getFav_place() != null && ((User) p).getFav_place().size() > 0) {
					for (Place place : ((User) p).getFav_place()) {
						favs += place.getName() + ",";
					}
					favs = favs.substring(0, favs.length() - 1);
				}

				str = "user" + ";" + ((User) p).getName() + ";" + ((User) p).getSurname() + ";" + ((User) p).getMail()
						+ ";" + ((User) p).getPassword() + ";" + ((User) p).getPhone().toString() + ";"
						+ ((User) p).getUser_id() + ";" + adres + ";" + intr + ";" + favs;
			}
			arr[index] = str;

			OutputStreamWriter writer = null;
			if (index == 0)
				writer = new OutputStreamWriter(new FileOutputStream("person.txt", false), "UTF-8");
			else
				writer = new OutputStreamWriter(new FileOutputStream("person.txt", true), "UTF-8");
			BufferedWriter fbw = new BufferedWriter(writer);

			if (index == 0)
				fbw.write("type;name;surname;mail;password;phone;user_id;address;interest;fav_places");

			fbw.newLine();
			fbw.write(str);
			fbw.close();

			index++;
		}

	}
	
	// Only users can use this process
	// The comments entered by the users and the name of the place are taken
	// User id and comment are added to the list inside this place
	// It also written into the text file

	public void addComment(String place_name, String comment) throws IOException {

		if (logged[0].equalsIgnoreCase("user")) {
			for (int i = 0; i < places.size(); i++) {
				if (places.get(i).getName().equalsIgnoreCase(place_name)) {

					String str = place_name + ";" + logged[1] + ";" + comment;
					OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("comment.txt", true),
							"UTF-8");
					BufferedWriter fbw = new BufferedWriter(writer);
					fbw.newLine();
					fbw.write(str);
					fbw.close();

					if (places.get(i).getType().equalsIgnoreCase("TravelToVisit")) {
						((TravelToVisit) (places.get(i))).addComment(logged[1], comment);
					} else {
						((FoodAndDrink) (places.get(i))).addComment(logged[1], comment);
					}
				}
			}

		} else {
			System.out.println("Admin cannot add comment.");
		}

	}
	
	// This method filters the places in a city according to the sent facility

	public void searchFacilities(String city, String facility) {
		search = new ArrayList<Place>();
		for (int i = 0; i < places.size(); i++) {
			if (places.get(i).getAddress().getCity().equalsIgnoreCase(city)) {
				if ((places.get(i).getClass().getSimpleName().equalsIgnoreCase("TravelTovisit"))) {
					boolean[] facilities = ((TravelToVisit) places.get(i)).getFacilities();
					if ((facility.equalsIgnoreCase("Age Limit") && facilities[0])
							|| (facility.equalsIgnoreCase("Wi-Fi") && facilities[1])
							|| (facility.equalsIgnoreCase("Parking Place") && facilities[2])
							|| (facility.equalsIgnoreCase("Smoking") && facilities[3])
							|| (facility.equalsIgnoreCase("Pet Allowed") && facilities[4])) {
						search.add(places.get(i));
					}
				} else if (places.get(i).getClass().getSimpleName().equalsIgnoreCase("FoodAndDrink")) {
					boolean[] facilities = ((FoodAndDrink) places.get(i)).getFacilities();
					if ((facility.equalsIgnoreCase("Age Limit") && facilities[0])
							|| (facility.equalsIgnoreCase("Wi-Fi") && facilities[1])
							|| (facility.equalsIgnoreCase("Parking Place") && facilities[2])
							|| (facility.equalsIgnoreCase("Smoking") && facilities[3])
							|| (facility.equalsIgnoreCase("Pet Allowed") && facilities[4])) {
						search.add(places.get(i));
					}

				}
			}

		}

		// System.out.println(search.toString());

	}
	
	// When the setting check is true, person will be change their own information with newArg

	public void setBool(boolean setting, String type, String newArg) throws IOException {
		if (setting) {
			for (Person p : users) {
				if (p.getClass().getSimpleName().equalsIgnoreCase("user") && logged[0].equalsIgnoreCase("User")) {
					if (((User) p).getMail().equals(logged[2])) {
						if (type.equalsIgnoreCase("mail"))
							logged[2] = newArg;
						((User) p).settings(type, newArg);
						break;
					}
				} else if (p.getClass().getSimpleName().equalsIgnoreCase("admin")
						&& logged[0].equalsIgnoreCase("Admin")) {
					if (((Admin) p).getMail().equals(logged[2])) {
						if (type.equalsIgnoreCase("mail"))
							logged[2] = newArg;
						((Admin) p).settings(type, newArg);
						break;
					}
				}
			}
			writeToTxt();
		}

	}
	
	// When the favorite check is true, it adds the named place to the favorite
	// places of the online user

	public void favPlace(boolean favorite, String place_name) throws IOException {
		// eger swing ile place name çekemezsek güncel place deðiþkende tutulacak
		// sadece user yapabiliyor

		if (favorite && logged[0].equalsIgnoreCase("User")) {
			for (Person p : users)
				if (p.getClass().getSimpleName().equalsIgnoreCase("user") && ((User) p).getMail().equals(logged[2])) {
					for (Place place : places)
						if (place.getName().equalsIgnoreCase(place_name)) {
							((User) p).addFavPlace(place);
							break;
						}

				}

		}

		writeToTxt();

	}
	
	// This method sort places according to prices and the types of places in a city

	public void sortbyPrice(String city_name, String type) {

		places_q = new PriorityQueue<Place>(places.size(), new PriceComparator());

		for (City city : cities) {
			if (city_name.equalsIgnoreCase(city.getCity_name())) {
				for (Place place : city.getPlaces()) {
					if (type.equalsIgnoreCase(place.getType())) {
						places_q.add(place);
					}
				}
			}
		}

		temp = new PriorityQueue<Place>();
		temp = new PriorityQueue<Place>(places.size(), new PriceComparator());

	}
	
	//This method is used to find all the places inside a city.

	public void allPlaces(String city_name) {

		search = new ArrayList<Place>();
		for (int i = 0; i < places.size(); i++) {
			if (places.get(i).getAddress().getCity().equalsIgnoreCase(city_name)) {
				search.add(places.get(i));
			}

		}
	}
	
	// This method prints comments of the place searched

	public String displayComments(String placeName) {
		boolean test = false;
		String retStr = " ";
		ArrayList<String[]> display_comment = null;

		for (int i = 0; i < places.size(); i++) {
			if (places.get(i).getName().equals(placeName)) {

				if (places.get(i).getType().equals("TravelToVisit")) {
					display_comment = ((TravelToVisit) places.get(i)).getComments();
					for (String[] strings : display_comment) {

						for (int j = 0; j < users.size(); j++) {
							if (users.get(j).getClass().getSimpleName().equals("User")) {
								User user = (User) users.get(j);
								if (user.getUser_id() == Integer.valueOf(strings[0])) {
									retStr += user.getName().toUpperCase() + ": " + strings[1] + "\n";
									test = true;
								}

							}
						}
					}
				} else if (places.get(i).getType().equals("FoodAndDrink")) {
					display_comment = ((FoodAndDrink) places.get(i)).getComments();

					for (String[] strings : display_comment) {
						for (int j = 0; j < users.size(); j++) {
							if (users.get(j).getClass().getSimpleName().equals("User")) {

								User user = (User) users.get(j);

								if (user.getUser_id() == Integer.valueOf(strings[0])) {
									retStr += user.getName().toUpperCase() + ": " + strings[1] + "\n ";
									test = true;
								}

							}
						}
					}
				}

			}

		}

		if (test == true)
			return placeName + "\n" + retStr;
		else
			return "No Comment!";
	}

	// This informations are about addTravelToVisit,addFoodAndDrink,addAccommodation
	// Required information about place is taken
	// Its combined with the appropriate formats and the object is created
	// This object is added to the places list
	// It is also added to the text file with the appropriate format
	public void addPlaces(String name, String type, String address, String phone, String season, String information,
			int price, int distance_to_center, String facilities_st, int rate, String price_range, int star) throws IOException {

		String[] phones = phone.split("-");
		String[] addresses = address.split(",");
		String[] facility = facilities_st.split(",");

		boolean facilities[] = new boolean[facility.length];
		for (int i = 0; i < facility.length; i++) {
			if (facility[i].equalsIgnoreCase("yes")) {
				facilities[i] = true;
			} else
				facilities[i] = false;
		}
		
		
		
		Place place = FactoryPatternDemo(type, name,new Address(addresses[0], addresses[1], addresses[2]),
				new Phone(phones[0], phones[1], phones[2]), season,
				information, price,  distance_to_center, facilities,  rate, price_range,
				star);
		places.add(place);

		String str="";

		if (type.equalsIgnoreCase("TravelToVisit")) {
			str = "TravelToVisit" + ";" + name + ";" + address + ";" + phone + ";" + season + ";" + information + ";"
					+ price + ";" + distance_to_center + ";" + facilities_st + ";" + rate;
		} else if (type.equalsIgnoreCase("FoodAndDrink")) {
			str = "FoodAndDrink;" + name + ";" + address + ";" + phone + ";;;" + price_range + ";;" + facilities_st
					+ ";" + rate;
		} else if (type.equalsIgnoreCase("Accommodation")) {
			str = "Accommodation;" + name + ";" + address + ";" + phone + ";;;" + price_range + ";;;" + star;
		}

		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("places.txt", true), "UTF-8");
		BufferedWriter fbw = new BufferedWriter(writer);
		fbw.newLine();
		fbw.write(str);
		fbw.close();

	}

}
