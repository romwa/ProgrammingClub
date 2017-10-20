package romwa.FacebookAPI;

import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Post;

public class TimeLinePost {

	public static void main(String args[]) {
		String accessToken;
		FacebookClient fbClient;
		accessToken = "EAATuH33ASngBAFwnEpAebTsmpo5mw2prC3Gc6CCoEqqe2YAQCJw831A1f9U3ZA8GnvtK4gqvhdC0TuVa6AuLWcxpZB9mUPNxi86Sz9iVqOrHFj3q72AoQkANQFgWvNZBrrgM8dZCvDZCx8ULeduQANdDLSH4P5IwZD";
		fbClient = new DefaultFacebookClient(accessToken);
		
		Connection<Post> result = fbClient.fetchConnection("me/feed", Post.class);
		
		int counter = 0; 
		
		for(List<Post> page : result) {
			for(Post aPost : page) {
				System.out.println(aPost.getMessage());
				System.out.println("fb.com/"+aPost.getId());
				counter++;
			}
		}
		
		System.out.println("Counter = " + counter);
	}
}
