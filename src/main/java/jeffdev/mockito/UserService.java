package jeffdev.mockito;

public class UserService {
	private Database database;

	public UserService(Database database) {
		this.database = database;
	}

	public String getUserStatus(int id) {
		return database.getStatus(id);
	}
}
