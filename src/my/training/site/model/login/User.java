package my.training.site.model.login;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	private static String DEFAULT_AUTHORITY = "ROLE_USER";
	private static boolean DEFAULT_STATUS = false;
	
	private int id;
	
	@Size(min = 5, max = 20, message = "count of characters must be between 5 and 20")
	@Pattern(regexp ="[A-Za-z0-9\\._-]++", message = "Illegal characters were found")
	@NotNull(message = "This field could not be empty")
	private String login;
	
	@Size(min = 5, max = 20, message = "count of characters must be between 5 and 20")
	@NotNull(message = "This field could not be empty")
	private String password;
	
	
	@Pattern(regexp = "^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+(\\.[(a-zA-z)]{2,3}){1,2}$",
			message = "Invalid email address")
	@NotNull(message = "This field could not be empty")
	@Size(min = 5, max = 20, message = "count of characters must be between 5 and 20")
	private String email;
	
	private String authority;
	private boolean enabled;

	
	public User(){
		this.authority = User.DEFAULT_AUTHORITY;
		this.enabled = User.DEFAULT_STATUS;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
