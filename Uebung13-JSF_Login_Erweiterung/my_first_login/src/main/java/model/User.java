package model;

import javax.faces.context.FacesContext;

/**
* @author Yehezkel Sivan
* @version 16.06.2016 v1.0
*/
public class User {
	private String name;
	private String password;
	private boolean loggedIn;

	public User() {
		loggedIn = false;
	}

	/**
	 * @return the loggedIn
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() {
		String ret = "failed";
		if(password.equals("password")&& name.equals("name")){
			loggedIn = true;
			return "success";
		}else{
			return ret;
		}	
	}

	public String logout() {
		loggedIn = false;
		// This session is now invalid!
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "logout";
	}
}