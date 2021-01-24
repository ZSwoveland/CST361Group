package controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import beans.User;
import business.UserManager;

@ManagedBean(name="userController")
@SessionScoped
public class UserController {
	
	UserManager um = new UserManager();
	
	public String onRegister(User user) {
		this.um.addUser(user);
		return "Login.xhtml";
	}
	
	public String onLogin(User user) {
		ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
		
		if(this.um.getUser(user) != null) {
			ctx.getRequestMap().put("user", this.um.getUser(user));
			return "UserHome.xhtml";
		} else {
			ctx.getRequestMap().put("message", "Email or Password was incorrect");
			return "Login.xhtml";
		}
		
	}

}
