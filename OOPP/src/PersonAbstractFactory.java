import java.util.ArrayList;

public interface PersonAbstractFactory {
	
	public Admin getAdmin(String name, String surname, String mail, String password);
	public User getUser(int user_id, String name, String surname, String mail, String password, Phone phone, Address address,
			ArrayList<String> interest, ArrayList<Place> fav_place);

}
