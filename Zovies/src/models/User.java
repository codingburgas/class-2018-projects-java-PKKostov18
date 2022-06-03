package models;

import java.util.Objects;

public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private String salt;
    private boolean admin;
    
    //Constructor
   
    public User(int userId, String firstName, String lastName, String username, String email, String password, String salt,
			boolean admin) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.salt = salt;
		this.admin = admin;
	}

    // Getters and Setters
   
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}
	
    public boolean getAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getUserId() {
		return userId;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public String toString() {
        return "User{" +
        		" userId = " + userId +
                " firstName = " + firstName + '\'' +
                ", lastName = " + lastName + '\'' +
                ", email = " + email + '\'' +
                ", username = " + username + '\'' +
                ", password = " + password + '\'' +
                ", admin = " + admin +
                '}';
    }
}