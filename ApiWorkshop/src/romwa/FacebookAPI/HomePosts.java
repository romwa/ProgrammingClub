package romwa.FacebookAPI;
import java.util.List;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Post;

public class HomePosts {

	public static void main(String[] args) {
		String accessToken;
		FacebookClient fbClient;
		accessToken = "EAACEdEose0cBAFpIXzYFbMmClQ3M5tohZAlpgnJqIiUED76KcA6E9lGAwgZCWpsQitMRppSKtF46Evgufv4LbjiKfZByGEWnMptzkT6zJngTqm9YXWXS0SMsGQW5wbQdkOs8B3uXYeUmxHfYAjDXzFr63KpIAkqk1lJTDBsvlTKj3yoGL5dxc7jnsEoNKZCDw4rEpONw2QZDZD";
		fbClient = new DefaultFacebookClient(accessToken);

		Connection<Post> result = fbClient.fetchConnection("me/home", Post.class);

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
