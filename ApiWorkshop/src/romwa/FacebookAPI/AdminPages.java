package romwa.FacebookAPI;
import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Page;
import com.restfb.types.Post;

public class AdminPages {
	public static void main(String args[]) {
		String accessToken;
		FacebookClient fbClient;
		accessToken = "EAATuH33ASngBAFwnEpAebTsmpo5mw2prC3Gc6CCoEqqe2YAQCJw831A1f9U3ZA8GnvtK4gqvhdC0TuVa6AuLWcxpZB9mUPNxi86Sz9iVqOrHFj3q72AoQkANQFgWvNZBrrgM8dZCvDZCx8ULeduQANdDLSH4P5IwZD";
		fbClient = new DefaultFacebookClient(accessToken);

		Connection<Page> result = fbClient.fetchConnection("me/accounts", Page.class);

		int counter = 0; 

		for(List<Page> feedPage : result) {
			for(Page page : feedPage) {
				System.out.println(page.getName());
				System.out.println(page.getLikes());
				System.out.println("fb.com/"+page.getId());
				counter++;
			}
		}

		System.out.println("Counter = " + counter);

	}
}
