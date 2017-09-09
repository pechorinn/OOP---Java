package docs;

public class SecretDocument extends Document {
	
	private String password;

	public SecretDocument(String password) {
		super();
		if(password == null || password.isEmpty() || password.length() < 5) {
			throw new IllegalArgumentException();
		}
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	
	
		

}
