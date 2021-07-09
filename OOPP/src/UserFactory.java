import java.util.ArrayList;

public class UserFactory implements PersonAbstractFactory {

	@Override
	public Admin getAdmin(String name, String surname, String mail, String password) {
		return null;
	}

	@Override
	public User getUser(int user_id, String name, String surname, String mail, String password, Phone phone, Address address,
			ArrayList<String> interest, ArrayList<Place> fav_place) {
		return new User(user_id,name,surname,mail,password,phone,address,interest,fav_place);
	}


}
