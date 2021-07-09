
public class PersonFactoryProducer {

	public static PersonAbstractFactory getFactory(String choice) {
		if (choice.equalsIgnoreCase("Admin")) {
			return new AdminFactory();
		} else if (choice.equalsIgnoreCase("User")) {
			return new UserFactory();
		}
		return null;
	}

}
