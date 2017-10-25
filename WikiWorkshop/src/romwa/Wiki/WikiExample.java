package romwa.Wiki;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.wikipedia.Wiki;

import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;

public class WikiExample {

	public WikiExample() {
		Wiki wiki = new Wiki("en.wikipedia.org");		//connects to wiki
		try {

			//login to wiki
			try {
				wiki.login("alistairgray42", "ProClub");
			} catch (FailedLoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//get links from "Stack Overflow" wiki page
			String initial = "League of Legends";		//initial article
			String end = "Yasuo";			//end article	
			ArrayList<String> str = new ArrayList<String>(Arrays.asList
					(wiki.getLinksOnPage(initial)));
			for(int i = 0; i < str.size(); i++) {		//remove anything that not falls
				if(str.get(i).contains(":")) {			//into the category
					str.remove(i);
					i--;
				}
			}

			//finding the right article
			boolean gate = true; //True if target article not found; controls loop
			String currentArticle = initial; //Article the loop is on
			int currentIndex = 0; //A counter
			while(gate) {
				//remove non related articles
				ArrayList<String> currentArticleStrings = new ArrayList <String>(Arrays.asList(wiki.getLinksOnPage(currentArticle)));
				for(int i = 0; i < currentArticleStrings.size(); i++) {
					if(currentArticleStrings.get(i).contains(":")) {
						currentArticleStrings.remove(i);
						i--;
					}
				}

				//get a random article, if has links set to current article
				int rand = (int)(Math.random() * (currentArticleStrings .size()-1));		
				if(!(wiki.getLinksOnPage(currentArticleStrings.get(rand)) .length == 0)) {
					currentArticle = currentArticleStrings.get(rand);
					currentIndex++;
				}

				System.out.println("Current Article - " + currentArticle + "\nCurrent Index - " + currentIndex);


				if(currentArticle.equals(end)) {
					gate = false;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}




