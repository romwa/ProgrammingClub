package romwa.Wiki;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

import javax.security.auth.login.FailedLoginException;

import org.wikipedia.Wiki;

public class BaconNum {

	public BaconNum() {
		int ans = 0;
		Wiki wiki = new Wiki("en.wikipedia.org");		//connects to wiki
		try {

			//login to wiki
			try {
				wiki.login("alistairgray42", "ProClub");
			} catch (FailedLoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String startLink = "Key";
			String endLink = "Key, Alabama";

			HashSet<String> visitedArticles = new HashSet<String>();

			PriorityQueue<Article> queue = new PriorityQueue<Article>(new Comparator<Article>() {

				@Override
				public int compare(Article o1, Article o2) {
					return Integer.compare(o1.order, o2.order);
				}

			});

			Article start = new Article(0, startLink);
			queue.add(start);

			while (!queue.isEmpty()) {
				Article current = queue.poll();

				if (visitedArticles.contains(current.title)) {
					continue;
				}

				visitedArticles.add(current.title);

				if (current.title.equals(endLink)) {
					ans = current.order;
					break;
				}

				ArrayList<String> str = new ArrayList<String>(Arrays.asList(wiki.getLinksOnPage(current.title)));

				for (String s: str) {
					if (!visitedArticles.contains(s)) {
						queue.add(new Article(current.order + 1, s));
					}
				}
			}

			System.out.println(ans);





		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

