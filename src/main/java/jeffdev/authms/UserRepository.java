package jeffdev.authms;

public interface UserRepository {
	void save(User user);

	User findByUsername(String username);
}
