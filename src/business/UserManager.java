package business;

import beans.User;
import data.UserDataService;

public class UserManager implements UserManagerInterface{
	
	UserDataService uds = new UserDataService();

	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return this.uds.findBy(user);
	}
	
	public User getUser(User user) {
		
		if(this.uds.findBy(user) != null) {
			return this.uds.findBy(user);
		}else {
			System.out.println("User Not Found");
			return null;
		}
	}

}
