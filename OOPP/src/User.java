
import java.util.ArrayList;

public class User implements Person {

	private int user_id;
	public String name;
	public String surname;
	public String mail;
	public String password;
	private Phone phone;
	private Address address;
	private ArrayList<String> interest;
	private ArrayList<Place> fav_place;

	public User(int user_id, String name, String surname, String mail, String password, Phone phone, Address address,
			ArrayList<String> interest, ArrayList<Place> fav_place) {
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.interest = interest;
		this.fav_place = fav_place;
		this.user_id = user_id;
	}


	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ArrayList<String> getInterest() {
		return interest;
	}

	public void setInterest(ArrayList<String> interest) {
		this.interest = interest;
	}

	public ArrayList<Place> getFav_place() {
		return fav_place;
	}

	public void setFav_place(ArrayList<Place> fav_place) {
		this.fav_place = fav_place;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", surname=" + surname + ", mail=" + mail + ", password="
				+ password + ", phone=" + phone.toString() + ", address=" + address.toString() + ", interest="
				+ interest + ", fav_place=" + fav_place + "]";
	}

	public void addFavPlace(Place place_name) {

        fav_place.add(place_name);
    }



	
	public void settings(String var_type,String new_info) {
        if (var_type.equalsIgnoreCase("name")) {
            setName(new_info);
        } 
        else if (var_type.equalsIgnoreCase("surname")) {
            setSurname(new_info);
        } 
        else if (var_type.equalsIgnoreCase("mail")) {
            setMail(new_info);
        } 
        else if (var_type.equalsIgnoreCase("password")) {
            setPassword(new_info);
        }
        else if (var_type.equalsIgnoreCase("phone")) {
            String[] phones = new_info.split("-");
            setPhone(new Phone(phones[0],phones[1],phones[2]));
        }
        else if (var_type.equalsIgnoreCase("address")) {
            String[] addresses = new_info.split(",");
            setAddress(new Address(addresses[2],addresses[1],addresses[0]));
        }
    }


}
