package jeffdev.authms;

import java.util.UUID;

public class User {
	private String id;
	private String username;
	private String password;

	public User(String username, String password) {
		this.id = UUID.randomUUID().toString();
		this.username = username;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void changePassword(String newPassword) {
		if (newPassword == null || newPassword.isBlank()) {
			throw new IllegalArgumentException("A senha não pode ser vazia");
		}
		this.password = newPassword;
	}

	public boolean isValidPassword(String password) {
		return this.password.equals(password);
	}
}
