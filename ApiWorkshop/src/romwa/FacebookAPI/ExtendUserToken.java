package romwa.FacebookAPI;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.FacebookClient.AccessToken;
import com.restfb.types.User;

public class ExtendUserToken {
	
	
	
	public static void main(String args[]) {
		String accessToken;
		FacebookClient fbClient;
		accessToken = "EAATuH33ASngBAFwnEpAebTsmpo5mw2prC3Gc6CCoEqqe2YAQCJw831A1f9U3ZA8GnvtK4gqvhdC0TuVa6AuLWcxpZB9mUPNxi86Sz9iVqOrHFj3q72AoQkANQFgWvNZBrrgM8dZCvDZCx8ULeduQANdDLSH4P5IwZD";
		fbClient = new DefaultFacebookClient(accessToken);
		AccessToken exToken = fbClient.obtainExtendedAccessToken("1387718927993464", "133aa3816e85b605daf35281d8b88a36");
		System.out.println(exToken.getAccessToken());
		System.out.println(exToken.getExpires());
	}
}
