import java.util.ArrayList;

public class AdminFactory implements PersonAbstractFactory{

	@Override
	public Admin getAdmin(String name, String surname, String mail, String password) {
		return new Admin(name,surname,mail,password);
	}

	@Override
	public User getUser(int user_id, String name, String surname, String mail, String password, Phone phone, Address address,
			ArrayList<String> interest, ArrayList<Place> fav_place) {
		return null;
	}


}
