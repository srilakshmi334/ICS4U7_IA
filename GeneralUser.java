/**
 * The following super class is for a general program user
 * @author Sri
 *
 */
public class GeneralUser {
	
	private String username;
	private String password;
	
	public GeneralUser(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean GetIsStudent() {
		return false;
	}
}
