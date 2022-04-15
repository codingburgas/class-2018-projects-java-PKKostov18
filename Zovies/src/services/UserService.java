package services;

import java.util.List;
import java.util.stream.Collectors;

import repositories.UserRepository;

public class UserService {
	
	private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUsersWithLongUsername() {
        // 1. Get all users
        List<User> users = userRepository.getUsers();
        // 2. Filter only those users that have username length bigger than 5 characters
        users = users.stream().filter(user -> user.getUsername().length() > 5).collect(Collectors.toList());
        // 3. Convert the result to string representation and return it
        return users.toString();
    }
}
