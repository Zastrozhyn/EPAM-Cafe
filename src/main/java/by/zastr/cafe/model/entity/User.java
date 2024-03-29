package by.zastr.cafe.model.entity;

/**
 * The Class User.
 *
 * @author A.Zastrozhyn
 */
public class User extends CafeEntity {
	private int userId;
	private String name;
	private String lastName;
	private String phone;
	private String email;
	private String login;
	private Role role;
	private Account account;
	private boolean	archive;
	

	/**
	 * User Role.
	 *
	 * @author A.Zastrozhyn
	 */
	public enum Role{
		
		/** The guest. */
		GUEST,
		
		/** The client. */
		CLIENT,
		
		/** The admin. */
		ADMIN;
	}

	/**
	 * Instantiates a new user.
	 */
	public User() {
		super();
	}
	
	/**
	 * Instantiates a new user.
	 *
	 * @param userId the user id
	 * @param name the name
	 * @param lastName the last name
	 * @param phone the phone
	 * @param email the email
	 * @param login the login
	 * @param role the role
	 * @param account the account
	 */
	public User(int userId, String name, String lastName, String phone, String email, String login, Role role, Account account) {
		super();
		this.userId = userId;
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.login = login;
		this.role = role;
		this.account = account;
	}
	
	/**
	 * Gets the user id.
	 *
	 * @return userId
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Gets the name.
	 *
	 * @return User name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the last name.
	 *
	 * @return Last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the phone.
	 *
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the email.
	 *
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the login.
	 *
	 * @return login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * Sets the login.
	 *
	 * @param login the new login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * Gets the role.
	 *
	 * @return role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * Gets the account.
	 *
	 * @return account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * Sets the account.
	 *
	 * @param account the new account
	 */
	public void setAccount(Account account) {
		this.account = account;
	}
	
	/**
	 * Checks if is archive.
	 *
	 * @return is archive User
	 */
	public boolean isArchive() {
		return archive;
	}

	/**
	 * Sets the archive.
	 *
	 * @param archive the new archive
	 */
	public void setArchive(boolean archive) {
		this.archive = archive;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + (archive ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + userId;
		return result;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (account == null) {
			if (other.account != null) {
				return false;
			}
		} else if (!account.equals(other.account)) {
			return false;
		}
		if (archive != other.archive) {
			return false;
		}
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (login == null) {
			if (other.login != null) {
				return false;
			}
		} else if (!login.equals(other.login)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (phone == null) {
			if (other.phone != null) {
				return false;
			}
		} else if (!phone.equals(other.phone)) {
			return false;
		}
		if (role != other.role) {
			return false;
		}
		if (userId != other.userId) {
			return false;
		}
		return true;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=");
		builder.append(userId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", email=");
		builder.append(email);
		builder.append(", login=");
		builder.append(login);
		builder.append(", role=");
		builder.append(role);
		builder.append(", account=");
		builder.append(account);
		builder.append(", archive=");
		builder.append(archive);
		builder.append("]");
		return builder.toString();
	}	
}
