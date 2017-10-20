package romwa.FacebookAPI;

import com.restfb.*;
import com.restfb.types.User;

public class FacebookAPI {
	String accessToken;
	FacebookClient fbClient;
	User me;
	String name;
	
	public FacebookAPI() {
		accessToken = "EAATuH33ASngBAC4zlZBSXbJuX6IP7eJ20urHch7LnpPnZCHBFZBA72tOSjIKoZCQLAppLWGcK4NLwHCEnrivq5mb9Gazq3zi794pzHftdvTPCOewaM5JsfeBNvb1ZBZAl3EttwkHO8zZCBmkprkpN6mcYVunQxo9MebmYCC2JVsu52i8fJPzcwr0wdeczonOdqKiMFBYqrUpwZDZD";
		fbClient = new DefaultFacebookClient(accessToken);
		me = fbClient.fetchObject("me", User.class);
		name = me.getName();
	}
	
	public String getToken() {
		return accessToken;
	}
	
	public FacebookClient getFaceClient() {
		return fbClient;
	}
	
	public User getUser() {
		return me;
	}
	
	public String getName() {
		return me.getName();
	}
}
