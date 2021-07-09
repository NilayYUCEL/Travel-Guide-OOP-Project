
public class Admin implements Person  {
	private String name;
	private String surname;
	private String mail;
	private String password;

	public Admin(String name, String surname, String mail, String password) {
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.password = password;
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

	@Override
	public String toString() {
		return "Admin [name=" + name + ", surname=" + surname + ", mail=" + mail + ", password=" + password + "]";
	}

	

	public void settings(String var_type, String new_info) {
		if (var_type.equalsIgnoreCase("name")) {
			setName(new_info);
		} else if (var_type.equalsIgnoreCase("surname")) {
			setSurname(new_info);
		} else if (var_type.equalsIgnoreCase("mail")) {
			setMail(new_info);
		} else if (var_type.equalsIgnoreCase("password")) {
			setPassword(new_info);
		}

	}

}
