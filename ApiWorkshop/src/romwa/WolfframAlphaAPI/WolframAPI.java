package romwa.WolfframAlphaAPI;
import proclub.members.ProClub;
import proclub.wolfram.*;

public class WolframAPI {
	public static void main(String argsp[]) {
		WolframAlpha wa = new WolframAlpha();
		wa.auth();
		wa.prepareQuery("Albums by the beatles");
		WolframResponse wr = wa.executeQuery();
		String output = wr.getPod("Results").replaceAll("release date", "");
		String results[] = output.split("\\|");
		for(int i = 0; i < results.length; i++) {
			System.out.println(results[i]);
		}
	}
}
