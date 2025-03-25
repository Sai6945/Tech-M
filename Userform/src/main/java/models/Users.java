package models;
 
public class Users {
	private String name;
	private String email;
	public Users(String name,String email) {
		this.name=name;
		this.email=email;
	}
	public String getName() {return name;}
	public String getEmail() {return email;}
}
 