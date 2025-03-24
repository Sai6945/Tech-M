package Day1;

public final class Configuration {
	private final String dbUrl;
	private final String admin;
	private final String pass;
	public Configuration(String dbUrl,String admin,String pass){
		this.dbUrl=dbUrl;
		this.admin=admin;
		this.pass=pass;
		
	}
	public String getdbUrl() {
		return dbUrl;
	}
	public String getadmin() {
		return admin;
	}
	public String pass() {
		return pass;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c=new Configuration("jdbc:mysql://localhost", "admin", "password123");
				System.out.println(c.getdbUrl());
				System.out.println(c.getadmin());
			

	}

}
