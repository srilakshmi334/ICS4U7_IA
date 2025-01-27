/**
 * The following sub-class for a student user inherits the super class GeneralUser
 * @author Sri
 *
 */
public class StudentUser extends GeneralUser {

	public StudentUser(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}
	
	public boolean GetIsStudent() {
		return true;
	}
}
